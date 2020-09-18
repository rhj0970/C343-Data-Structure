package homework1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class InsertionSort {

	public static void sorting (int[] arr) {
		////// sorting algorithm starts here

		for (int i =1; i<arr.length; i++) {

			int keyValue = arr[i];
			int j = i -1;
			
			while (j>=0 && arr[j] > keyValue) {
				arr[j+1] = arr[j];
				j--;
				
			}
			arr[j+1] = keyValue;
		}	
	}
	
	
	public static void main (String args[]) throws IOException{
		File file = new File("C:\\Users\\Hyeon Jin Ryu\\git\\C343hyryu\\src\\homework1\\output.txt");
		//Scanner scan = new Scanner(new File("C:\\Users\\Hyeon Jin Ryu\\git\\C343hyryu\\src\\homework1\\output.txt"));
		Scanner sc = new Scanner(System.in);
		
		int setCount = sc.nextInt();
		for (int k=0; k<setCount; k++) {
			int ab = sc.nextInt();
			int[] setSize = new int [ab];
			for (int j=0; j<ab; j++) {
				setSize[j] = sc.nextInt();
				
			}
			
		
///////////////////////////////////////////////////////////////////////////////////		
		// These are just example codes for printing the actual array that's been sorted
	/*	String line;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    for (int i = 0; i < 4; i++)
		        br.readLine();
		    line = br.readLine();
		}
		int[] array = Arrays.stream(line.split("\\s")).mapToInt(Integer::parseInt).toArray();
		*/
////////////////////////////////////////////////////////////////////////////////////////////////

		long start = System.currentTimeMillis(); 
		sorting(setSize);

		long end = System.currentTimeMillis();
		long difference = end - start;

		
		System.out.println("The number of the set is: " + ab);
		System.out.println("The running time is: " + difference);
	
		

	}
}
}


