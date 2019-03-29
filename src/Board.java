import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Board {
	WordList wordlist;
	char[][] board;
	public Board(WordList words, int size) {
		this.wordlist = words;
		this.board = new char[size][size];
		for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] = (char)('a' + (int)(Math.random()*26));
            }
        }
	}
	
	public ArrayList<String> find(){
		boolean valid = false;
		ArrayList<String> found = new ArrayList<>();
		for (int i= 0; i < wordlist.size(); i++) {
			 for (int row = 0; row < board.length; row++) {
		            for (int col = 0; col < board.length; col++) {
		                if (this.find(wordlist.get(i), row, col)) {
		                    valid = true;
		                }
		                if (valid && !found.contains(wordlist.get(i))) {
		        			found.add(wordlist.get(i));
		        			valid = false;
		        		}
		            }
		        }
		}
		return found;
	}
		
	public boolean find(String word, int row, int col) {
		if (word.equals("")) {
			return true;
		} else if (row < 0 || row >= this.board.length || col < 0 || col >= this.board.length || this.board[row][col] != Character.toLowerCase(word.charAt(0))) {
	        return false;
	    } else {
	    	String rest = word.substring(1, word.length());
	    	boolean result = this.find(rest, row-1, col-1) || this.find(rest, row-1,   col) ||this.find(rest, row-1, col+1) || this.find(rest,   row, col-1) ||this.find(rest,   row, col+1) ||this.find(rest, row+1, col-1) ||this.find(rest, row+1, col) ||this.find(rest, row+1, col+1);
	    	return result;
	    }
	}
	
	public String toString() {
		String s = "";
		for(int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				s = s + board[i][j] + " ";
			}
			s = s + "\n";
		}
		return s;
	}

}
