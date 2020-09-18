/////////////////////////
// C343 Final Project
// Members: Jason Ryu (hyryu)
//          SungHyun Park (shpark92)
//          JiongRan Wang (jiowang)

package project;

import java.util.*;
import java.nio.*;
import java.nio.file.*;
import java.io.*;
import java.util.function.*;

public class Project {
	
	
    static ArrayList<String> arr = new ArrayList<String>();
    static Random rnd = new Random();
    static String k = "";
    static int firstNum = 1;
    static int secondNum;
    /////////////// For the txt file size limit //////////////
    static double[] editdistance;
    static double[] lcs;
    static int medianLimit = 2000;
    static int smallLimit = 16;
    
    
	public static void main(String[] args) throws IOException {
		parse();
		
		editdistance = new double[medianLimit]; // text file size limit to 4999
		lcs = new double[medianLimit]; // text file size limit 
		for (int i = 0; i < medianLimit; i++) {
			secondNum = rnd.nextInt(firstNum); // comparing first element with every combination and the first element moves to second element and goes on.
		//	System.out.println(firstNum);
		//	System.out.println(secondNum);
			double div = Math.max(arr.get(firstNum).length(), arr.get(secondNum).length());
			
			editdistance[i] = edit_distance(arr.get(firstNum), arr.get(secondNum)) / div;
			lcs[i] = find_LCS(arr.get(firstNum), arr.get(secondNum)) / div;
			firstNum ++;
		}
		
		System.out.println(Arrays.toString(editdistance));
		System.out.println(Arrays.toString(lcs));
		
		
		/*
		////////////////////////////// for small.txt /////////
		firstNum = rnd.nextInt(arr.size() + 1);
		secondNum = rnd.nextInt(arr.size() + 1);
		
		while(secondNum == firstNum) {
			secondNum = rnd.nextInt(arr.size() + 1);
		}
		System.out.println(firstNum);
		System.out.println(secondNum);
		System.out.println(edit_distance(arr.get(firstNum), arr.get(secondNum)));
		System.out.println(find_LCS(arr.get(0), arr.get(1)));  
		*/

	}
		
	
	public static int edit_distance(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] d = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			d[i][0] = i;
		}
		
		for (int j = 0; j <= n; j++) {
			d[0][j] = j;
		}
		
		int c = 0;
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (a.charAt(i-1) == b.charAt(j-1)) {
					c = 0;
				}else {
					c = 1;
				}
				d[i][j] = Math.min(d[i-1][j] + 1, d[i][j-1] + 1);
				d[i][j] = Math.min(d[i][j], d[i-1][j-1] + c);
			}
		}
		
		return d[m][n];
	}
	
	public static int find_LCS(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] lcs = new int[m+1][n+1];
		
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
				if (a.charAt(i-1) == b.charAt(j-1)) {
					lcs[i][j] = 1 + lcs[i-1][j-1];
				}
			}
		}
		
		return lcs[m][n];
	}
	

	private  static void parse() throws IOException {
 

        try (Scanner sc = new Scanner(new File("C:\\Users\\Hyeon Jin Ryu\\git\\C343hyryu\\src\\project\\median.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.charAt(0) == '>') {
                	if(k.length() > 0) {
                		arr.add(k);
                		k = "";
                	}
                	
                	else {
                		continue;
                	}

                } 
                
                else {
                   // System.out.print(line); // test  case
 
                	k += line;
                    
                }
            }
        }
        //System.out.println();
        //System.out.println(arr.size());
        //System.out.println(arr.get(0));
    }
}
