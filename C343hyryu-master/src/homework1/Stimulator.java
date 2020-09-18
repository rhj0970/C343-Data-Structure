package homework1;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


 

public class Stimulator {
	
	
public static void main(String[] args) throws IOException{
	File file = new File("C://Users//Hyeon Jin Ryu//nums.txt");
	FileWriter f = new FileWriter(file);
	Scanner sc = new Scanner(System.in);
	int setCount = sc.nextInt();
	System.out.println(setCount); // print out how many sets
	
	int [] setSize = new int [setCount];
	
	
	
	
	for (int k=0; k<setCount; k++) {
		setSize[k] = sc.nextInt();
		
		
	}
	
	
	for(int i=0; i<setCount; i++) {
		int length = setSize[i]; // length of the each size
		String result = ""; // empty string
		System.out.println(length); // prints out the length of the sets
		
		f.write(length);
		
		for(int j=0; j<length; j++) {
			Random random = new Random();
			int element = random.nextInt(10000); // random numbers are generated to 1000
			result = result + element + " "; 
			
		}
		
		System.out.println(result); // prints out the elements in the set
		f.write(result);
		
	}
	f.close();
	sc.close();
	}
	

}

