/**
 * Write a description of class Node here.
 *
 * @author (Lindsay Fabricant)
 * @version (26 May 2021)
 */
public class Node
{
  private String s; 
  private Node yes;
  private Node no;
  private boolean isName;
  
  public Node(String question)
  {
        s = question;
        isName = false;
  }

  public Node(String answer, boolean isAnswer)
  {
        s = answer;
        isName = isAnswer; 
  }

  public String getString(){
    return s;
  }

  public Node getYes(){
      return yes;
  }
  public Node getNo(){
      return no;
  }
  public void setString(String question){
    s = question;
  }
  public boolean isName(){
    return isName;
  }

  public void setYes(Node newKid){
    yes = newKid;
  }
  public void setNo(Node newKid){
    no = newKid;
  }
  public void printQuestion(){
    System.out.println("Question of the current node: " + s);
  }
  public void printAnswer(String s){
    System.out.println("Your answer is: " + s);
  }

  public void printQuestions(){
    System.out.println(this);
    if(this != null){
      System.out.println("Question: " + s);
    } 
    if(yes != null){
        System.out.println("Question of the yes child: " + yes.s); // same as yes.getquestion()
    }
    if(no != null){
        System.out.println("Question of the no child: " + no.s);
    }   
  }
  
  public String print() {
      return this.print("",true,"");
  }
  public String print(String prefix, boolean isTail, String sb) {
      if (no != null) {
        no.print(prefix + (isTail ? "│    " : "    "), false, sb);
      }
      System.out.println(prefix+(isTail ? " \\-- " : " /-- ")+s);
      if (yes != null) {
          yes.print(prefix+(isTail ? "     " : "│   "), true, sb);
      }
      return sb;
  }
}
