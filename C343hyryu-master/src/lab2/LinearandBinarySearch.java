package lab2;

import java.util.Scanner;

public class LinearandBinarySearch {
	
	
	
	public static int linear(int arr[], int a) {
		
		int arrayLength = arr.length;
		for(int i=0; i<arrayLength; i++) {
			if(arr[i] == a) {
				return 1;
			}
			
		}
		System.out.println("aa"); // test print
		return 0;
		
	}
	
	
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	public static int binary(int arr2[], int myTarget) {
		
	
		int left = 0; 
        int right = arr2.length -1;
        int middle = 0;

        while (left <= right) {

        	middle = (left + right) / 2;

                if (myTarget == arr2[middle]) {
                        return 1;
                }

                else{

                        if (myTarget < arr2[middle]) { // if my target is less than the middle part       
                                right = middle - 1;
                        }

                        else if (myTarget > arr2[middle]){
                                left = middle + 1;
                        }
                }
        }
        return 0;
}

		
		
		
		
		
		

	
	public static void main (String args[]) {
		//System.out.println("aa");
		
		Scanner sc = new Scanner(System.in);
		int setCount = sc.nextInt();
	
		int[] input = new int [setCount];
		for (int k=0; k<setCount; k++) {
			int ab = sc.nextInt();
			input[k] = ab;
			//System.out.println("aa");
		}
		
		int otherCount = sc.nextInt();
		int result =0;
		int binaryResult =0;
		int []otherInput = new int[otherCount];
			for (int j=0; j<otherCount; j++) {
				otherInput[j] = sc.nextInt();
			result += linear(input, otherInput[j]);
			binaryResult += binary(input, otherInput[j]);
			//System.out.println("aa");
				
			}
			
			System.out.println(setCount);
			sc.close();
			System.out.println("The same number is: " + result);			
			System.out.println("The result of the binary same number is: " + binaryResult);
			
			
		
	
			
}
	}
