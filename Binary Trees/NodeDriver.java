/**
 * Write a description of class NodeClient here.
 *
 * @author (Lindsay Fabricant)
 * @version (9/18/20)
 */
public class NodeDriver
{
    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n6);
        n1.setLeftChild(n2);
        n2.setParent(n1);
        n2.setLeftChild(n4);
        n4.setParent(n2);
        n2.setRightChild(n5);
        n5.setParent(n2);
        n5.setLeftChild(n7);
        n7.setParent(n5);
        n1.setRightChild(n3);
        n3.setParent(n1);
        n3.setRightChild(n6);
        n6.setParent(n3);
        System.out.println("\n-------------------------------------------------------\n");
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n6);
        
        System.out.println();
        n1.printPreorder();
        // 1 2 4 5 7 3 6
        
        System.out.println();
        n1.printPostorder(n1);
        // 4 7 5 2 6 3 1
        
        System.out.println();
        n1.printInorder(n1);
        // 4 2 7 5 1 3 6
    }
}
