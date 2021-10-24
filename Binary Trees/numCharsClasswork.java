/**
 * Write a description of class numCharsClasswork here.
 *
 * @author (Lindsay Fabricant)
 * @version (9/25/20)
 */
public class numCharsClasswork
{
    public static void main(String[] args){
        System.out.println("NUM CHARS");
        System.out.println(numChars("carrot", 'r'));
        System.out.println(numChars("carrot", 't'));
    }
    public static int numChars(String str, char c){
        if(str.length() == 0){
            return 0;
        } else {
            if(str.charAt(0) == c)
                return 1 + numChars(str.substring(1), c);
            else 
                return 0 + numChars(str.substring(1), c);
        }
    }
}
