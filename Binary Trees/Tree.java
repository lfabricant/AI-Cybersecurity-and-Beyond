/**
 * Write a description of class Tree here.
 *
 * @author (Lindsay Fabricant)
 * @version (10/6/20)
 */
public class Tree
{
    private Node root;
    private Node currentNode;
    public Tree(Node root, Node currentNode){
        this.root = root;
        currentNode = root;
    }
    public Tree(){
        root = null;
        currentNode = null;
    }
    public boolean search(int data){
        return search(root, data);
    }
    public boolean search(Node n, int d){
        if(n != null){
            if(n.getValue() == d){
                return true;
            } else {
                boolean left = search(n.getLeft(), d);
                boolean right = search(n.getRight(), d);
                return (left || right);
            }
        } 
        return false;
    }
    public void printInOrder(){
          if (root != null){
              root.printInorder(root); 
          }
    }
    public void printPreOrder(){
        printPreOrder(root);
    }
    public void printPreOrder(Node n){
        if (root != null){
            root.printPreorder(root); 
        }
    }
    public void printPostOrder(){
       if (root != null){
           printPostOrder(root);
       }
    }
    public void printPostOrder(Node n){
        if (root != null){
            root.printPostorder(root); 
        }
    }
    public Node getRoot(){
        if(root != null)
            return root;
        else
            return null;
    }
    public void setRoot(Node root){
        this.root = root;
    }
    public boolean isEmpty(){
        return root == null;
    }
    public int countNodes(){
        int count = 0;
        return countNodes(root, count);
    }
    public int countNodes(Node n, int count){
        if(n != null){
            count++;
            //System.out.println(count);
            return 1 + countNodes(n.getLeft(), count) + countNodes(n.getRight(), count);
        }
        return 0;
    }
    public void print(){
        if(this.isEmpty()){
            System.out.println("No values. This is an empty tree.");
        } else {
           root.print();
        }
    }
    public Node getCurrent(){
        if(currentNode != null)
            return currentNode;
        else
            return null;
    }
    public void setCurrent(Node node){
        currentNode = node;
    }
}
