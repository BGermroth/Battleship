//Ben Germroth
public class BattleshipGame {

	private int turns;
	private BattleshipPlayer player;
	private Ocean ocean;

	BattleshipGame(BattleshipPlayer player) {
		ocean = new Ocean();
		ocean.placeAllBoats();
		turns = 0;
		this.player = player;
		player.startGame();
	}

	public int play() {
		boolean keepGoing = true;
		turns = 0;
		while(keepGoing) {
			Position pos = player.shoot();
			ocean.shootAt(pos);
			boolean game;
			boolean turn;
			if(ocean.allSunk())
				game = true;
			else
				game = false;

			if(turns == 100)
				turn = true;
			else
				turn = false;

			player.updatePlayer(pos, ocean.hit(pos), ocean.boatInitial(pos), ocean.boatName(pos), ocean.sunk(pos), game, turn, turns);

			if(ocean.allSunk())
				keepGoing = false;
			if(turns++ == 101)
				keepGoing = false;
		}
		return turns;
	}
}


