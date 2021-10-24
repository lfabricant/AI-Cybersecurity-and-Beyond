/**
 * Write a description of class RecursionPractice here.
 *
 * @author (Lindsay Fabricant)
 * @version (9/23/20)
 */
public class BigDistClasswork
{
    public static void main(String[] args){
        bigDistTester();
        System.out.println();
        
        // test bigDist2
        System.out.println(bigDist2("catcowcat", "cat")); //→ 9
        System.out.println(bigDist2("catcowcat", "cow")); //→ 3
        System.out.println(bigDist2("cccatcowcatxx", "cat")); //→ 9
        System.out.println(bigDist2("xyz","z")); //→ 1
        System.out.println(bigDist2("xyx", "z")); //→ 0
        System.out.println(bigDist2("", "z")); //→ 0
    }
    public static void bigDistTester(){
        System.out.println("bigDist(\"catcowcat\", \"cat\") → 9 ...actual result..." + bigDist("catcowcat","cat"));
        System.out.println("bigDist(\"catcowcat\", \"cow\") → 3 ...actual result..." + bigDist("catcowcat","cow"));
        System.out.println("bigDist(\"cccatcowcatxx\", \"cat\") → 9 ...actual result..." + bigDist("cccatcowcatxx","cat"));
        System.out.println("bigDist(\"xyz\", \"z\") → 1 ...actual result..." + bigDist("xyz","z"));
        System.out.println("bigDist(\"xyx\", \"z\") → 0 ...actual result..." + bigDist("xyx","z"));
        System.out.println("bigDist(\"\", \"z\") → 0 ...actual result..." + bigDist("","z"));
    }

    public static int bigDist(String str, String sub) {
        if(str.length() < sub.length()){
            return 0;
        } else {
            String firstString = str.substring(0,sub.length());
            String lastString = str.substring(str.length()-sub.length(),str.length());
            //System.out.println(str);
            if(firstString.equals(sub) && lastString.equals(sub)){
                return str.length();
            } else if(!firstString.equals(sub)){
               str = str.substring(1,str.length());
               return bigDist(str, sub);
            } else {
                str = str.substring(0,str.length()-1);
                return bigDist(str, sub);
            }
        }
    }
    // OR
    public static int bigDist2(String str, String sub){
        if(str.length() < sub.length())
            return 0;
            
        if(str.startsWith(sub) && str.endsWith(sub))
            return str.length();
            
        if(!str.substring(0, sub.length()).equals(sub))
            return bigDist(str.substring(1), sub);
            
        return bigDist(str.substring(0,str.length()-1), sub);
    }
}
