package lecture8;

public class ChessGame {

	public static void main(String[] args) {
		ChessPlayer yang = new ChessPlayer("Yang");
		ChessPlayer jigang = new ChessPlayer("Jigang");
		yang.setTurn(true);
		jigang.setTurn(false);
		yang.setCompetitor(jigang);
		jigang.setCompetitor(yang);
		// Thread yangThinker = new Thread(yang);
		// Thread jigangThinker = new Thread(jigang);
		Thread yangMover = new MovingThread(yang);
		Thread jigangMover = new MovingThread(jigang);

		// yangThinker.start();
		// jigangThinker.start();
		yangMover.start();
		jigangMover.start();
	}
}

class MovingThread extends Thread {
	private ChessPlayer cp;

	public MovingThread(ChessPlayer cp) {
		this.cp = cp;
	}

	public void run() {
		cp.move();
	}
}