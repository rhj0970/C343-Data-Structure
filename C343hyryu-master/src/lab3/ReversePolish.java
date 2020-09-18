package lab3;


import java.util.Scanner;
import java.util.Stack;

public class ReversePolish { // algorithm for reverse polish notation

	
	   Scanner sc = new Scanner(System.in);
	    String ex = sc.nextLine();
	     String[] k = ex.split(" ");
	     String[] polish = k;
	    String testCase = "";
	
	
	
	public void check() {
		int testSize = polish.length; // length of the test case
	    int number1=0;
	    int number2=0;
	    Stack<Integer> stack = new Stack<Integer>();
	   
	    for(int i=0; i<testSize; i++){
	   	 testCase = polish[i];

	        
	        if(testCase.equals("+") || testCase.equals("-") || testCase.equals("*") || testCase.equals("/")) {
	            number2 = (int) stack.pop();
	            number1 = (int) stack.pop();
	            
	            switch(testCase){
	            case "+" :
	                stack.push(number1+number2); // plus
	                break;
	            case "-" :
	                stack.push(number1-number2); // minus
	                break;
	            case "*" :
	                stack.push(number1*number2); // multiplication
	                break;
	            case "/" :
	                stack.push(number1/number2); // division
	                break;
	            }
	        }else{
	            stack.push(Integer.parseInt(testCase));
	        }
	        
	        
	          
	    }
	    System.out.println(stack.pop());
	    
	  
	}
		
		
	
	
	  
    public static void main(String[] args) {
 
    ReversePolish test = new ReversePolish();
    test.check();
    
  

        
       



}
}
