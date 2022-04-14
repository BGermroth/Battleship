//Ben Germroth
public class Position {
	private char place;
	private int number;
	private int row;
	private int column;
	Position(char letter, int num) {
		place = letter;
		number = num;
		switch(letter) {
		case 'A': row = 0; break;
		case 'B': row = 1; break;
		case 'C': row = 2; break;
		case 'D': row = 3; break;
		case 'E': row = 4; break;
		case 'F': row = 5; break;
		case 'G': row = 6; break;
		case 'H': row = 7; break;
		case 'I': row = 8; break;
		case 'J': row = 9; break;
		}
		column = num - 1;
	}
	Position(int rowy, int columny) {
		row = rowy;
		column = columny;
		switch(rowy) {
		case 0: place = 'A'; break;
		case 1: place = 'B'; break;
		case 2: place = 'C'; break;
		case 3: place = 'D'; break;
		case 4: place = 'E'; break;
		case 5: place = 'F'; break;
		case 6: place = 'G'; break;
		case 7: place = 'H'; break;
		case 8: place = 'I'; break;
		case 9: place = 'J'; break;
		}
		number = columny + 1;
	}
	
	public char row() {
		return place;
	}
	
	public int column() {
		return number;
	}
	
	public int rowIndex() {
		return row;
	}
	
	public int columnIndex() {
		return column;
	}
	public String toString() {
		return place + "-" + String.valueOf(number);
	}
}

