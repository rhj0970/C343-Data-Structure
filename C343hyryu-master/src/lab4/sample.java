package lab4;
import java.util.ArrayList;
import java.util.Scanner;

public class sample {

  
   public static void main(String[] args) {

   //Scanner class to receive the inputs
   Scanner sc=new Scanner(System.in);
   ArrayList<ArrayList <DNA>> hashTable = new ArrayList<>();
   int length = sc.nextInt();
   int amount = sc.nextInt();
   sc.nextLine();
   String s = sc.nextLine();
   int iter = (int) (Math.pow(4, amount));
   
   for (int i =0; i< iter; i++) {
	   hashTable.add(new ArrayList <DNA>());
   }
   
   
  
   
   for (int j = 0; j<=s.length() - length; j++) {
	   String key = s.substring(j, length+j);
	   DNA dna = new DNA(key,j);
	   put(hashTable, dna, amount);
   }
   
   int fill = 0;
   for (int k =0; k<hashTable.size(); k++) {
	   
	   if(!hashTable.get(k).isEmpty()) {
		   fill++;
	   }
	   
   }
   System.out.println(hashTable.size() + " " + fill);
   
   
   }
   
   public static void put (ArrayList<ArrayList<DNA>> ht, DNA d, int amount) {
	   int draw = hash(d, amount);
	   ht.get(draw).add(d);
	   
   }
   
   public static int hash (DNA d, int amount) {
	   String aa = d.key;
	   String reference = "ATCG";
	   int returnValue = 0;
	   for (int n =0; n<amount; n++) {
		   char c = aa.charAt(n);
		   int x = reference.indexOf(c);
		   returnValue += x*(int)(Math.pow(4, n));
	   }
	   return returnValue;
   }
   

   public static class DNA {
	   String key;
	   int value;
   
   
   public DNA(String key, int value) { // constructor 
	   this.key = key;
	   this.value = value;
	   
   }
   
   
   }

  
   
  

}