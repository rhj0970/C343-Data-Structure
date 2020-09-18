package lab6;

import java.util.Scanner;

public class Binary {
	
	static Scanner sc;
	static int range;
	static int[] array;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        range = sc.nextInt();
        array = new int[range + 1]; // array

        for(int i = 1; i <= range; i ++){
        	array[i] = sc.nextInt();
        }
        
        

        for(int j = 1; j <= range ; j ++){
            System.out.print("node " + j + ": key = " + array[j] + ", ");
            if(j/2 > 0){
                System.out.print("parent key = " + array[j/2] + ", ");
            }

            if(2*j <= range){
                System.out.print("left key = " + array[2*j] + ", ");
            }

            if((2*j + 1) <= range){
                System.out.print("right key = " + array[2*j + 1] + ", ");
            }
            System.out.println();
        }

    }


}

