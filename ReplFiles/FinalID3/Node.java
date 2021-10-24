import java.io.*;
import java.util.*;
public class Node
{
  private String value;
  private ArrayList<Node> childList;
  public Node(String val)
  {
      value = val;
      childList = new ArrayList<Node>();
  }
  public String getValue(){
      return value;
  }
  public void addChild(Node n){
      childList.add(n);
  }
  public void setValue(String value){
     this.value = value;
  }
  public void print(){
     print("",true);
  }
  public void print(String prefix, boolean isTail) {
     System.out.println(prefix + "?-- " + value);
     for (int i = 0; i < childList.size() - 1; i++) {
         childList.get(i).print(prefix + (isTail ? "  " : "|  "), false);
     }
     if (childList.size() > 0) {
         childList.get(childList.size() - 1).print(prefix + 
         (isTail ? "  " : "|  "), true);
     }
  }
}
