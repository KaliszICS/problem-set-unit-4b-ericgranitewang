import java.util.*;
public class ProblemSet {

	public static void main(String args[]) {
		//tilestack tests
		// TileStack among = new TileStack(new String[]{"Among", "Sus", "Ohio", "Skibidy"});
		// System.out.println(among.pop());
		// among.push("Sigma");
		// System.out.println(among.toString());
		// String[] arr = among.removeAll();
		// for (int i = 0; i < 4; i++) {
		// 	System.out.println(arr[i]);
		// }
		// System.out.println(among.peek());
		//gameboard tests
		GameBoard ohio = new GameBoard();
		ohio.resetBoard();
		ohio.fillFrom(new String[]{"skibidy", "sigma", "gyatt"});
		GamePiece sigma = new GamePiece("sigma", "skibidy", 0);
		ohio.setTile(3, 1, "alpha");
		System.out.println(ohio.getPiece(3, 1));
		ohio.placePiece(sigma, 0, 0);
		System.out.println(ohio.toString());
		GameBoard sus = new GameBoard();
		// System.out.println(sus.toString());
		Scanner in = new Scanner(System.in);
		Player a = new Player("Mike", 1);
		GamePiece mikePiece = new GamePiece("circle", "mike", 0);
		Player b = new Player("Steve", 500);
		GamePiece stevePiece = new GamePiece("circle", "steve", 0);
		sus.placePiece(mikePiece, 0, 0);
		// sus.placePiece(stevePiece, 0, 0);
		//board can only contain 1 piece at a time on a specific tile, now what?
		int mikedex = 0;
		int stevedex = 0;
		while (Math.max(mikedex, stevedex) != 24) {
			int mikemove = Math.min((int)(Math.random()*6+1), 24-mikedex);
			int stevemove = Math.min((int)(Math.random()*6+1), 24-stevedex);
			a.pickUp(sus, mikedex/5, mikedex%5);
			mikedex += mikemove;
			a.returnPiece(mikePiece, sus, mikedex/5, mikedex%5);
			// b.pickUp(sus, stevedex/5, stevedex%5);
			// stevedex += stevemove;
			// b.returnPiece(stevePiece, sus, stevedex/5, stevedex%5);
			// System.out.println(sus.toString() + '\n');
		}
		in.close();
	}
	//do the edge case of 1 and 0 size later!!

	/*
	Things to ask
	a) does pickUp in Player remove the piece from the board or does it just clone it
	b) what does the empty mean in TileStack push()
	c) can the board be zero in size
	d) does it matter if everything breaks because the user put in the wrong values
	e) when to use tilestack in example game
	*/
	

}
