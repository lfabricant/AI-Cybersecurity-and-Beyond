/**
 * Write a description of class BinaryTreeDriver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinaryTreeDriver
{
    public static void main(String[] args){
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        root.setLeftChild(node2);
        node2.setParent(root);
        node2.setLeftChild(node4);
        node4.setParent(node2);
        node2.setRightChild(node5);
        node5.setParent(node2);
        node5.setLeftChild(node7);
        node7.setParent(node5);
        root.setRightChild(node3);
        node3.setParent(root);
        node3.setRightChild(node6);
        node6.setParent(node3);
        
        System.out.println("----CREATING TREE-----");
        Tree tree1 = new Tree(root, root);
        System.out.println("This is the tree: ");
        tree1.print();
        System.out.println("This is the tree from the root: (same thing)");
        tree1.getRoot().print(); 
        System.out.println("Search for the value of 6 in the tree: " + tree1.search(6));
        System.out.println("Number of nodes: " + tree1.countNodes());
        System.out.print("Pre Order: ");
        tree1.printPreOrder();
        System.out.print("\nPost Order: ");
        tree1.printPostOrder();
        System.out.print("\nIn Order: ");
        tree1.printInOrder();
        System.out.println("\nIs the tree empty? " + tree1.isEmpty());
        System.out.print("Set root to 99 and print the new tree: ");
        tree1.setRoot(new Node(99));
        tree1.getRoot().print();
        System.out.print("Set the current node to node3 and print the node: ");
        tree1.setCurrent(node3);
        System.out.println();
        tree1.getCurrent().print();
        System.out.println("\n");
        
        System.out.print("----CREATING TREE-----");
        Tree emptyTree = new Tree();
        System.out.println("\nThis is the tree, starting from the root: ");
        emptyTree.print(); 
        System.out.println("This is the root: ");
        System.out.println(emptyTree.getRoot()); 
        System.out.println("Search for the value of 6 in the tree: " + emptyTree.search(6));
        System.out.println("Number of nodes: " + emptyTree.countNodes());
        System.out.print("Pre Order: ");
        emptyTree.printPreOrder(); // prints nothing because it is empty
        System.out.print("\nPost Order: ");
        emptyTree.printPostOrder(); // prints nothing because it is empty
        System.out.print("\nIn Order: ");
        emptyTree.printInOrder(); // prints nothing because it is empty
        System.out.println("\nIs the tree empty? " + emptyTree.isEmpty());
        System.out.println("\n");
        
        Node root2 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        root2.setLeftChild(n2);
        n2.setParent(root2);
        n2.setLeftChild(n4);
        n4.setParent(n2);
        n2.setRightChild(n5);
        n5.setParent(n2);
        root2.setRightChild(n3);
        n3.setParent(root2);
        
        System.out.print("----CREATING TREE-----");
        Tree tree2 = new Tree(root2, root2);
        System.out.println("\nThis is the tree: ");
        tree2.print();
        System.out.println("This is the tree from the root: (same thing)");
        tree2.getRoot().print();
        System.out.println("Search for the value of 6 in the tree: " + tree2.search(6));
        System.out.println("Number of nodes: " + tree2.countNodes());
        System.out.print("Pre Order: ");
        tree2.printPreOrder();
        System.out.print("\nPost Order: ");
        tree2.printPostOrder();
        System.out.print("\nIn Order: ");
        tree2.printInOrder();
    }
}
