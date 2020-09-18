package lab7;
import java.util.PriorityQueue;

public class PokemonDriver {

       public static void main(String[] args) {

             // create a priority queue of pokemons

             PriorityQueue<Pokemon> pokemonQueue = new PriorityQueue<Pokemon>();

             // insert pokemons in the priority queue

             pokemonQueue.add(new Pokemon("Pokemon1",50));

             pokemonQueue.add(new Pokemon("Pokemon2",20));

             pokemonQueue.add(new Pokemon("Pokemon3",70));

             pokemonQueue.add(new Pokemon("Pokemon4",55));

             pokemonQueue.add(new Pokemon("Pokemon5",10));

             pokemonQueue.add(new Pokemon("Pokemon6",30));

            

             // loop to remove the elements from the priority queue that has the lowest power)

             while(!pokemonQueue.isEmpty())

             {

                    System.out.println(pokemonQueue.poll());

             }

            

       }

}

//end of PokemonDriver.java