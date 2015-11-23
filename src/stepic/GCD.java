package stepic;

import java.util.Scanner;

class GCD {
	
  public static void main(String[] args) {
	  
	  Scanner s = new Scanner(System.in);
	  
	  int a = s.nextInt(), b = s.nextInt();
	  
	  // swap if a < b
	  if(a < b) {
		  int c = a;
		  a = b;
		  b = c;
	  }
	  
	  while(a % b != 0) {
		  int c = b;
		  b = a % b;
		  a = c;
	  }
	  
	  System.out.println(b);
  }
}