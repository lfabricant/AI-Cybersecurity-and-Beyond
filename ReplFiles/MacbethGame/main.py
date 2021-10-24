import java.util.*;
/**
 * Write a description of class Main here.
 *
 * @author (Lindsay Fabricant)
 * @version (26 May 2021)
 */
public class Main {
  static Tree tree;
  static boolean run = true;
  static Scanner sc;

  public static void main(String[] args) {
    // SETUP FOR TREE
    System.out.println("\nWelcome to Scotland!\nI wilt taketh a guess at who thee art!\nPlease choose Macbeth, Lady Macbeth, The Three Witches, Banquo, Fleance, King Duncan, Macduff, Lady Macduff, Malcom, or Donalbain.\nLet's begin:\n ");
    sc = new Scanner(System.in);
    Tree t = new Tree(new Node("Hath thee been killed? (YES/NO)"));
    tree = createTree(t);
    
    // INPUT
    while (run) {
      // IF GUESSED RIGHT
      if (tree.getCurrent().isName()) {
        System.out.println("I hath winneth!");
        System.out.println("Enter 'r' to play again. \nEnter 'd' to view the tree. \nEnter 's' to stop.");
        String s = sc.nextLine();
        commands(s);

        // GUESSES
      } else {
        System.out.println(tree.getCurrent().getString());
        String s = sc.nextLine();

        if (s.equals("Yes") || s.equals("Y") || s.equals("YES") || s.equals("yes") || s.equals("y")) {// 'yes' condition. Returns an animal guess
          tree.setCurrent(tree.getCurrent().getYes());

        } else if (s.equals("No") || s.equals("N") || s.equals("NO") || s.equals("no") || s.equals("n")) { // 'no' condition
          if (tree.getCurrent().getNo() == null) {// program loses when there is no next question after a 'no', player
                                                  // prompted to give answer and hint.
            System.out.println("Thee winneth! Who art thee?");
            String ans = sc.nextLine();
            System.out.println("Telleth me a question so I can identify " + ans + " in the future.");
            String q = sc.nextLine();
            tree.getCurrent().setNo(new Node(q+ " (YES/NO)")); // current is the dog q
            tree.setCurrent(tree.getCurrent().getNo());
            tree.getCurrent().setYes(new Node("Art thee " + ans + " ? (YES/NO)"));
            tree.setCurrent(tree.getCurrent().getYes());
            tree.getCurrent().setYes(new Node(ans, true)); // current is their question
            System.out.println("Let's play again!");// player forced to play again against their will--
            tree.setCurrent(tree.getRoot());
          } else { // asks the next question for the 'no' response
            tree.setCurrent(tree.getCurrent().getNo());
          }

          // RUN COMMANDS, NOT GUESS
        } else {
          commands(s);
        }
      }
    }
  }

  // COMMANDS :)
  public static void commands(String s) {
    if (s.equals("r")) { // restart to first question in tree
      tree.setCurrent(tree.getRoot());
    } else if (s.equals("d")) { // display tree
      tree.print();
      commands("print");
    } else if (s.equals("s")) { // stop
      run = false;
    } else if (s.equals("print")) { // print commands
      System.out.println("Enter 'r' to play again. \nEnter 'd' to view the tree. \nEnter 's' to stop.");
      commands(sc.nextLine());
    } else {
      System.out.println("Invalid character. Please input another: Enter 'r' to play again. \nEnter 'd' to view the tree. \nEnter 's' to stop.");
      commands(sc.nextLine());
    }
  }
  public static Tree createTree(Tree tree){
    // **** YES DIED
    tree.setCurrent(tree.getRoot());
    tree.getCurrent().setYes(new Node("Didst Macbeth order for someone to killeth thee? (YES/NO)"));
    
    tree.setCurrent(tree.getCurrent().getYes());
    tree.setR(tree.getCurrent());
    tree.getCurrent().setYes(new Node("Didst thee returneth as a ghost and haunteth Macbeth? (YES/NO)"));
    tree.getCurrent().setNo(new Node("Wast thee murdered at Castle Inverness? (YES/NO)"));

    tree.setCurrent(tree.getR().getYes());
    tree.getCurrent().setYes(new Node("Art thee Banquo? (YES/NO)"));
    tree.getCurrent().getYes().setYes(new Node("Banquo", true));
    tree.getCurrent().setNo(new Node("Art thee Lady Macduff? (YES/NO)"));
    tree.getCurrent().getNo().setYes(new Node("Lady Macduff", true));
    
    tree.setCurrent(tree.getR().getNo());
    tree.getCurrent().setYes(new Node("Art thee King Duncan? (YES/NO)"));
    tree.getCurrent().getYes().setYes(new Node("King Duncan", true)); 
    tree.getCurrent().setNo(new Node("Wast thee Thane of Cawdor? (YES/NO)"));
    
    tree.setR(tree.getCurrent());
    
    tree.setCurrent(tree.getR().getNo());
    tree.getCurrent().setYes(new Node("Art thee Macbeth? (YES/NO)"));
    tree.getCurrent().getYes().setYes(new Node("Macbeth", true));
    tree.getCurrent().setNo(new Node("Art thee Lady Macbeth? (YES/NO)"));
    tree.getCurrent().getNo().setYes(new Node("Lady Macbeth", true));
    
    // ****NO DID NOT DIE
    tree.setCurrent(tree.getRoot());
    tree.getCurrent().setNo(new Node("Wast thee the son of a main character? (YES/NO)"));
    
    tree.setCurrent(tree.getCurrent().getNo());
    tree.setR(tree.getCurrent());
    tree.getCurrent().setYes(new Node("Hadst The Witches toldeth Macbeth that thee would beest King of Scotland? (YES/NO)"));
    tree.getCurrent().setNo(new Node("Didst thee killeth Macbeth? (YES/NO)"));

    tree.setCurrent(tree.getR().getNo());
    tree.getCurrent().setYes(new Node("Art thee Macduff? (YES/NO)"));
    tree.getCurrent().getYes().setYes(new Node("Macduff", true)); 
    tree.getCurrent().setNo(new Node("Art thee The Three Witches? (YES/NO)"));
    tree.getCurrent().getNo().setYes(new Node("The Three Witches", true)); 
    
    tree.setCurrent(tree.getR().getYes());
    tree.setR(tree.getCurrent());
    tree.getCurrent().setNo(new Node("Didst thee flee to Ireland? (YES/NO)"));
    tree.getCurrent().setYes(new Node("Art thee Fleance? (YES/NO)"));
    tree.getCurrent().getYes().setYes(new Node("Fleance", true));
    
    tree.setCurrent(tree.getR().getNo());
    tree.getCurrent().setYes(new Node("Art thee Donalbain? (YES/NO)"));
    tree.getCurrent().getYes().setYes(new Node("Donalbain", true));
    tree.getCurrent().setNo(new Node("Art thee Malcolm? (YES/NO)"));
    tree.getCurrent().getNo().setYes(new Node("Malcolm", true));
    
    tree.setCurrent(tree.getRoot());
    
    return tree;
   }
}
