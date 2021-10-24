import java.util.*;
import java.io.*;
public class Driver
{
  static Tree tree;
  public static void run() throws FileNotFoundException{
    ID3 test = new ID3(); 
    List<ArrayList<String>> file = test.loadCSV("Play.csv");
    test.printArrayList(file);
    
    Node root = new Node("Tree");
    tree = new Tree();
    tree.setRoot(root);
    tree.setRoot(test.runID3(file, root, tree, ""));
    System.out.println("\nFINAL TREE: ");
    tree.print();
  }
}
