package homework3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Airport {
	
	static Queue<Integer> takeoffQueue = new LinkedList<Integer>();
	static Queue<Integer> landingQueue = new LinkedList<Integer>();
	static List<Integer> takeoffWait = new ArrayList<Integer>(); // timeStamp of takeoff
	static List<Integer> landingWait = new ArrayList<Integer>(); // timeStamp of landing
    Integer runway1 = 0; 
    Integer runway2 = 0;
   
    public int landTakeoffTime = 15; // You may assume that each takeoff or landing takes 15 minutes to complete
    public int request = 5; // One runway request is made during each five minute interval
	public int testTime = 120; // Your program should simulate 120 minutes of activity
	public static int landingTime;
	public static int takeoffTime;
	public int sum=0; // sum of each average time
	
	static Scanner sc = new Scanner(System.in);
	
	public void Simulate() {


			for (int k =0; k<=testTime; k+=5) {  // test time 120 and each every 5 minutes for k+=5
				
				Random random = new Random();
				if (random.nextInt(2) == 0) // generate random number of size 2.
					landingQueue.add(k); // add to landing queue first since landing queue has priority
					
				else
					takeoffQueue.add(k); // and then add takeoff queue
				
				if (!landingQueue.isEmpty() && runway1 == 0) { // if landing queue is not empty and the runway1 is clear 
					int req = landingQueue.poll(); // take one out from the queue
					landingWait.add(k - req); // and add to timestamp for record
				
					runway1 = landTakeoffTime; // then the runway is landTakeoffTime which is 15
				
				}
				
				if (!landingQueue.isEmpty() && runway2 == 0 ) {	 // if landing queue is not empty and runway2 is clear
					int req = landingQueue.poll(); // take one out from the landing wait queue
					landingWait.add(k - req); // add to timestamp for record
					runway2 = landTakeoffTime; // then the runway is landTakeoffTime which is 15
				}
				
				if (!takeoffQueue.isEmpty() && runway1 == 0) { // if takeoff queue is not empty and runway1 is clear
					int req = takeoffQueue.poll();
					takeoffWait.add(k - req);
					runway1 = landTakeoffTime;
				}
				
				if (!takeoffQueue.isEmpty() && runway2 == 0 ) {	// if takeoff queue is not empty and runway2 is clear
					int req = takeoffQueue.poll();
					takeoffWait.add(k - req);
					runway2 = landTakeoffTime;
				}
				
				if (runway1 >0) { // if the runway1 is bigger than zero which means full
					runway1 -=5;
					
				}
				
				if (runway2 >0) {
					runway2 -= 5;
					
				}
			}  // for end
			
			/// two for loop for finding average time of landing and takeoff
			for (int i=0; i<landingWait.size(); i++) {
				sum = sum+ landingWait.get(i);
			}
			landingTime = sum/landingWait.size(); // finding the average time of the landing 
			
			for (int i=0; i<takeoffWait.size(); i++) {
				sum = sum+ takeoffWait.get(i);
			}
			takeoffTime = sum/takeoffWait.size(); // finding the average time of the takeoff

	} // simulate method end
	
	public static void main (String[] args) { // Main method will printout the results of simulation
		Airport a = new Airport();
		a.Simulate();
		System.out.println("The timeStamp of take off: " + takeoffWait); // timeStamp of the take off
		System.out.println("The timeStamp of landing: " + landingWait); // timeStamp of the landing queue
		System.out.println("Final queue of takeoff: " + takeoffQueue); // final queue content
		System.out.println("Final queue of landing: " + landingQueue); // final queue content
		System.out.println("Number of takeoff complete: " + takeoffQueue.size()); // number of takeoff complete
		System.out.println("Number of landing complete: " + landingQueue.size()); // number of landing complete
		System.out.println("Average landing Time: " + landingTime); // Time stamp of 
		System.out.println("Average takeoff Time: " + takeoffTime);
	} //Main end
} // class end