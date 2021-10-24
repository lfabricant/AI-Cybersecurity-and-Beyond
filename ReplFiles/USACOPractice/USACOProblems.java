import java.util.*;
import java.io.*;



public class Main
{
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int photos = sc.nextInt();
    int odd = 0;
    int even = 0;
    for(int i = 0; i < photos; i++){
      int x = sc.nextInt();
      if(x % 2 == 0){
        even++;        
      }else{
        odd++;
      }
    }
    sc.close();
    int res = 0;
    int remainder = odd % 3;
    
    if(odd == 0){
      res = 1;
    }else if(even == 0){ 
      if(remainder==1){
        odd = odd - 2;
        remainder = 2;
      }
      
      switch(remainder){
        case 0: 
          res = (odd * 2)/3;
          break;
        case 2:
          res = 2*((odd/3)+1)-1;
          break;

        default: res = 0;
      }
    }else if(odd > even){
      if(remainder==2){
        odd = odd - 2;
        remainder = 0;
      }
      if(remainder==0){
        res = (odd * 2)/3 + 1;
        } else if(remainder==1){
          res = odd - (even%2);
        }
    }else if(even > odd){
      res = 2 * odd + 1;
      /*if(remainder == 0){
        res = even + odd - 2;
      } else if(remainder == 1 || remainder == 2){
        res = even + odd;
      } /* else if(remainder == 2){
        res = even + odd - 1;
      } */
    }else{
      res = even + odd;
    }
    System.out.println(res);
  
    
      
  }
}

