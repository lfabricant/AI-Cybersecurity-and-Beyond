import java.io.*;
import java.util.*;
public class ID3
{
    static Node node;
    static Tree tree;
    public Node runID3(List<ArrayList<String>> data, Node node, Tree tree, String str){
        System.out.println("*******" + node.getValue() + "********");
        printArrayList(data);
        if(areOutputValuesEqual(data)){
            System.out.println(node.getValue());
            Node n = new Node(getOutputValue(data));
            Node n2 = new Node("Is " + str + "?"); 
            System.out.println("Adding this node to the tree below! " + n2.getValue());
            n2.addChild(n);
            node.addChild(n2);
            node.print();
        } else {
            int lastColumn = data.get(0).size()-1;
            double entropyPlay = entropyInColumn(data, lastColumn);
            List<String> headers = data.get(0).subList(0,(data.get(0).size())-1);
            double highestInformationGain = 0.0;
            int headerIndex = 0;
            for(int i = 0; i < headers.size(); i++) {
                List<String> outputs = getUniqueAttributes(data, i);
                int tableSize = data.size()-1;
                double calculatingGain = 0.0;                
                for(String s: outputs){
                    List<ArrayList<String>> newData = copyList(data);
                    newData = splitTableOnItem(newData, i, s); 
                    System.out.println("*****");
                    printArrayList(newData);
                    int yes = getValuesTotalWithTarget(newData, "Yes");
                    int no = getValuesTotalWithTarget(newData, "No");
                    int total = yes + no;
                    double e = calculateEntropy(yes, total);
                    System.out.println("ENTROPY FOR " + s + ": " + e);
                    double g = total/(double)tableSize*e;
                    calculatingGain += g;
                    double gain = entropyPlay-calculatingGain;
                }
                double gain = entropyPlay-calculatingGain;
                if(gain >= highestInformationGain){
                    highestInformationGain = gain;
                    headerIndex = i;
                } 
            }
            System.out.println("highest Gain: " + highestInformationGain + " Header Index and title of header: " + headerIndex + " " + data.get(0).get(headerIndex));
            Node n = new Node(data.get(0).get(headerIndex));
            if(node.getValue().equals("Tree")){
                node.setValue(data.get(0).get(headerIndex));
                node = n;
            } else {
                data = removeColumn(data, data.get(0).indexOf(node.getValue())); 
                //printArrayList(data);
                System.out.println("Node value: " + data.get(0).indexOf(node.getValue()));
                Node n2 = new Node("Is " + str + "?"); 
                System.out.println("Adding this node to the tree below! " + n2.getValue());
                n2.addChild(n);
                node.addChild(n2);
                node.print();
            }
            List<String> outputs = getUniqueAttributes(data, data.get(0).indexOf(n.getValue()));   
            for(String s: outputs){
                //System.out.println(s);
                List<ArrayList<String>> newData = copyList(data);
                newData = splitTableOnItem(newData, data.get(0).indexOf(n.getValue()), s); 
                //printArrayList(newData);
                node.print();
                runID3(newData, n, tree, s);
            }
        }
        //System.out.println();
        //node.print();
        return node;
    }
    public String getOutputValue​(List<ArrayList<String>> data){
      int rowSize = data.get(0).size();
      String outputValue = data.get(1).get(rowSize-1);
      return outputValue;
    }
    public List<ArrayList<String>> removeColumn(List<ArrayList<String>> data, int coltoremove) {
        List<ArrayList<String>> subData = new ArrayList<ArrayList<String>>();            
        for(int r = 0; r <data.size();r++){
            subData.add(new ArrayList<String>());
            for(int col = 0; col < data.get(r).size(); col++){
                if(col != coltoremove){
                    subData.get(r).add(data.get(r).get(col));
                }
            }
        }     
        return subData;
    }
    public boolean areOutputValuesEqual​(List<ArrayList<String>> newdata){
        int rowSize = newdata.get(0).size();
        String last = newdata.get(1).get(rowSize-1);
        for(int i = 1; i < newdata.size(); i++){
          String check = newdata.get(i).get(rowSize-1);
          if(!last.equals(check)){
            return false;
          }
        }
        return true;
    }
    public int getValuesTotalWithTarget​(List<ArrayList<String>> data, String output){
        ArrayList<String> outputValues = data.get(data.size()-1);
        int count = 0;
        for(int i = 1; i <= data.size()-1; i++){
             if(data.get(i).get(data.get(0).size()-1).equals(output)){
                count++;
             }
         }
        return count;
    }
    public List<ArrayList<String>> copyList(List<ArrayList<String>> data){
      List<ArrayList<String>> copyList = new ArrayList<ArrayList<String>>();
      for(int i = 0; i < data.size(); i++){
        copyList.add(new ArrayList<String>());
        for(int j = 0; j < data.get(i).size(); j++){
          copyList.get(i).add(data.get(i).get(j));
        }        
      }
      return copyList;
    } 
    public List<ArrayList<String>> splitTableOnItem​(List<ArrayList<String>> subdata, int coltofilter, String itemtosplit){
          for(int i = subdata.size()-1; i > 0; i--){
             if(!subdata.get(i).get(coltofilter).equals(itemtosplit)){
                  subdata.remove(i);
             }
          }
          return subdata;
    }
    public List<String> getUniqueAttributes​(List<ArrayList<String>> dataTable, int colnum){
       List<String> col = new ArrayList<>();
       for(int i = 1; i<dataTable.size(); i++){
          if(!col.contains(dataTable.get(i).get(colnum)))
             col.add(dataTable.get(i).get(colnum)); 
       }
       return col;
    }
    public double entropyInColumn​(List<ArrayList<String>> data, int colnum){
       if(areOutputValuesEqual(data)) {
           return 0;
       } else {
           List<String> col = getColumn(data, colnum);
           double numYes=0;
           double numNo=0;
           for(String s: col){
             if(s.toLowerCase().equals("yes")){
               numYes++;
             }
             if(s.toLowerCase().equals("no")){
               numNo++;
             }
           }
           return calculateEntropy(numYes,(numYes+numNo));
       }
    }  
    public double calculateEntropy​(double items, double totalItems){
       if(items == 0 || items == totalItems){
            return 0; 
       } else {
            return -(items/totalItems) * (Math.log(items/totalItems) 
            / Math.log(2)) - ((totalItems-items)/totalItems) * 
            (Math.log((totalItems-items)/totalItems) / Math.log(2));
       }
    }
    public List<String> getColumn(List<ArrayList<String>> dataTable, int colNum){
       ArrayList<String> col = new ArrayList<>();
       for(int r = 0; r < dataTable.size() ; r++){
         col.add(dataTable.get(r).get(colNum));
       }
       return col;
    } 
    public List<ArrayList<String>> loadCSV(String path) throws FileNotFoundException {
       File file = new File(path);
       Scanner scan = new Scanner(file);
       List<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();
       while (scan.hasNextLine()){ 
            String stringLine = scan.nextLine();
            String[] arrayLine = stringLine.split(",");
            ArrayList<String> lineList = new ArrayList<String>();
            for(String s:arrayLine){
                lineList.add(s);
            }
            lines.add(lineList);
       }
        return lines;
    } 
    public static void printArrayList​(List<ArrayList<String>> data){
        int c = 0;
        List<Integer> length = findLength(data);
        System.out.println(borderList(data)); 
        for(ArrayList<String> r : data) {   
             ArrayList<Integer> lengths = new ArrayList<Integer>();    
             for (String val : r) {
                    int l = val.length();
                    int spaces = length.get(c)-l;
                    lengths.add(l+2+spaces);  
                    System.out.print("| ");
                    for(int i = 0; i < spaces/2; i++){
                        System.out.print(" ");
                    }
                    System.out.print(val);
                    for(int i = 0; i < spaces/2; i++){
                        System.out.print(" ");
                    }
                    if(spaces%2 != 0){
                        System.out.print(" ");
                    }
                    System.out.print(" ");
                    c++;
             }
             System.out.print("|");
             c = 0;
             System.out.println(); 
             System.out.print(borderList(data)); 
             System.out.println();
        } 
    }
    public static String borderList(List<ArrayList<String>> data){
      String s = ""; 
      List<Integer> length = findLength(data); 
      ArrayList<Integer> lengths = new ArrayList<Integer>(); 
      for(int c = 0; c < data.get(0).size(); c++){
        String val = data.get(0).get(c); 
        int l = val.length(); 
        int spaces = length.get(c)-l;
        lengths.add(l+2+spaces);   
      }                 
      s += "+";
      for(int i: lengths){
        for(int j = 0; j < i; j++){ 
          s += "-";
        }  
          s += "+";
      }
      return s;
    }
    public static List<Integer> findLength(List<ArrayList<String>> data) {
        int c = 0;
        List<Integer> length = new ArrayList<Integer>();
        for(ArrayList<String> r : data) {
            for (String val : r) {
                if(length.size() <= c) {
                    length.add(val.length());
                }
                else if (val.length() > length.get(c)) {
                    length.set(c, val.length());
                }
                c++;
            }
            c=0;
        }
        return length;
    }
}
