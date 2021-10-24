/**
 * Write a description of class Node here.
 *
 * @author (Lindsay Fabricant)
 * @version (9/17/20)
 */
public class Node
{
    private int value;
    private Node parent;
    private Node childLeft;
    private Node childRight;
    
    public Node(int value)
    {
         this.value = value;
         parent = null; // same as not specifying the value
    }
    public int getValue(){
        return value;
    }
    public Node getParent(){
        return parent;
    }
    public Node getLeft(){
        return childLeft;
    }
    public Node getRight(){
        return childRight;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void setLeftChild(Node newKid){
        childLeft = newKid;
    }
    public void setRightChild(Node newKid){
        childRight = newKid;
    }
    public void setParent(Node newMom){
        parent = newMom;
    }
    public void printValue(){
        System.out.println("Value of the current node: " + value);
    }
    public void printValues(){
        System.out.println(this);
        if(this != null){
           System.out.println("Value: " + value);
        } 
        if(childLeft != null){
            System.out.println("Value of the left child: " + childLeft.value); // same as childLeft.getValue()
        }
        if(childRight != null){
            System.out.println("Value of the right child: " + childRight.value);
        }   
    }
    public String toString(){
        String str = "Current node value: " + value;
        if(parent != null){ 
            // you can't do parent.getValue() if it's null because null runtime exception
            str += "\nIts parent has a value of " + parent.getValue();
        } else {
            str += "\nThis is the root node.";
        } 
        if(childLeft == null){
            str += "\nNo child on the left";
        } else {
            str += "\nIts child on the left has a value of " + childLeft.value;
        }
        if(childRight == null){
            str += "\nNo child on the right";
        } else {
            str += "\nIts child on the right has a value of " + childRight.value; 
            // childRight.value == childRight.getValue() == getChildRight.getValue()
        }   
        return str;
    }
    public void printPreorder(){
       printPreorder(this);
    }
    public void printPreorder(Node n){
        if(n != null){
            System.out.print(n.getValue() + " ");
            //if (n.childLeft != null)
            printPreorder(n.getLeft());
            //if (n.childRight != null)
            printPreorder(n.getRight());
        }
    }
    public void printPostorder(Node n){
        if(n != null){
            //if(n.getLeft() != null)
            printPostorder(n.getLeft()); 
            //if (n.childRight != null)
            printPostorder(n.getRight());
            System.out.print(n.getValue() + " ");
        }
    }
    public void printInorder(){
        printInorder(this);
    }
    public void printInorder(Node n){
        if(n != null){
            //if(n.getLeft() != null)
            printInorder(n.childLeft); 
            //if (n.childRight != null)
            System.out.print(n.value + " ");
            printInorder(n.childRight);
        }
    }
    public String print() {
        return this.print("",true,"");
    }
    public String print(String prefix, boolean isTail, String sb) {
        if (childRight != null) {
            childRight.print(prefix + (isTail ? "│    " : "    "), false, sb);
        }
        System.out.println( prefix+(isTail ? " \\-- " : " /-- ")+value);
        if (childLeft != null) {
            childLeft.print(prefix+(isTail ? "     " : "│   "), true, sb);
        }
        return sb;
    }
}
