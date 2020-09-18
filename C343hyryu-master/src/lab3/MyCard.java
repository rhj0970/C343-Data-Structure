package lab3;

import java.util.Random;

public class MyCard {
	String[] cardDeck = new String[52]; // set size of the card which is 52
	
	
	public void initialize() {
		String[] cardLetter = {"S", "C", "H", "D"}; //Spades, clubs, hearts, diamonds
		String[] cardNumber = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"}; //Ace, king, queen, jack, and card numbers
		
		int count = 0;
		
		for (int i=0; i<cardLetter.length; i++) { // for loop to go through the card decks.
			
			for(int j =0; j<cardNumber.length; j++) {
				String pickedCard = cardLetter[i] + cardNumber[j]; //the reason why we plus each other is because card is formed of letter and a number 3spades, 6 hearts
				cardDeck[count] = pickedCard;
				count++; // increments to go through the deck of cards	
			}
			
		}
		
		}
	
	
	
	
	public String drawCard() {
		Random rnd = new Random();
		int draw = rnd.nextInt(cardDeck.length);
		return cardDeck[draw];
			
	}
	
	
	
	public static void main(String[] args)   {
		MyCard testCase = new MyCard();
		testCase.initialize();
		System.out.println(testCase.drawCard());

	}
		
	
}
