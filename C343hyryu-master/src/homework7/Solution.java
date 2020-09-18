package homework7;

import java.util.*;

public class Solution {

   public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       int people = sc.nextInt();
       int pair = sc.nextInt();
       
       TreeSet<Integer> ds[] = new TreeSet[people];

       int count=0;
       int flag=0;
       int firstPerson;
       int secondPerson;
      
       for(int i=0;i<pair;i++) {
            firstPerson = sc.nextInt(); // fisrt person input
            secondPerson = sc.nextInt(); // second person input
            flag=0;
            for(int j=0; j<count; ++j)  {
                    //if pair of friends exists in set, add to that set
                    if(ds[j].contains(firstPerson) || ds[j].contains(secondPerson)) {
                            ds[j].add(firstPerson);
                            ds[j].add(secondPerson);
                            flag=1;           
                        }

                }
            
            // if there is no pair with friends, create a new set and add it to that set
            if(flag==0) {
                    ds[count] = new TreeSet();
                    ds[count].add(firstPerson);
                    ds[count].add(secondPerson);
                    ++count;
                }
           
       }
      
      /////////////////////// comparison if two of them are friend or not ////////////////////////////////
       int query;
       query = sc.nextInt();
       //processing queries
       for(int l=0;l<query;l++) {
    	   	flag=0;
    	   	firstPerson = sc.nextInt();
    	   	secondPerson = sc.nextInt();
    	   	
                for(int k=0;k<count; ++k) {
                    // they are friends
                    if(ds[k].contains(firstPerson) && ds[k].contains(secondPerson)) {
                    
                         System.out.println("yes");
                         flag=1;
                         break;
                        }

                }
                // they are not friends
                 if(flag == 0) {
                    System.out.println("no");
           
                }

            }
   }
}