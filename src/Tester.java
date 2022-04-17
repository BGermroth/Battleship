//Ben Germroth
public class Tester {
	public static void test1() {
		Position pos1 = new Position('A', 2);
		Position pos2 = new Position('C', 5);
		System.out.println(pos1.row());
		System.out.println(pos1.column());
		System.out.println(pos1.toString());
		System.out.println(pos2.row());
		System.out.println(pos2.column());
		System.out.println(pos2.toString());
	}
	public static void test2() {
		Position pos1 = new Position(4, 4);
		Position pos2 = new Position('J', 1);
		System.out.println("row: "+pos1.row()+" column: "+pos1.column()+" rowIndex: "+pos1.rowIndex()+" columnIndex: "+pos1.columnIndex());
		System.out.println("row: "+pos2.row()+" column: "+pos2.column()+" rowIndex: "+pos2.rowIndex()+" columnIndex: "+pos2.columnIndex());
	}
	public static void test3() {
		Position pos1 = new Position(0,1);
		Position pos2 = new Position(4,3);
		Position pos3 = new Position(5,0);
		Position pos4 = new Position(6,6);
		Position pos5 = new Position(1,6);

		Boat a = new Boat("Aircraft Carrier", pos1, "vertical");
		Boat b = new Boat("Battleship", pos2, "horizontal");
		Boat c = new Boat("Cruiser", pos3, "vertical");
		Boat d = new Boat("Submarine", pos4, "horizontal");
		Boat e = new Boat("Destroyer", pos5, "vertical");

		System.out.println("name: "+a.name());
		System.out.println("name: "+b.name());
		System.out.println("name: "+c.name());
		System.out.println("name: "+d.name());
		System.out.println("name: "+e.name());
		System.out.println("abbreviation: "+a.abbreviation());
		System.out.println("abbreviation: "+b.abbreviation());
		System.out.println("abbreviation: "+c.abbreviation());
		System.out.println("abbreviation: "+d.abbreviation());
		System.out.println("abbreviation: "+e.abbreviation());
		System.out.println("size: "+a.size());
		System.out.println("size: "+b.size());
		System.out.println("size: "+c.size());
		System.out.println("size: "+d.size());
		System.out.println("size: "+e.size());
		System.out.println("onBoat: "+a.onBoat(pos1));
		System.out.println("onBoat: "+a.onBoat(new Position(0,0)));
		System.out.println("onBoat: "+b.onBoat(pos2));
		System.out.println("onBoat: "+b.onBoat(new Position(1,1)));
		System.out.println("onBoat: "+c.onBoat(pos3));
		System.out.println("onBoat: "+c.onBoat(new Position(2,3)));
		System.out.println("onBoat: "+d.onBoat(pos4));
		System.out.println("onBoat: "+d.onBoat(new Position(9,0)));
		System.out.println("onBoat: "+e.onBoat(pos5));
		System.out.println("onBoat: "+e.onBoat(new Position(9,9)));
		System.out.println("isHit: "+a.isHit(pos1));
		System.out.println("isHit: "+b.isHit(pos2));
		System.out.println("isHit: "+c.isHit(pos3));
		System.out.println("isHit: "+d.isHit(pos4));
		System.out.println("isHit: "+e.isHit(pos5));
		a.hit(new Position(0,0));
		b.hit(new Position(0,0));
		c.hit(new Position(0,0));
		d.hit(new Position(0,0));
		e.hit(new Position(0,0));
		System.out.println("isHit: "+a.isHit(pos1));
		System.out.println("isHit: "+b.isHit(pos2));
		System.out.println("isHit: "+c.isHit(pos3));
		System.out.println("isHit: "+d.isHit(pos4));
		System.out.println("isHit: "+e.isHit(pos5));
		a.hit(pos1);
		b.hit(pos2);
		c.hit(pos3);
		d.hit(pos4);
		e.hit(pos5);
		System.out.println("isHit: "+a.isHit(pos1));
		System.out.println("isHit: "+b.isHit(pos2));
		System.out.println("isHit: "+c.isHit(pos3));
		System.out.println("isHit: "+d.isHit(pos4));
		System.out.println("isHit: "+e.isHit(pos5));
		System.out.println("sunk: "+a.sunk());
		System.out.println("sunk: "+b.sunk());
		System.out.println("sunk: "+c.sunk());
		System.out.println("sunk: "+d.sunk());
		System.out.println("sunk: "+e.sunk());
		a.hit(new Position(1,1));
		a.hit(new Position(2,1));
		a.hit(new Position(3,1));
		a.hit(new Position(4,1));
		b.hit(new Position(4,4));
		b.hit(new Position(4,5));
		b.hit(new Position(4,6));
		b.hit(new Position(4,7));
		c.hit(new Position(6,0));
		c.hit(new Position(7,0));
		d.hit(new Position(6,7));
		d.hit(new Position(6,8));
		e.hit(new Position(2,6));
		System.out.println("sunk: "+a.sunk());
		System.out.println("sunk: "+b.sunk());
		System.out.println("sunk: "+c.sunk());
		System.out.println("sunk: "+d.sunk());
		System.out.println("sunk: "+e.sunk());
		System.out.println("position: "+a.position());
		System.out.println("position: "+b.position());
		System.out.println("position: "+c.position());
		System.out.println("position: "+d.position());
		System.out.println("position: "+e.position());
		System.out.println("direction: "+a.direction());
		System.out.println("direction: "+b.direction());
		System.out.println("direction: "+c.direction());
		System.out.println("direction: "+d.direction());
		System.out.println("direction: "+e.direction());
	}
	public static void testPlan() {
		Position apos = new Position(0,0);//Placing boat in position of first row and column
		Position bpos = new Position(7,9);//Attempting a place in the middle but at the end seeking error
		Position cpos = new Position(9,9);//Testing whether it can be placed at the end and seeking error
		Position dpos = new Position(4,4);//Placing boat directly in middle
		Position epos = new Position(18,-5);//Seeking error of placement
		Boat a = new Boat("Aircraft Carrier", apos, "vertical");
		//Aircraft carrier that will work correctly
		Boat b = new Boat("Battleship", bpos, "Horizontal");
		//Battleship that will go out of ocean
		Boat c = new Boat("Cruiser", cpos, "vertical");
		//Cruiser that will go out of ocean
		Boat d = new Boat("helga", dpos, "vertical");
		//Naming boat incorrectly
		Boat e = new Boat("Submarine", epos, "yes");
		//Seeing if boat can be placed with yes as orientation
//		Boat f = new Boat("Destroyer", epos, "yes");
//		//Non sunken unmodified test

		System.out.println("name: "+a.name());//Should return 
		System.out.println("name: "+b.name());//B2
		System.out.println("name: "+c.name());//B3
		System.out.println("name: "+d.name());//B4
		System.out.println("name: "+e.name());//B5

		System.out.println("abbreviation: "+a.abbreviation());//C1
		System.out.println("abbreviation: "+b.abbreviation());//C2
		System.out.println("abbreviation: "+c.abbreviation());//C3
		System.out.println("abbreviation: "+d.abbreviation());//C4
		System.out.println("abbreviation: "+e.abbreviation());//C5

		System.out.println("size: "+a.size());//D1
		System.out.println("size: "+b.size());//D2
		System.out.println("size: "+c.size());//D3
		System.out.println("size: "+d.size());//D4
		System.out.println("size: "+e.size());//D5

		System.out.println("isHit: "+a.isHit(apos));//E1
		a.hit(apos);
		System.out.println("isHit: "+b.isHit(bpos));//E2
		b.hit(bpos);
		System.out.println("isHit: "+c.isHit(cpos));//E3
		c.hit(cpos);
		System.out.println("isHit: "+d.isHit(dpos));//E4
		d.hit(apos);
		System.out.println("isHit: "+e.isHit(epos));//E5
		e.hit(apos);

		System.out.println("direction: "+a.direction());//F1
		System.out.println("direction: "+b.direction());//F2
		System.out.println("direction: "+c.direction());//F3
		System.out.println("direction: "+d.direction());//F4
		System.out.println("direction: "+e.direction());//F5

		System.out.println("sunk: "+a.sunk());
		System.out.println("sunk: "+b.sunk());
		System.out.println("sunk: "+c.sunk());
		System.out.println("sunk: "+d.sunk());
		System.out.println("sunk: "+e.sunk());

		System.out.println("position: "+a.position());
		System.out.println("position: "+b.position());
		System.out.println("position: "+c.position());
		System.out.println("position: "+d.position());
		System.out.println("position: "+e.position());
	}
	public static void test4() {
		Ocean ocean = new Ocean();

		//		Position apos = new Position(0,9);
		//		Position bpos = new Position(9,9);
		//		Position cpos = new Position(9,0);

		Position aapos = new Position(0,0);
		Position bbpos = new Position(4,9);
		Position ccpos = new Position(9,0);

		//		try {//bad cases
		//			ocean.placeBoat("Submarine", "vertical", apos);
		//		}catch(Exception ex) {
		//			System.out.println("try again");
		//		}
		//		try {
		//			ocean.placeBoat("Aircraft Carrier", "horizontal", bpos);
		//		}catch(Exception ex) {
		//			System.out.println("try again");
		//		}
		//		try {
		//			ocean.placeBoat("Cruiser", "vertical", cpos);
		//		}catch(Exception ex) {
		//			System.out.println("try again");
		//		}

		try {//good cases
			ocean.placeBoat("Submarine", "vertical", aapos);
		}catch(Exception ex) {
			System.out.println("try again");
		}
		try {
			ocean.placeBoat("Aircraft Carrier", "vertical", bbpos);
		}catch(Exception ex) {
			System.out.println("try again");
		}
		try {
			ocean.placeBoat("Cruiser", "horizontal", ccpos);
		}catch(Exception ex) {
			System.out.println("try again");
		}
	}
	public static void test5() {
		Ocean ocean = new Ocean();

		Position pos1 = new Position(0,1);
		Position pos2 = new Position(4,3);
		Position pos3 = new Position(5,0);
		Position pos4 = new Position(6,6);
		Position pos5 = new Position(1,6);

		try { ocean.placeBoat("Aircraft Carrier", "vertical", pos1); }catch(Exception ex) {
			System.out.println("atry again");
		}
		try { ocean.placeBoat("Battleship", "horizontal", pos2); }catch(Exception ex) {
			System.out.println("btry again");
		}
		try { ocean.placeBoat("Cruiser", "vertical", pos3); }catch(Exception ex) {
			System.out.println("ctry again");
		}
		try { ocean.placeBoat("Destroyer", "horizontal", pos4); }catch(Exception ex) {
			System.out.println("dtry again");
		}
		try { ocean.placeBoat("Submarine", "vertical", pos5); }catch(Exception ex) {
			System.out.println("etry again");
		}

		System.out.println("aircraft sunk: "+ocean.sunk(pos1));//false
		System.out.println("battleship sunk: "+ocean.sunk(pos2));//false
		System.out.println("cruiser sunk: "+ocean.sunk(pos3));//false
		System.out.println("destroyer sunk: "+ocean.sunk(pos4));//false
		System.out.println("submarine sunk: "+ocean.sunk(pos5));//false
		System.out.println("all sunk: "+ocean.allSunk());//false
		int c = 0;
		for(int a = 0; a < 10; a++) {
			for(int b = 0; b < 10; b++) {
				if(ocean.hit(new Position(a,b)))
					System.out.println("bad happened");//checks if every position is hit, should be false
			}
		}
		for(int a = 0; a < 10; a++) {
			for(int b = 0; b < 10; b++) {
				ocean.shootAt(new Position(a,b));//shoots at every position on the board
			}
		}
		for(int a = 0; a < 10; a++) {
			for(int b = 0; b < 10; b++) {
				if(ocean.hit(new Position(a,b)))
					c++;//checks if every position is hit should be true c should be 17
			}
		}
		System.out.println();
		System.out.println("positions hit on board: "+c);
		System.out.println();
		System.out.println("aircraft sunk: "+ocean.sunk(pos1));//true
		System.out.println("battleship sunk: "+ocean.sunk(pos2));//true
		System.out.println("cruiser sunk: "+ocean.sunk(pos3));//true
		System.out.println("destroyer sunk: "+ocean.sunk(pos4));//true
		System.out.println("submarine sunk: "+ocean.sunk(pos5));//true
		System.out.println("all sunk: "+ocean.allSunk());//true
		System.out.println();
		System.out.println("aircraft abbv: "+ocean.boatInitial(pos1));//A
		System.out.println("battleship abbv: "+ocean.boatInitial(pos2));//B
		System.out.println("cruiser abbv: "+ocean.boatInitial(pos3));//C
		System.out.println("destroyer abbv: "+ocean.boatInitial(pos4));//D
		System.out.println("submarine abbv: "+ocean.boatInitial(pos5));//S
		System.out.println("Aircraft Carrier name: "+ocean.boatName(pos1));//Aircraft Carrier
		System.out.println("Battleship name: "+ocean.boatName(pos2));//Battleship
		System.out.println("Cruiser name: "+ocean.boatName(pos3));//Cruiser
		System.out.println("Destroyer name: "+ocean.boatName(pos4));//Destroyer
		System.out.println("Submarine name: "+ocean.boatName(pos5));//Submarine
	}
	public static void test6() {
		BattleshipGrid grid = new BattleshipGrid();

		//empty places soon to be shot
		if(grid.empty(new Position(0,0)))
			System.out.println("empty place: "+0+","+0);
		if(grid.empty(new Position(9,9)))
			System.out.println("empty place: "+9+","+9);
		if(grid.empty(new Position(4,3)))
			System.out.println("empty place: "+4+","+3);
		if(grid.empty(new Position(7,2)))
			System.out.println("empty place: "+7+","+2);
		if(grid.empty(new Position(1,8)))
			System.out.println("empty place: "+1+","+8);

		//shots that miss
		char a = 'A';
		char b = 'B';
		char c = 'C';
		char s = 'S';
		char d = 'D';
		grid.shotAt(new Position(0,0), false, a);
		grid.shotAt(new Position(9,9), false, b);
		grid.shotAt(new Position(4,3), false, c);
		grid.shotAt(new Position(7,2), false, s);
		grid.shotAt(new Position(1,8), false, d);

		//not empty places
		if(!grid.empty(new Position(0,0)))
			System.out.println("not empty place: "+0+","+0);
		if(!grid.empty(new Position(9,9)))
			System.out.println("not empty place: "+9+","+9);
		if(!grid.empty(new Position(4,3)))
			System.out.println("not empty place: "+4+","+3);
		if(!grid.empty(new Position(7,2)))
			System.out.println("not empty place: "+7+","+2);
		if(!grid.empty(new Position(1,8)))
			System.out.println("not empty place: "+1+","+8);

		//misses
		if(grid.miss(new Position(0,0)))
			System.out.println("miss place: "+0+","+0);
		if(grid.miss(new Position(9,9)))
			System.out.println("miss place: "+9+","+9);
		if(grid.miss(new Position(4,3)))
			System.out.println("miss place: "+4+","+3);
		if(grid.miss(new Position(7,2)))
			System.out.println("miss place: "+7+","+2);
		if(grid.miss(new Position(1,8)))
			System.out.println("miss place: "+1+","+8);

		//places not hit
		if(!grid.hit(new Position(0,0)))
			System.out.println("not hit place: "+0+","+0);
		if(!grid.hit(new Position(9,9)))
			System.out.println("not hit place: "+9+","+9);
		if(!grid.hit(new Position(4,3)))
			System.out.println("not hit place: "+4+","+3);
		if(!grid.hit(new Position(7,2)))
			System.out.println("not hit place: "+7+","+2);
		if(!grid.hit(new Position(1,8)))
			System.out.println("not hit place: "+1+","+8);

		//true ones
		grid.shotAt(new Position(0,0), true, a);
		grid.shotAt(new Position(9,9), true, b);
		grid.shotAt(new Position(4,3), true, c);
		grid.shotAt(new Position(7,2), true, s);
		grid.shotAt(new Position(1,8), true, d);

		//places hit
		if(grid.hit(new Position(0,0)))
			System.out.println("hit place: "+0+","+0);
		if(grid.hit(new Position(9,9)))
			System.out.println("hit place: "+9+","+9);
		if(grid.hit(new Position(4,3)))
			System.out.println("hit place: "+4+","+3);
		if(grid.hit(new Position(7,2)))
			System.out.println("hit place: "+7+","+2);
		if(grid.hit(new Position(1,8)))
			System.out.println("hit place: "+1+","+8);

		System.out.println("a: "+grid.boatInitial(new Position(0,0)));
		System.out.println("b: "+grid.boatInitial(new Position(9,9)));
		System.out.println("c: "+grid.boatInitial(new Position(4,3)));
		System.out.println("s: "+grid.boatInitial(new Position(7,2)));
		System.out.println("d: "+grid.boatInitial(new Position(1,8)));


	}
	public static void test7() {
		Ocean ocean = new Ocean();
		
		ocean.placeAllBoats();
		
		for(int a = 0; a < 10; a++) {
			for(int b = 0; b < 10; b++) {
				if(!ocean.boatName(new Position(a,b)).equals("error"))
				System.out.println(ocean.boatName(new Position(a,b))+" at position: "+a+","+b);
			}
		}
	}
	public static void test8() {
		BattleshipPlayer play = new BattleshipPlayer();
		play.playerName();
		play.startGame();
		System.out.println(play.shoot());
		play.updatePlayer(new Position(0,0), true, 'A', "Aircraft Carrier", false, false, false, 1);
		play.updatePlayer(new Position(4,9), false, 'A', "Aircraft Carrier", false, true, false, 2);
		play.updatePlayer(new Position(3,2), true, 'C', "Aircraft Carrier", true, false, true, 3);
	}
	public static void test9() {
		BattleshipPlayer player = new BattleshipPlayer();
		BattleshipGame game = new BattleshipGame(player);
		
		game.play();
	}
	public static void test10() {
		ComputerBattleshipPlayer player = new ComputerBattleshipPlayer();
		PlayerEvaluator eval = new PlayerEvaluator(player, 20000);
		System.out.println("Max: "+eval.maxTurns());
		System.out.println("Min: "+eval.minTurns());
		System.out.println("Avg: "+eval.avgTurns());
	}
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//testPlan();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		test9();
		//test10();
	}

}
