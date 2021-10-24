import java.util.*;
import java.io.*;

class cowphabet {
  public static void main(String[] args) {
    /* index Of list test
    String[] list = new String[]{"heyyy","hi"};
    System.out.println(Arrays.asList(list).indexOf("hi"));//Works!!! nice yayyy
    */
    
    Scanner sc = new Scanner(System.in);
    String cowphabet = sc.next();
    String line = sc.next();
    sc.close();
    int res = cowphy(cowphabet, line);
    System.out.println(res);
    
  }
  
  // runtime = 26 * n = O(n) = linear time
  public static int cowphy(String alphy, String word){
    int prev = -1;
    int counter = 1;
    for (int i = 0; i < word.length(); i++){
      int index = alphy.indexOf(word.charAt(i));
      //String next = word.substring(i+1, i+2);
      if (index > prev){ // same iteration 
        prev = index;
      }else{ // different iteration
        prev = index;
        counter++;
      }
      
    }
    
    
    return counter;
    
  }
}
