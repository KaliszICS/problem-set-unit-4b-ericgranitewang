import java.util.*;
public class ProblemSet {

	public static void main(String args[]) {
		// //tilestack tests
		// // TileStack among = new TileStack(new String[]{"Among", "Sus", "Ohio", "Skibidy"});
		// // System.out.println(among.pop());
		// // among.push("Sigma");
		// // System.out.println(among.toString());
		// // String[] arr = among.removeAll();
		// // for (int i = 0; i < 4; i++) {
		// // 	System.out.println(arr[i]);
		// // }
		// // System.out.println(among.peek());
		// //gameboard tests
		// GameBoard ohio = new GameBoard();
		// // ohio.resetBoard();
		// // ohio.fillFrom(new String[]{"skibidy", "sigma", "gyatt"});
		// GamePiece sigma = new GamePiece("sigma", "skibidy", 0);
		// GamePiece omega = new GamePiece("sigma", "skibidy", 0);
		// System.out.println(sigma.equals(omega));
		// // ohio.setTile(3, 1, "alpha");
		// System.out.println(ohio.getPiece(3, 1));
		// ohio.placePiece(sigma, 0, 0);
		// // System.out.println(ohio.removePiece(0, 0).getColor());
		// // System.out.println(ohio.toString());
		// //player tests
		// Player quandale = new Player("Quandale Dingle", 54, new GamePiece[]{sigma, omega});
		// System.out.println(quandale);
		// quandale.discardPiece(sigma);
		// quandale.pickUp(ohio, 0, 0);
		// quandale.returnPiece(omega, ohio, 0, 0);
		// System.out.println(quandale);
		// System.out.println(ohio);
		// GameBoard sus = new GameBoard();
		// // System.out.println(sus.toString());
		// Scanner in = new Scanner(System.in);
		// Player a = new Player("Mike", 1);
		// GamePiece mikePiece = new GamePiece("circle", "mike", 0);
		// Player b = new Player("Steve", 500);
		// GamePiece stevePiece = new GamePiece("circle", "steve", 0);
		// sus.placePiece(mikePiece, 0, 0);
		// // sus.placePiece(stevePiece, 0, 0);
		// //board can only contain 1 piece at a time on a specific tile, now what?
		// int mikedex = 0;
		// int stevedex = 0;
		// while (Math.max(mikedex, stevedex) != 24) {
		// 	int mikemove = Math.min((int)(Math.random()*6+1), 24-mikedex);
		// 	int stevemove = Math.min((int)(Math.random()*6+1), 24-stevedex);
		// 	a.pickUp(sus, mikedex/5, mikedex%5);
		// 	mikedex += mikemove;
		// 	a.returnPiece(mikePiece, sus, mikedex/5, mikedex%5);
		// 	// b.pickUp(sus, stevedex/5, stevedex%5);
		// 	// stevedex += stevemove;
		// 	// b.returnPiece(stevePiece, sus, stevedex/5, stevedex%5);
		// 	// System.out.println(sus.toString() + '\n');
		// }
		// in.close();
		TileStack it = new TileStack(new String[]{});
		System.out.println(new GamePiece(null, null, 0).equals(null));
	}
	

}
