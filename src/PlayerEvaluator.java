//Ben Germroth
public class PlayerEvaluator {

	private int max;
	private int min;
	private float avg;
	
	PlayerEvaluator(ComputerBattleshipPlayer player , int runs) {
		max = 0;
		min = 100;
		avg = 0f;
		int keepTrack = 0;
		
		for(int i = runs; i > 0; i--) {
			BattleshipGame game = new BattleshipGame(player);
			keepTrack = game.play();
			if(keepTrack > max)
				max = keepTrack;
			else if(keepTrack < min)
				min = keepTrack;
			avg += keepTrack;
		}
		avg /= runs;
	}
	
	public int maxTurns() {
		return max;
	}
	
	public int minTurns() {
		return min;
	}
	
	public float avgTurns() {
		return avg;
	}
}


