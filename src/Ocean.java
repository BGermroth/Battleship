import java.util.ArrayList;

//Ben Germroth
public class Ocean {

	int spaces;
	private ArrayList<Boat> ships = new ArrayList<Boat>(5);
	private ArrayList<Position> boatsPos = new ArrayList<Position>();

	public void placeBoat(String boatName, String direction, Position pos) throws Exception {

		if(boatName.equals("Aircraft Carrier"))
			spaces = 5;
		else if(boatName.equals("Battleship"))
			spaces = 4;
		else if(boatName.equals("Cruiser") || boatName.equals("Submarine"))
			spaces = 3;
		else if(boatName.equals("Destroyer"))
			spaces = 2;

		if(direction.equals("vertical") && pos.rowIndex() + spaces - 1 > 9) {
			//System.out.println("vert fail");
			throw(new Exception());
		}
		if(direction.equals("horizontal") && pos.columnIndex() + spaces - 1 > 9) {
			//System.out.println("horiz fail");
			throw(new Exception());
		}

		for(Boat a: ships) {
			for(int i = 0; i < spaces; i++) {
				if(direction.equals("vertical")) {
					if(a.onBoat(new Position(pos.rowIndex()+i, pos.columnIndex())))
						throw(new Exception());
				}
				if(direction.equals("horizontal")) {
					if(a.onBoat(new Position(pos.rowIndex(), pos.columnIndex()+i)))
						throw(new Exception());
				}
			}
		}

		ships.add(new Boat(boatName, pos, direction));

		for(int i = 0; i < spaces; i++) {
			if(direction.equals("vertical"))
				boatsPos.add(new Position(pos.rowIndex()+i, pos.columnIndex()));
			if(direction.equals("horizontal"))
				boatsPos.add(new Position(pos.rowIndex(), pos.columnIndex()+i));
		}
	}

	public void shootAt(Position pos) {
		for(Boat a: ships) {
			if(a.onBoat(pos))
				a.hit(pos);
		}
	}

	public boolean hit(Position pos) {
		for(Boat a: ships) {
			if(a.onBoat(pos))
				if(a.isHit(pos))
					return true;
		}
		return false;
	}

	public char boatInitial(Position pos) {
		for(Boat a: ships) {
			if(a.onBoat(pos)) {
				return a.abbreviation();
			}
		}
		return 'K';
	}

	public String boatName(Position pos) {
		for(Boat a: ships) {
			if(a.onBoat(pos))
				return a.name();
		}
		return "error";
	}

	public boolean sunk(Position pos) {
		for(Boat a: ships) {
			if(a.onBoat(pos))
				if(a.sunk())
					return true;
		}
		return false;
	}

	public boolean allSunk() {
		int a = 0;
		for(int i = 0; i < ships.size(); i++) {
			if(ships.get(i).sunk())
				a++;
		}
		if(a == 5)
			return true;
		else
			return false;
	}

	public void placeAllBoats() {
		int stop = 0;
		boolean[] places = {true, true, true, true, true};
		while(stop < 5) {
			stop++;
			int direction = range(2,1);
			String dire = dir(direction);
			String boatType = "";
			int type = range(4,0);
			while(!places[type])
				type = range(4,0);
			switch(type) {
			case 0: boatType = "Aircraft Carrier";break;
			case 1: boatType = "Battleship";break;
			case 2: boatType = "Cruiser";break;
			case 3: boatType = "Submarine";break;
			case 4: boatType = "Destroyer";break;
			}
			places[type] = false;
			int a = range(9,0);
			int b = range(9,0);
			try {
				this.placeBoat(boatType, dire, new Position(a,b));
			} catch(Exception e) {
				places[type] = true;
				stop--;
			}

		}
	}

	private int range(int max, int min) {
		int range = (max - min) + 1;     
		return (int)(Math.random() * range) + min;
	}

	private String dir(int direction) {
		if(direction == 1)
			return "horizontal";
		else if(direction == 2)
			return "vertical";
		return "Bad direction";
	}
}



