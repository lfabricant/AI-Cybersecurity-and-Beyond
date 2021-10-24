/**
 * Write a description of class TowersOfHanoi here.
 *
 * @author (Lindsay Fabricant)
 * @version (9/25/20)
 */
public class TowersOfHanoi
{
    public static void main(String[] args){
        int n = 4;
        TOH(n, 'A', 'C', 'B');
        System.out.println("Min Moves = " + (int)(Math.pow(2,n)-1));
    }
    public static void TOH(int numDisks, char start, char end, char aux){
        if(numDisks <= 0){
            return;
        } else {
            TOH(numDisks-1, start, aux, end);
            System.out.println("Move disk " + numDisks + " from rod " + start + " to rod " + end); 
                // counted from top to bottom (smallest = 1)
            TOH(numDisks-1, aux, end, start);
        }
    }
}
