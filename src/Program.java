import java.util.*;
public class Program {
	public static void main(String[] args) {
		System.out.println("Welcome to Boggle, by Serena");
		WordList words = new WordList("WordList.txt", 1, 5);
		Board b = new Board(words, 4);
		System.out.println(b);
		
		ArrayList foundWords = b.find();
		
		System.out.print("Before Sorting\r\n");
		for (int i = 0; i < foundWords.size(); i++) {
			System.out.println(foundWords.get(i));
		}
		
		Collections.sort(foundWords, new WordComparator());
		
		int currentWordLength = 0;
		
		System.out.print("After Sorting\r\n");
		for (int j = 0; j < foundWords.size(); j++) {
			
			if (foundWords.get(j).toString().length() != currentWordLength) {
				currentWordLength = foundWords.get(j).toString().length();
				System.out.print("\r\n" + currentWordLength + " Letter Words\r\n");
			}
			System.out.println(foundWords.get(j));
		}
}
}
