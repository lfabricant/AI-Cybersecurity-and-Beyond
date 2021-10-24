import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.println(encrypt("Secret code", "day"));
   // System.out.println(decrypt("reauerfobh", "day"));
  }
  public static String encrypt(String text, String key){
    char[] t = text.toUpperCase().toCharArray();
    int repeat = text.length()/key.length()+1;
    String longKey = key.repeat(repeat).toUpperCase();
    ArrayList<Character> chars = new ArrayList<Character>();
    for (char c : longKey.toCharArray()) {
      chars.add(c);
    }
    String encrypted = "";
    for(int i = 0; i < t.length; i++){
      if(t[i] == ' '){
        encrypted += " ";
        chars.add(i,' ');
      } else {
        int shift = indexOf(chars.get(i));
        encrypted+=encryptLetter(t[i], shift,true);
      } 
    } 
    return encrypted; 
  }
  public static String decrypt(String text, String key){
    char[] t = text.toUpperCase().toCharArray();
    int repeat = text.length()/key.length()+1;
    String longKey = key.repeat(repeat).toUpperCase();
    ArrayList<Character> chars = new ArrayList<Character>();
    for (char c : longKey.toCharArray()) {
      chars.add(c);
    }
    String encrypted = "";
    for(int i = 0; i < t.length; i++){
      if(t[i] == ' '){
        encrypted += " ";
        chars.add(i,' ');
      } else {
        int shift = indexOf(chars.get(i));
        encrypted+=encryptLetter(t[i], shift,false);
      } 
    } 
    return encrypted; 
  }

public static String encryptLetter(char letter, int shift, boolean forward){
  String result = "";
  int indexOfCurrent = indexOf(letter);
  result += getCharShift(indexOfCurrent, shift, forward);
  return result;
}

public static int indexOf(char letter){ 
  char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  int i = 0;
  while(letter != alphabet[i]){
    i++;
  }
  return i;
} 

public static char getCharShift(int index, int shift, boolean forward){
  char[] alphabet = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  char c = ' ';
  if(forward){
    c = alphabet[(index+shift)%26];
  } else {
    if (index-shift < 0){
        c = alphabet[26+(index-shift)];
    } else {
        c = alphabet[(index-shift)%26];
    } 
  }
  return c; 
}
} 
