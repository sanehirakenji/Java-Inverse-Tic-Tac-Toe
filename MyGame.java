
// Kenji Sanehira, lab section 3
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyGame extends JFrame{
	public enum Squares{TopLeft,Top,TopRight,Left,Middle,Right,BottomLeft,Bottom,BottomRight,Nothing} 
	
	private JLayeredPane layeredPane;
	private JFrame frame;
	private int counter; //counts the current turn
	private boolean gameEnd; // checks if the game is over or not
	private int x;
	private int y;
	private Squares square;
	private int winner; // 0 means draw. 1 means system win. 2 means user win.
	private TTTSquare TL; //creating a TTTSquare object for each of the 9 squares in tic tac toe
	private TTTSquare T; // Top, Left, Right, Middle, Bottom
	private TTTSquare TR;
	private TTTSquare L;
	private TTTSquare M;
	private TTTSquare R;
	private TTTSquare BL;
	private TTTSquare B;
	private TTTSquare BR;
	
	
	public MyGame() {
		TL = new TTTSquare();
		T = new TTTSquare();
		TR = new TTTSquare();
		L = new TTTSquare();
		M = new TTTSquare();
		R = new TTTSquare();
		BL = new TTTSquare();
		B = new TTTSquare();
		BR = new TTTSquare();
		
		counter = 0;
		gameEnd = false;
		winner = 0;
		
		JPanel gameBoard = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawLine(201, 0, 201, 602);
				g.drawLine(402, 0, 402, 602);
				g.drawLine(0, 201, 602, 201);
				g.drawLine(0, 402, 602, 402);
				
			}
		};
		gameBoard.setOpaque(true);
		gameBoard.setBounds(0,0,602,602);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 602, 602);
		layeredPane.add(gameBoard);
		
		frame = new JFrame("Inverse Tic Tac Toe");
		
		frame.addMouseListener(new MouseAdapter() { 
			
			public void mouseClicked(MouseEvent e) { //Mouse Listener that listens for Mouse Clicks
				if(gameEnd == true) {
					return;
				}
				x = e.getX();
				y = e.getY();
				square = sortCoords(x,y);
				
				switch(square) { // switch statement should only be run while the counter < 8 and will consist of user turns followed by system turns.
				case TopLeft:
					if(counter == 8 || TL.isFilled() == true) { // If the container is filled, do nothing.
						break;
					}else {
							TL.fillSquare();
							TL.userMove(); // setting the value of player in the TTTSquare object to 1 for player.
							layeredPane.add(userTurn(75,110, 0,0));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
				
					
				case Top:
					if(counter == 8 ||T.isFilled() == true) {
						break;
					}else {
							T.fillSquare();
							T.userMove();
							layeredPane.add(userTurn(75,110,202,0));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
					
				case TopRight:
					if(counter == 8 ||TR.isFilled() == true) {
						break;
					}else {
						TR.fillSquare();
						TR.userMove();
							layeredPane.add(userTurn(75,110,410,0));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
					
					
				case Left:
					if(counter == 8 ||L.isFilled() == true) {
						break;
					}else {
							L.fillSquare();
							L.userMove();
							layeredPane.add(userTurn(75,110,0,202));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
					
					
				case Middle:
					if(counter == 8 ||M.isFilled() == true) {
						break;
					}else {
							M.fillSquare();
							M.userMove();
							layeredPane.add(userTurn(75,110,202,202));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
					
					
				case Right:
					if(counter == 8 ||R.isFilled() == true) {
						break;
					}else {
							R.fillSquare();
							R.userMove();
							layeredPane.add(userTurn(75,110,410,202));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
					
					
				case BottomLeft:
					if(counter == 8 ||BL.isFilled() == true) {
						break;
					}else {
						BL.fillSquare();
						BL.userMove();
						layeredPane.add(userTurn(75,110,0,403));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
					
					
				case Bottom:
					if(counter == 8 ||B.isFilled() == true) {
						break;
					}else {
						B.fillSquare();
						B.userMove();
						layeredPane.add(userTurn(75,110,202,403));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
					
					
				case BottomRight:
					if(counter == 8 ||BR.isFilled() == true) {
						break;
					}else {
						BR.fillSquare();
						BR.userMove();
							layeredPane.add(userTurn(75,110,403,403));
							counter++;
							layeredPane.add(randomCompTurn());
							counter++;
							break;
						}
					
					
				case Nothing:
					break;
				default:
					break;
				}
				
				if (counter == 8) { // If it is the last turn, the computer should not play
					switch(square) {
					case TopLeft:
						if(TL.isFilled() == true) {
							break;
						}else {
								TL.fillSquare();
								TL.userMove();
								layeredPane.add(userTurn(75,110, 0,0));
								counter++;
								break;
							}
					
						
					case Top:
						if(T.isFilled() == true) {
							break;
						}else {
								T.fillSquare();
								T.userMove();
								layeredPane.add(userTurn(75,110,202,0));
								counter++;
								break;
							}
						
					case TopRight:
						if(TR.isFilled() == true) {
							break;
						}else {
							TR.fillSquare();
							TR.userMove();
								layeredPane.add(userTurn(75,110,410,0));
								counter++;
								break;
							}
						
						
					case Left:
						if(L.isFilled() == true) {
							break;
						}else {
								L.fillSquare();
								L.userMove();
								layeredPane.add(userTurn(75,110,0,202));
								counter++;
								break;
							}
						
						
					case Middle:
						if(M.isFilled() == true) {
							break;
						}else {
								M.fillSquare();
								M.userMove();
								layeredPane.add(userTurn(75,110,202,202));
								counter++;
								break;
							}
						
						
					case Right:
						if(R.isFilled() == true) {
							break;
						}else {
								R.fillSquare();
								R.userMove();
								layeredPane.add(userTurn(75,110,410,202));
								counter++;
								break;
							}
						
						
					case BottomLeft:
						if(BL.isFilled() == true) {
							break;
						}else {
							BL.fillSquare();
							BL.userMove();
							layeredPane.add(userTurn(75,110,0,403));
								counter++;
								break;
							}
						
						
					case Bottom:
						if(B.isFilled() == true) {
							break;
						}else {
							B.fillSquare();
							B.userMove();
							layeredPane.add(userTurn(75,110,202,403));
								counter++;
								break;
							}
						
						
					case BottomRight:
						if(BR.isFilled() == true) {
							break;
						}else {
							BR.fillSquare();
							BR.userMove();
								layeredPane.add(userTurn(75,110,403,403));
								counter++;
								break;
							}
						
						
					case Nothing:
						break;
					default:
						break;
					}	
				}
				
			
			testWinCondition();
			
			if(gameEnd == true || counter == 9) {
				if (winner == 0) { // if the value of winner is not changed by testWinCondition(), the game is a draw.
					JFrame endFrame = new JFrame();
					JPanel tie = new JPanel();
					endFrame.add(tie);
					tie.setLayout(new BoxLayout(tie, BoxLayout.Y_AXIS));
					JLabel message = new JLabel("Well played, it is a tie! ");
					tie.add(message);
					JLabel end = new JLabel("Close out of this window to exit!");
					tie.add(end);
					endFrame.add(tie);
					
					endFrame.setSize(250,150);
					endFrame.setTitle("Draw!");
					endFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
					endFrame.setVisible(true);
					
				return;
				}else if (winner == 1) {
				JFrame endFrame = new JFrame();
				JPanel sWin = new JPanel();
	
				sWin.setLayout(new BoxLayout(sWin, BoxLayout.Y_AXIS));
				JLabel message = new JLabel("You got three in a row and lost!");
				sWin.add(message);
				JLabel end = new JLabel("Close out of this window to exit!");
				sWin.add(end);
				endFrame.add(sWin);
				
				endFrame.setSize(250,150);
				endFrame.setTitle("Loss!");
				endFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				endFrame.setVisible(true);
			
				return;
				}else if (winner == 2) {
				JFrame endFrame = new JFrame();
				JPanel uWin = new JPanel();
			
				uWin.setLayout(new BoxLayout(uWin, BoxLayout.Y_AXIS));
				JLabel message = new JLabel("Congratulations! You won!");
				uWin.add(message);
				JLabel end = new JLabel("Close out of this window to exit!");
				uWin.add(end);
				endFrame.add(uWin);
				
				endFrame.setSize(250,150);
				endFrame.setTitle("Win!");
				endFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				endFrame.setVisible(true);
				return;
				}
			}
				
				
		
			}
		});
	
		frame.add(layeredPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension (602,602));
		frame.setLayout(null);
		frame.setVisible(true);
		
	

	}
	
	public JPanel userTurn(int x, int y, int cord1, int cord2) { // Method that draws a square for the user.
		
		JPanel newSpace = new JPanel() { 
		protected void paintComponent(Graphics g) {
			g.drawLine(x, y, x+50, y );
			g.drawLine(x+50, y, x+50, y-50);
			g.drawLine(x+50, y - 50, x, y - 50);
			g.drawLine(x, y-50, x, y);
			
			}
		};
		newSpace.setOpaque(false);
		newSpace.setBounds(cord1, cord2, 200, 200);
		return newSpace;
	}
	public JPanel randomCompTurn() { // A strategy to win by the system. Checking to see which squares are filled to win.
		if(TL.isFilled() == false) {
			TL.fillSquare();
			TL.compMove();
			return compTurn(100,70,0,0);
			
		}else if(TR.isFilled() == false) {
			TR.fillSquare();
			TR.compMove();
			return compTurn(100,70,403,0);
		}else if (BL.isFilled() == false) {
			BL.fillSquare();
			BL.compMove();
			return compTurn(100,70,0,403);
		}else if (BR.isFilled() == false) {
			BR.fillSquare();
			BR.compMove();
			return compTurn(100,70,403,403);
		}else if (M.isFilled() == false){
			M.fillSquare();
			M.compMove();
			return compTurn(100,70,202,202);
		}else if (T.isFilled() == false) {
			T.fillSquare();
			T.compMove();
			return compTurn(100,70,202,0);
		}else if (L.isFilled() == false) {
			L.fillSquare();
			L.compMove();
			return compTurn(100,70,0,202);
		}else if (R.isFilled() == false) {
			R.fillSquare();
			R.compMove();
			return compTurn(100,70,403,202);
		}else{
			B.fillSquare();
			B.compMove();
			return compTurn(100,70,202,403);
		}
		
	}
	public JPanel compTurn(int x, int y, int cord1, int cord2) { // A method that draws a diamond for the system.
		JPanel compSpace = new JPanel() {
			protected void paintComponent(Graphics g) {
				g.drawLine(x, y, x + 25, y+25);
				g.drawLine(x+25, y + 25, x, y + 50);
				g.drawLine(x, y+50,x-25, y + 25);
				g.drawLine(x-25, y+25, x, y);
			}
		};
		compSpace.setOpaque(false);
		compSpace.setBounds(cord1,cord2, 200,200);
		return compSpace;
	}
	public void testWinCondition() { // Checking to see if the player or the system won. If the player wins, assign winner to 2. If the system wins, assign winner to 1.
		if(counter > 5) {
			if(1 == TL.getPlayer() && TL.getPlayer() == T.getPlayer() && T.getPlayer() == TR.getPlayer()) {
				gameEnd = true;
				winner = 1;
			}else if (1 == L.getPlayer() && L.getPlayer() == M.getPlayer() && M.getPlayer() == R.getPlayer()) {
				gameEnd = true;
				winner = 1;
			}else if (1 == BL.getPlayer() && BL.getPlayer() == B.getPlayer() && B.getPlayer() == BR.getPlayer()) {
				gameEnd = true;
				winner = 1;
			}else if (1 == T.getPlayer() && T.getPlayer() == M.getPlayer() && M.getPlayer() == B.getPlayer()) {
				gameEnd = true;
				winner = 1;
			}else if (1 == TL.getPlayer() && TL.getPlayer() == L.getPlayer() && L.getPlayer() == BL.getPlayer()) {
				gameEnd = true;
				winner = 1;
			}else if (1 == TR.getPlayer() && TR.getPlayer() == R.getPlayer() && R.getPlayer() == BR.getPlayer()) {
				gameEnd = true;
				winner = 1;
			}else if (1 == TL.getPlayer() && TL.getPlayer() == M.getPlayer() && M.getPlayer() == BR.getPlayer()) {
				gameEnd = true;
				winner = 1;
			}else if (1 == TR.getPlayer() && TR.getPlayer() == M.getPlayer() && M.getPlayer() == BL.getPlayer()) {
				gameEnd = true;
				winner = 1;
			}else if (2 == TL.getPlayer() && TL.getPlayer() == T.getPlayer() && T.getPlayer() == TR.getPlayer()) {
				gameEnd = true;
				winner = 2;
			}else if (2 == L.getPlayer() && L.getPlayer() == M.getPlayer() && M.getPlayer() == R.getPlayer()) {
				gameEnd = true;
				winner = 2;
			}else if (2 == BL.getPlayer() && BL.getPlayer() == B.getPlayer() && B.getPlayer() == BR.getPlayer()) {
				gameEnd = true;
				winner = 2;
			}else if (2 == T.getPlayer() && T.getPlayer() == M.getPlayer() && M.getPlayer() == B.getPlayer()) {
				gameEnd = true;
				winner = 2;
			}else if (2 == TL.getPlayer() && TL.getPlayer() == L.getPlayer() && L.getPlayer() == BL.getPlayer()) {
				gameEnd = true;
				winner = 2;
			}else if (2 == TR.getPlayer() && TR.getPlayer() == R.getPlayer() && R.getPlayer() == BR.getPlayer()) {
				gameEnd = true;
				winner = 2;
			}else if (2 == TL.getPlayer() && TL.getPlayer() == M.getPlayer() && M.getPlayer() == BR.getPlayer()) {
				gameEnd = true;
				winner = 2;
			}else if (2 == TR.getPlayer() && TR.getPlayer() == M.getPlayer() && M.getPlayer() == BL.getPlayer()) {
				gameEnd = true;
				winner = 2;
			}
		}
	}
	public Squares sortCoords(int xcord, int ycord) { // method that takes the x and y values given by the MouseListener, and assigns them into the different squares in the enumerated group.
	if (xcord < 207  && ycord < 230 && xcord > 0 && ycord >0) {
		return Squares.TopLeft;
	}else if(201< xcord && xcord < 402 && 0 < ycord && ycord < 230) {
		return Squares.Top;
	}else if(408 < xcord && xcord < 604 && 0 < ycord && ycord < 230) {
		return Squares.TopRight;
	}else if(0< xcord && xcord < 207 && 232 < ycord && ycord < 431) {
		return Squares.Left;
	}else if(201 < xcord && xcord < 402 && 232 < ycord && ycord < 431) {
		return Squares.Middle;
	}else if (408 < xcord && xcord < 604 && 201 < ycord && ycord < 431) {
		return Squares.Right;
	}else if(0< xcord && xcord < 207 && 402 < ycord && ycord < 624) {
		return Squares.BottomLeft;
	}else if(201 < xcord && xcord < 402 && 402 < ycord && ycord < 624) {
		return Squares.Bottom;
	}else if (408 < xcord && xcord < 604 && 402 < ycord && ycord < 624) {
		return Squares.BottomRight;
	}else {
		return Squares.Nothing;
	}
	}
	public static void main(String[] args) {
		MyGame TicTacToe = new MyGame();
	}
}
