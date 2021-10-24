/**
 * Write a description of class RecursionPractice here.
 *
 * @author (Lindsay Fabricant)
 * @version (9/20/20)
 */
public class RecursionPractice
{
    public static void main(String[] args){
        System.out.println("2 raised to the 3rd power is " + power(2,3));
        System.out.println("2 raised to the 1st power is " + power(2,1));
        System.out.println("2 raised to the 0th power is " + power(2,0));
        System.out.println("2 raised to the 5th power is " + power(2,5));
        System.out.println();
        
        int[] array = {11,12,4};
        System.out.println("Number of 11's in the array: " + array11(array,0));
        System.out.println("Number of 12's in the array: " + array12(array,0));
        System.out.println();
        
        System.out.println("BIG DIST");
        System.out.println(bigDist("catcowcat", "cat")); //→ 9
        System.out.println(bigDist("catcowcat", "cow")); //→ 3
        System.out.println(bigDist("cccatcowcatxx", "cat")); //→ 9
        System.out.println(bigDist("xyx", "z")); //→ 0
        System.out.println(bigDist("", "z")); //→ 0
        
        System.out.println("NUM CHARS");
        System.out.println(numChars("carrot", 'r'));
        System.out.println(numChars("carrot", 't'));
    }
    public static int power(int base, int exponent){
        if (exponent == 0){
            return 1;
            
        } else {
            // System.out.println("base " + base + " exp " + exponent);
            return base*power(base, exponent-1);
        }
    }
    public static int array11(int[] arr, int i){
        if (i < arr.length){ // test for base case
            if(arr[i] == 11){
                return 1 + array11(arr, i+1);
            } else {
                return 0 + array11(arr, i+1);
            }
        } else {
            return 0; // return value of base case
        }
    }
    public static int array12(int[] arr, int i){
        if (i == arr.length){ // test for base case
            return 0;
        }
        return(arr[i] == 11 ? 1 : 0) + array12(arr, i+1);
        // goes through index 1 for true 0 if false
    }
    public static int bigDist(String str, String sub) {
        //System.out.println(str);
         if(str.length() <= sub.length()){
             if(str.equals(sub)){
                 return str.length();
             } else {
                 return 0;
             }
         } else {
            String firstString = str.substring(0,sub.length());
            String lastString = str.substring(str.length()-sub.length(),str.length());
            //System.out.println("F " + firstString + " L " + lastString);
            if(firstString.equals(sub) && lastString.equals(sub)){
                return str.length();
            } else {
                String s = str.substring(1,str.length()-1);
                return bigDist(s, sub);
            }
        }
    }
    public static int numChars(String str, char c){
        //System.out.println(str);
        if(str.length() == 0){
            return 0;
        } else {
            if(str.substring(0,1).equals(Character.toString(c))){
                //System.out.print("*");
                return 1 + numChars(str.substring(1), c);
            } else { 
                return 0 + numChars(str.substring(1), c);
            }
        }
    }
}

