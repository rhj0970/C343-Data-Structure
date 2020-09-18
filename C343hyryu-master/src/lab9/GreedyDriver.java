package lab9;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GreedyDriver {

       public static void main(String[] args) {

    	   	 Scanner sc = new Scanner(System.in);
             PriorityQueue<Greedy> prior = new PriorityQueue<Greedy>();
             
             int count = sc.nextInt();
             for (int i=0; i<count; i++) {
            	 String classroom = sc.next();           	 
            	 double time = sc.nextDouble();
            	 double end = sc.nextDouble();
            	 
            	 prior.add(new Greedy(classroom, time, end));
             }
             Greedy prior2 = null;
             while(!prior.isEmpty())  {
            	 
            	 Greedy current = prior.poll();
            	// System.out.println("current" + " " +current.getTime());
            	 //if (prior2 != null) {
            	 	// System.out.println("prior2" + " "  + prior2.getSecondTime());
            	 //}
           
            	 if (prior2 != null && (current.getTime() > prior2.getSecondTime())) {
            		 
                     System.out.println(current);
              	   prior2 = current;   
            	 }
            	 
            	 if (prior2 == null) {
                    System.out.println(current);
             	   prior2 = current;   
            	 }
            	 
                    
             }
       }
}