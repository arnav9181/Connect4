import processing.core.PApplet;
import processing.core.PImage;

import java.util.List;

public class Connect4 extends PApplet {


	public void settings() {
    size(700, 700);
	}

	private boolean redraw=false;
	private boolean start= true;
	private Game game;
	PImage img;
	private int counter = 0;
	int player = 1;
	private SmartPlayer smP;
	private Player1 randomp;
	private int x;

	public void setup()
	{
    	background(0);
		img = loadImage("connect4.png");
		game = new Game();
  	}

  	public void draw() {

		if (start) {
			textSize(30);
			text("Welcome to Connect 4!", 170, 250);
			fill(0, 102, 153);
			text("Click to start playing", 190, 300);
			fill(0, 102, 153, 51);
			start = false;
		}

		if (redraw) {
			background(0);
			image(img, 100, 200);


			textSize(18);
			fill(0, 102, 153, 255);
			text("Choose your Opponent:", 10, 30);
			text("Smart Player", 40, 70);
			text("--Click Smart Player two times to begin", 180,70);
			text("Random Player", 40, 90);
			text ("Click Random Player two times to begin", 180, 90);
			text("Human Player (Friend)", 40, 130);
			text("--Click twice on the board to play humans", 240, 130);

			stroke(0, 0, 255);
			point(mouseX, mouseY);
			//System.out.println(String.format("(%d, %d)", mouseX, mouseY));
			smP = new SmartPlayer(game,2);
			randomp = new Player1(game);
			if (counter > 2)
			{
				int s = mouseCheck(counter);
				if (s == -1)
				{
					return;
				}
				int[][] l;
				if (counter % 2 == 0)
				{
					player = 1;
					game.play(s, player);
					l = game.placeC;

					if (x == 1)
					{
						counter++;
						int x = smP.move();
						game.play(x, 2);
					}
					else if( x == 2)
					{
						counter++;
						int x = randomp.move();
						game.play(x, 2);
					}
				}
				else
				{
					player = 2;
					game.play(s, player);
					l = game.placeC;
				}

				for (int i = 5; i >= 0; i--) {
					for (int j = 6; j >= 0; j--) {
						if (l[i][j] != 0) {
							List<Integer> cord = game.getCord(i, j);
							if (l[i][j] == 1)
								drawCoin(cord.get(0), cord.get(1));
							else if (l[i][j] == 2)
								drawCoin2(cord.get(0), cord.get(1));

						}
					}
				}

				for (int i = 5; i >= 0; i--) {
					for (int j = 6; j >= 0; j--) {
						if (game.checkHoriz(l, i, j) != 0) {
							print("Congratulations, you completed the game horizontally");
							winScreen(game.checkHoriz(l, i, j));
							noLoop();
						} else if (game.checkVert(l, i, j) != 0) {
							print("Congratulations, you have completed the game Vertically");
							winScreen(game.checkVert(l, i, j));
							noLoop();
						} else if (game.checkDiag(l, i, j) != 0) {
							print("Congratulations, you have completed the game Diagonally!");
							winScreen(game.checkDiag(l, i, j));
							noLoop();
						} else if (game.checkDiag2(l, i, j) != 0) {
							winScreen(game.checkDiag2(l, i, j));
							noLoop();
						}
					}
				}

				redraw = false;
			}
		}

	}

	  public void drawCoin(int x, int y)
	  {
		  fill(255, 0, 0);
		  circle(x,y,50);
	  }

	public void drawCoin2(int x, int y)
	{
		fill(0, 0, 255);
		circle(x,y,50);
	}



	public int mouseCheck(int c) {
			  int pos = 0;
			  if (mouseX >= 101 && mouseX <= 171 && mouseY >= 135 && mouseY <= 800) {
				  pos = 0;
				  return pos;
			  }

			  if (mouseX >= 171 && mouseX <= 239 && mouseY >= 135 && mouseY <= 800) {
				  pos = 1;
				  return pos;
			  }
			  if (mouseX >= 239 && mouseX <= 302 && mouseY >= 135 && mouseY <= 800) {
				  pos = 2;
				  return pos;
			  }

			  if (mouseX >= 302 && mouseX <= 376 && mouseY >= 135 && mouseY <= 800) {
				  pos = 3;
				  return pos;
			  }

			  if (mouseX >= 376 && mouseX <= 450 && mouseY >= 135 && mouseY <= 800) {
				  pos = 4;
				  return pos;
			  }
			  if (mouseX >= 450 && mouseX <= 510 && mouseY >= 135 && mouseY <= 800) {
				  pos = 5;
				  return pos;
			  }
			  if (mouseX >= 510 && mouseX <= 580 && mouseY >= 135 && mouseY <= 800) {
				  pos = 6;
				  return pos;
			  } else
				  return -1;
		  }

	public void winScreen(int player)
	{
		if (player == 1)
		{
			textSize(30);
			background(0, 0,0);
			fill(0, 102, 153);
			text("YOU'RE THE WINNER, PLAYER 2", 190, 300);
			fill(0, 102, 153, 51);
		}
		else
		{
			textSize(30);
			background(0, 0,0);
			fill(0, 102, 153);
			text("YOU'RE THE WINNER, PLAYER 1", 190, 300);
			fill(0, 102, 153, 51);
		}
	}

  	public void mousePressed()
	{
		if(mouseX > 35 && mouseX < 150 && mouseY > 55 && mouseY < 75 )
			  x =1;
		else if(mouseX > 35 && mouseX < 150 && mouseY > 80 && mouseY < 105)
				x = 2;
		counter++;
		redraw= true;
	}

  	public static void main(String args[]) {
      PApplet.main("Connect4");


   }
}
