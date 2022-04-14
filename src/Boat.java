import java.util.ArrayList;

//Ben Germroth
public class Boat {

	private String type;
	private String way;
	private int space;
	private Position boatpos;
	private ArrayList<Position> hits = new ArrayList<Position>();
	private ArrayList<Position> shipPos = new ArrayList<Position>();

	Boat(String boattype, Position pos, String orient) {
		type = boattype;
		if(type.equals("Aircraft Carrier")) {
			space = 5;
		} else if(type.equals("Battleship")) {
			space = 4;
		} else if(type.equals("Cruiser") || type.equals("Submarine")) {
			space = 3;
		}  else if(type.equals("Destroyer")) {
			space = 2;
		}
		boatpos = pos;
		way = orient;

		for(int i = 0; i < space; i++) {
			if(orient.equals("vertical"))
				getshipPos().add(new Position(pos.rowIndex() + i, pos.columnIndex()));
			if(orient.equals("horizontal"))
				getshipPos().add(new Position(pos.rowIndex(), pos.columnIndex() + i));
		}

	}

	public String name() {
		return type;
	}
	public char abbreviation() {
		return type.substring(0,1).toUpperCase().charAt(0);
	}
	public int size() {
		return space;
	}
	public boolean onBoat(Position position) {
		for(Position a: shipPos) {
			if(a.toString().equals(position.toString()))
				return true;
		}
		return false;
	}
	public boolean isHit(Position pos) {
		for(Position a: hits) {
			if(a.toString().equals(pos.toString()))
				return true;
		}
		return false;
	}
	public void hit(Position pos) {
		boolean doit = true;
		for(Position a: hits) {
			if(a.toString().equals(pos.toString()))
				doit = false; break;
		}
		if(doit) {
			for(int i = 0; i < shipPos.size(); i++) {
				if(shipPos.get(i).toString().equals(pos.toString())){
					hits.add(pos);
				}
			}
		}
	}
	public boolean sunk() {
		if(hits.size() == shipPos.size())
			return true;
		return false;
	}
	public Position position() {
		return boatpos;
	}
	public String direction() {
		return way;
	}

	private ArrayList<Position> getshipPos() {
		return shipPos;
	}
}



