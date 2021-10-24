/**
 * Write a description of class Tree here.
 *
 * @author (Lindsay Fabricant)
 * @version (26 May 2021)
 */
public class Tree
{
    private Node root;
    private Node r;
    private Node currentNode;
    
    public Tree(Node root){
        this.root = root;
        currentNode = root;
        r = root;
    }
    public Tree(){
        root = null;
        currentNode = null;
        r = null;
    }
    public Node getRoot(){
        return root;
    }
    public Node getR(){
        return r;
    }
    public void setR(Node node){
        r = node;
    }
    public void print(){
        if(this.isEmpty()){
            System.out.println("No values. This is an empty tree.");
        } else {
           root.print();
        }
    }
    public Node getCurrent(){
        return currentNode;
    }
    public void setCurrent(Node node){
        currentNode = node;
    }
    public boolean isEmpty(){
      if(root == null) return true;
      return false;
    }
}
