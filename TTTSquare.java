//Kenji Sanehira, lab section 3
public class TTTSquare { //class that is used in MyGame to test if certain squares are filled or not and which player filled it.
	private boolean filled;
	private int player;
	public TTTSquare() {
		filled = false;
		player = 0;
	}
	
	public boolean isFilled() {
		return filled;
	}
	public void fillSquare() {
		filled = true;
	}
	public void userMove() {
		player = 1;
	}
	public void compMove() {
		player = 2;
	}
	public int getPlayer() { // this is used when we check the win conditions later. 0 means an empty space, 1 means the user is in the space, 2 means the system is in the space.
		return player;
	}
}
