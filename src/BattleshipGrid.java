import java.util.ArrayList;

//Ben Germroth
public class BattleshipGrid {

	private ArrayList<Position> keepTrack = new ArrayList<Position>();
	private ArrayList<Position> hits = new ArrayList<Position>();
	private ArrayList<Position> misses = new ArrayList<Position>();
	private ArrayList<Position> a = new ArrayList<Position>(5);
	private ArrayList<Position> b = new ArrayList<Position>(4);
	private ArrayList<Position> c = new ArrayList<Position>(3);
	private ArrayList<Position> s = new ArrayList<Position>(3);
	private ArrayList<Position> d = new ArrayList<Position>(2);

	public void shotAt(Position pos, boolean hit, char initial) {
		if(hit) {
			hits.add(pos);
			keepTrack.add(pos);
			switch(initial) {
			case 'A': a.add(pos);  break;
			case 'B': b.add(pos); break;
			case 'C': c.add(pos); break;
			case 'D': d.add(pos); break;
			case 'S': s.add(pos); break;
			}

		} else {
			misses.add(pos);
			keepTrack.add(pos);
		}
	}

	public boolean hit(Position pos) {
		for(Position a: hits) {
			if(a.toString().equals(pos.toString())) {
				return true;
			}
		}
		return false;
	}

	public boolean miss(Position pos) {
		for(Position a: misses) {
			if(a.toString().equals(pos.toString()))
				return true;
		}
		return false;
	}

	public boolean empty(Position pos) {
		for(Position a: keepTrack) {
			if(a.toString().equals(pos.toString()))
				return false;
		}
		return true;
	}

	public char boatInitial(Position pos) {
		for(Position p: a) {
			if(p.toString().equals(pos.toString()))
				return 'A';
		}
		for(Position p: b) {
			if(p.toString().equals(pos.toString()))
				return 'B';
		}
		for(Position p: c) {
			if(p.toString().equals(pos.toString()))
				return 'C';
		}
		for(Position p: s) {
			if(p.toString().equals(pos.toString()))
				return 'S';
		}
		for(Position p: d) {
			if(p.toString().equals(pos.toString()))
				return 'D';
		}
		return 'K';
	}
}



