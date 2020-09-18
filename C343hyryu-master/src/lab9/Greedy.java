package lab9;

public class Greedy implements Comparable<Greedy> {

       private String classroom;
       private double time;
       double secondTime;


       public Greedy() {
             classroom="";
             time = 0;
             secondTime =0;
       }



       public Greedy(String classroom, double time, double secondTime) {
             this.classroom = classroom;
             this.secondTime = secondTime;
             this.time = time;
       }


       public void setClassroom(String classroom) {
             this.classroom = classroom;
       }

      
       public void setTime(double time) {
             this.time = time;
       }
       
       public void setSecondTime(double secondTime) {
    	   this.secondTime = secondTime;
       }


       // getters

       public String getClassroom() {
             return classroom;
       }

      

       public double getTime() {
             return time;
       }
       
       public double getSecondTime() {
    	   return secondTime;
       }

       @Override

       public int compareTo(Greedy other) {
             if(getSecondTime() < other.getSecondTime())

                    return -1;

             else if(getSecondTime() > other.getSecondTime())
                    return 1;
             
             
             return 0;

       }
       
   


       public String toString() {
             return classroom+" : "+time + " " + secondTime;

       }
}