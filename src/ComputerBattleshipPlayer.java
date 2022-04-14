import java.util.Random;

//Ben Germroth
public class ComputerBattleshipPlayer extends BattleshipPlayer {

	public void updatePlayer(Position pos, boolean hit,
			char initial, String boatName, boolean sunk,
			boolean gameOver, boolean tooManyTurns, int turns) {
		updateGrid(pos, hit, initial);
	}

	public String playerName() {
		return "Computer Player";
	}

	public Position shoot() {
		Random rn1 = new Random();
		Random rn2 = new Random();
		int row = 0;
		int column = 0;
		boolean keepGoing = true;

		while(keepGoing) {
			row = Math.abs(rn1.nextInt() % 10);
			column = Math.abs(rn2.nextInt() % 10);
			if(this.getGrid().empty(new Position(row,column)))
				keepGoing = false;
		}

		return new Position(row, column);
	}

	public void startGame() {
		initializeGrid();
	}
}


