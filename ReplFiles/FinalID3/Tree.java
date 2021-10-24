public class Tree
{
    private Node root;
    private Node currentNode;
    public Tree(Node root){
        this.root = root;
        currentNode = root;
    }
    public Tree(){
        root = null;
        currentNode = null;
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
    public void print(){
      root.print();
    }
}
