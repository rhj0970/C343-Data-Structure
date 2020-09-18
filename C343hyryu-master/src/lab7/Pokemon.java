package lab7;

// Pokemon.java : Java class to represent a Pokemon

public class Pokemon implements Comparable<Pokemon> {

      

       private String name;

       private int power;

      

// default constructor

       public Pokemon()

       {

             name="";

             power = 0;

       }

      

       // parameterized constructor

       public Pokemon(String name, int power)

       {

             this.name = name;

             this.power = power;

       }

      

       // setters

       public void setName(String name)

       {

             this.name = name;

       }

      

       public void setPower(int power)

       {

             this.power = power;

       }

      

       // getters

       public String getName()

       {

             return name;

       }

      

       public int getPower()

       {

             return power;

       }

      

       // comparing 2 pokemons based on their power  

       @Override

       public int compareTo(Pokemon other) {

             if(getPower() < other.getPower())

                    return -1;

             else if(getPower() > other.getPower())

                    return 1;

             return 0;

       }

      

       // return string representation of the Pokemon

       public String toString()

       {

             return name+" : "+power;

       }


}



