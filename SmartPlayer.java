public class SmartPlayer {

    private Game game;
    private int id;
    public SmartPlayer(Game game, int id)
    {
        this.game = game;
        this.id = id;

    }

    public int blockHoriz(int [][]grid, int startRow, int startCol)
    {
        int score=0;
        int p = grid[startRow][startCol];
        int notP=0;
        for(int i = 3; i>=0; i--)
        {
            if (startCol+i >= grid[0].length)
            {
                return 0;
            }
            if (grid[startRow][startCol + i] != p)
            {
                score+=1;
            }

        }
        if (score==3 && p!=id) {

        }
        return p;
    }



    public int move() {


        int maxWins=0;
        int maxCol=0;
        for (int i=0;i<6;i++) {
            int AIWins=0;

            for (int runs=0;runs<100;runs++){
                Game gamecopy = new Game();
                gamecopy.placeC = new int[game.placeC.length][];
                for(int j = 0; j < game.placeC.length; j++)
                    gamecopy.placeC[j] = game.placeC[j].clone();
                gamecopy.play(i,2);
                if (gamecopy.checkWin()!=0) {
                    return i;
                }
                int c=0;
                while (true) {
                    c++;
                    if (c>1000)
                        break;
                    gamecopy.play((int) (Math.random() * 6), 1);
                    if (gamecopy.checkWin() != 0) {
                        break;
                    }
                    gamecopy.play((int) (Math.random() * 6), 2);
                    if (gamecopy.checkWin() != 0) {
                        AIWins+=1;
                        break;
                    }
                }
            }
            if (AIWins > maxWins){
                maxWins=AIWins;
                maxCol=i;
            }
        }

        return maxCol;


    }
}
