import java.util.ArrayList;
import java.util.Random;

//Ben Germroth
public class BenGermrothStrategy extends ComputerBattleshipPlayer {

	private ArrayList<Position> air = new ArrayList<Position>();
	private ArrayList<Position> bat = new ArrayList<Position>();
	private ArrayList<Position> cruise = new ArrayList<Position>();
	private ArrayList<Position> sub = new ArrayList<Position>();
	private ArrayList<Position> des = new ArrayList<Position>();
	private BattleshipGrid grid = this.getGrid();

	public String playerName() {
		return "Ben";
	}
	public void startGame() {
		initializeGrid();
		air = new ArrayList<Position>();
		bat = new ArrayList<Position>();
		cruise = new ArrayList<Position>();
		des = new ArrayList<Position>();
		sub = new ArrayList<Position>();
		grid = this.getGrid();
	}
	public Position shoot() {
		//updatePlayer();

		air = new ArrayList<Position>();
		bat = new ArrayList<Position>();
		cruise = new ArrayList<Position>();
		des = new ArrayList<Position>();
		sub = new ArrayList<Position>();

		Random rn1 = new Random(), rn2 = new Random();
		int firstRow, firstColumn;

		int airc = 0, batl = 0, cru = 0, subm = 0, dest = 0;
		for(int a = 0; a < 10; a++) {
			for(int b = 0; b < 10; b++) {
				switch(grid.boatInitial(new Position(a,b))) {
				case 'A': airc++;air.add(new Position(a,b)); break;
				case 'B': batl++;bat.add(new Position(a,b)); break;
				case 'C': cru++;cruise.add(new Position(a,b)); break;
				case 'S': subm++;sub.add(new Position(a,b)); break;
				case 'D': dest++;des.add(new Position(a,b)); break;
				}
			}
		}
		//System.out.println(airc+" "+batl+" "+cru+" "+subm+" "+dest);
		if((airc == 0 || airc == 5) && (batl == 0 || batl == 4) && (cru == 0 || cru == 3) && (subm == 0 || subm == 3) && (dest == 0 || dest == 2)) {
			//System.out.println("happens");
			firstRow = Math.abs(rn1.nextInt() % 10);
			firstColumn = Math.abs(rn2.nextInt() % 10);
			if(!grid.empty(new Position(firstRow,firstColumn)))
				return shoot();
			else if(!checkers(firstRow,firstColumn))
				return shoot();
			//System.out.println(firstRow+" "+firstColumn);
			return new Position(firstRow, firstColumn);
		} else if(air.size() > 0 && air.size() < 5) {
			//System.out.println("aircraft");
			return placer(air);
		} else if(bat.size() > 0 && bat.size() < 4) {
			//System.out.println("battleship");
			return placer(bat);
		} else if(cruise.size() > 0 && cruise.size() < 3) {
			//System.out.println("cruiser");
			return placer(cruise);
		} else if(sub.size() > 0 && sub.size() < 3) {
			//System.out.println("submarine");
			return placer(sub);
		} else if(des.size() > 0 && des.size() < 2) {
			//System.out.println("destroyer");
			return placer(des);
		}
		//System.out.println("here");
		return null;
	}
	private Position placer(ArrayList<Position> boat) {
		Position pos = boat.get(0);
		int cind = pos.columnIndex();//cind is column index
		int rind = pos.rowIndex();//rind is row index
		if(boat.size() == 1) {
			if(rind == 9 && cind == 9) {//bottom right
				if(grid.empty(new Position(rind-1,cind)))
					return new Position(rind-1,cind);
				return new Position(rind,cind-1);
			} else if(rind == 0 && cind == 9) {//top right
				if(grid.empty(new Position(rind+1,cind)))
					return new Position(rind+1,cind);
				return new Position(rind,cind-1);
			}else if(rind == 9 && cind == 0) {//bottom left
				if(grid.empty(new Position(rind-1,cind)))
					return new Position(rind-1,cind);
				return new Position(rind,cind+1);
			} else if(rind == 0 && cind == 0) {//top left
				if(grid.empty(new Position(rind+1,cind)))
					return new Position(rind+1,cind);
				return new Position(rind,cind+1);
			} else if(rind == 9) {
				if(grid.empty(new Position(rind-1,cind)))
					return new Position(rind-1,cind);
				else if(grid.empty(new Position(rind,cind+1)))
					return new Position(rind,cind+1);
				return new Position(rind,cind-1);
			} else if(cind == 9) {
				if(grid.empty(new Position(rind,cind-1)))
					return new Position(rind,cind-1);
				else if(grid.empty(new Position(rind+1,cind)))
					return new Position(rind+1,cind);
				return new Position(rind-1,cind);
			} else if(rind == 0) {
				if(grid.empty(new Position(rind+1,cind)))
					return new Position(rind+1,cind);
				else if(grid.empty(new Position(rind,cind-1)))
					return new Position(rind,cind-1);
				return new Position(rind,cind+1);
			} else if(cind == 0) {
				if(grid.empty(new Position(rind,cind+1)))
					return new Position(rind,cind+1);
				else if(grid.empty(new Position(rind+1,cind)))
					return new Position(rind+1,cind);
				return new Position(rind-1,cind);
			} else {
				//System.out.println("goes to else");
				if(grid.empty(new Position(rind+1,cind)) && !(rind+boat.size()-1 > 9)) {//under
					//System.out.println("first one");
					return new Position(rind+1,cind);
				}
				else if(grid.empty(new Position(rind-1,cind)) && !(rind-boat.size()+1 > 9)) {//on top
					//System.out.println("second one");
					return new Position(rind-1,cind);
				}
				else if(grid.empty(new Position(rind,cind+1)) && !(cind+boat.size()-1 > 9)) {//to the left
					//System.out.println("third one");
					return new Position(rind,cind+1);
				}
				else if(grid.empty(new Position(rind,cind-1)) && !(cind-boat.size()+1 > 9)) {//to the right
					//System.out.println("fourth one");
					return new Position(rind,cind-1);
				}
			}
		} else if(boat.size() > 1){
			Position last = boat.get(boat.size()-1);
			//System.out.println("boatsize: "+boat.size());
			//System.out.println("boat potential row: "+(rind+boat.size()-1));
			if(rind+boat.size()-1 == last.rowIndex()) {
				if(rind+boat.size()-1 > 9 && grid.empty(new Position(rind-1,cind)))//shoot position behind
					return new Position(rind-1,cind);
				else if(grid.empty(new Position(last.rowIndex()+1,cind))) {//this one could be shooting out of ocean
					if(last.rowIndex()+1 > 9)
						System.out.println("I have to fix it");
//					System.out.println(last.rowIndex()+1+" "+cind);
					return new Position(last.rowIndex()+1,cind);
				}
				else if(!grid.empty(new Position(last.rowIndex()+1,cind)))
					return new Position(rind-1,cind);
			} else if(cind+boat.size()-1 == last.columnIndex()) {
				if(cind+boat.size()-1 > 9 && grid.empty(new Position(rind,cind-1)))
					return new Position(rind,cind-1);
				else if(grid.empty(new Position(rind,last.columnIndex()+1))) {
//					if(last.columnIndex()+1 > 9)
//						System.out.println("this doesn't work right");
					//System.out.println(rind + " "+ last.columnIndex()+1);
					return new Position(rind,last.columnIndex()+1);
				}
				else if(!grid.empty(new Position(rind,last.columnIndex()+1)))
					return new Position(rind,cind-1);
			}
		}
		//System.out.println("the end is near");
		return null;
	}
	public void updatePlayer() {

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
	private boolean checkers(int row, int column) {
		if(row == column)
			return true;
		else if((double)row % 2 == 0 && (double)column % 2 == 0)
			return true;
		else if((double)row % 2 != 0 && (double)column % 2 != 0)
			return true;
		return false;
	}
}



