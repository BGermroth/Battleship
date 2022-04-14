import java.util.Scanner;

//Ben Germroth
public class BattleshipPlayer {

	private String name;
	private BattleshipGrid grid = new BattleshipGrid();

	BattleshipPlayer() {
		name = null;
	}

	public void startGame() {
		initializeGrid();
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		if(name == null) {
			System.out.print("Welcome, what is your name: ");
			name = userInput.next();
		}
	}

	public String playerName() {
		return name;
	}

	public Position shoot() {
		boolean yes = true;
		char a = 'A';
		String b = "";
		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		while(yes) {
			System.out.print("row A-J: ");
			a = userInput.next().charAt(0);
			if(a == 'A'||a == 'B'||a == 'C'||a == 'D'||a == 'E'
					||a == 'F'||a == 'G'||a == 'H'||a == 'I'||a == 'J')
				yes = false;
			else
				System.out.println("Bad Row Try Again");
		}
		boolean keepGoing = true;
		while(keepGoing) {
			try{
				keepGoing = false;
				yes = true;
				while(yes) {
					System.out.print("column 1-10: ");
					b = userInput.next();
					if((Object)Integer.parseInt(b) == null)
						System.out.println("Bad Column Try Again");
					else if(Integer.parseInt(b) >= 1 && Integer.parseInt(b) <= 10)
						yes = false;
				}
			} catch(NumberFormatException ex) {
				System.out.println("Bad Column Try Again");
				keepGoing = true;
			}
		}
		return new Position(a,Integer.parseInt(b));
	}

	public void updateGrid(Position pos, boolean hit, char initial) {
		grid.shotAt(pos, hit, initial);
	}

	public BattleshipGrid getGrid() {
		return grid;

	}
	public void initializeGrid() {
		grid = new  BattleshipGrid();
	}
	public void updatePlayer(Position pos, boolean hit,
			char initial, String boatName, boolean sunk,
			boolean gameOver, boolean tooManyTurns, int turns) {

		updateGrid(pos, hit, initial);

		for(int a = 0; a < 11; a++) {
			for(int b = 0; b < 11; b++) {
				if(a == 0 && b == 0)
					System.out.print("  ");
				else if(a == 0 && b == 1)
					System.out.print("1 ");
				else if(a == 0 && b == 2)
					System.out.print("2 ");
				else if(a == 0 && b == 3)
					System.out.print("3 ");
				else if(a == 0 && b == 4)
					System.out.print("4 ");
				else if(a == 0 && b == 5)
					System.out.print("5 ");
				else if(a == 0 && b == 6)
					System.out.print("6 ");
				else if(a == 0 && b == 7)
					System.out.print("7 ");
				else if(a == 0 && b == 8)
					System.out.print("8 ");
				else if(a == 0 && b == 9)
					System.out.print("9 ");
				else if(a == 0 && b == 10)
					System.out.println("10");
				else if(a == 1 && b == 1)
					System.out.println("A"+" "+sent(0,0)+" "+sent(0,1)+" "+sent(0,2)+" "+sent(0,3)+" "+sent(0,4)+" "+sent(0,5)+" "+sent(0,6)+" "+sent(0,7)+" "+sent(0,8)+" "+sent(0,9));
				else if(a == 2 && b == 1)
					System.out.println("B"+" "+sent(1,0)+" "+sent(1,1)+" "+sent(1,2)+" "+sent(1,3)+" "+sent(1,4)+" "+sent(1,5)+" "+sent(1,6)+" "+sent(1,7)+" "+sent(1,8)+" "+sent(1,9));
				else if(a == 3 && b == 1)
					System.out.println("C"+" "+sent(2,0)+" "+sent(2,1)+" "+sent(2,2)+" "+sent(2,3)+" "+sent(2,4)+" "+sent(2,5)+" "+sent(2,6)+" "+sent(2,7)+" "+sent(2,8)+" "+sent(2,9));
				else if(a == 4 && b == 1)
					System.out.println("D"+" "+sent(3,0)+" "+sent(3,1)+" "+sent(3,2)+" "+sent(3,3)+" "+sent(3,4)+" "+sent(3,5)+" "+sent(3,6)+" "+sent(3,7)+" "+sent(3,8)+" "+sent(3,9));
				else if(a == 5 && b == 1)
					System.out.println("E"+" "+sent(4,0)+" "+sent(4,1)+" "+sent(4,2)+" "+sent(4,3)+" "+sent(4,4)+" "+sent(4,5)+" "+sent(4,6)+" "+sent(4,7)+" "+sent(4,8)+" "+sent(4,9));
				else if(a == 6 && b == 1)
					System.out.println("F"+" "+sent(5,0)+" "+sent(5,1)+" "+sent(5,2)+" "+sent(5,3)+" "+sent(5,4)+" "+sent(5,5)+" "+sent(5,6)+" "+sent(5,7)+" "+sent(5,8)+" "+sent(5,9));
				else if(a == 7 && b == 1)
					System.out.println("G"+" "+sent(6,0)+" "+sent(6,1)+" "+sent(6,2)+" "+sent(6,3)+" "+sent(6,4)+" "+sent(6,5)+" "+sent(6,6)+" "+sent(6,7)+" "+sent(6,8)+" "+sent(6,9));
				else if(a == 8 && b == 1)
					System.out.println("H"+" "+sent(7,0)+" "+sent(7,1)+" "+sent(7,2)+" "+sent(7,3)+" "+sent(7,4)+" "+sent(7,5)+" "+sent(7,6)+" "+sent(7,7)+" "+sent(7,8)+" "+sent(7,9));
				else if(a == 9 && b == 1)
					System.out.println("I"+" "+sent(8,0)+" "+sent(8,1)+" "+sent(8,2)+" "+sent(8,3)+" "+sent(8,4)+" "+sent(8,5)+" "+sent(8,6)+" "+sent(8,7)+" "+sent(8,8)+" "+sent(8,9));
				else if(a == 10 && b == 1)
					System.out.println("J"+" "+sent(9,0)+" "+sent(9,1)+" "+sent(9,2)+" "+sent(9,3)+" "+sent(9,4)+" "+sent(9,5)+" "+sent(9,6)+" "+sent(9,7)+" "+sent(9,8)+" "+sent(9,9));
			}
		}

		if(hit) {
			System.out.println("Turn # "+turns+" shot at "+pos.toString()+" was a hit on the boat "+boatName);
			System.out.println("sunk: "+sunk);
		}
		else if(!hit)
			System.out.println("Turn # "+turns+" shot at "+pos.toString()+" was a miss");

		if(gameOver)
			System.out.println("Game over");
		else if(!gameOver)
			System.out.println("Game is not over");
		if(tooManyTurns)
			System.out.println("Too many turns have been taken");
		else if(!tooManyTurns)
			System.out.println("Too many turns have not been taken");
	}

	private String sent(int a, int b) {
		if(grid.empty(new Position(a,b)))
			return ".";
		if(grid.miss(new Position(a,b)))
			return "*";
		if(grid.hit(new Position(a,b)))
			return Character.toString(grid.boatInitial(new Position(a,b)));
		return "error";
	}
}


