
import java.util.ArrayList;
import java.util.List;
// i IS MY ROW
//pos IS MY COLUMN

public class Game
{
    public int[][] placeC;

    public Game()
    {
        this.placeC = new int[6][7];
    }

    public void printBoard()
    {
        for (int[] place : placeC){
            for (int a: place){
                System.out.print(String.format("%d ", a));
            }
            System.out.println(" ");
        }
    }

    public void play(int pos, int player) {
        for (int i = 5; i >= 0; i--) {
            if (placeC[i][pos] == 0) {
                placeC[i][pos] = player;
                return;
            }
        }
    }

    public List<Integer> getCord(int row, int col)
    {
        List<Integer> getCoord = new ArrayList<>();

        int firstCircleY = 238;
        int firstCircleX = 136;
        int distBetweenCircles = 70;
        int drawCircleAtY = firstCircleY + distBetweenCircles * row;
        int drawCircleAtX = firstCircleX + distBetweenCircles * col;
        getCoord.add(drawCircleAtX);
        getCoord.add(drawCircleAtY);
         return getCoord;
    }
    public int checkHoriz(int [][]grid, int startRow, int startCol)
    {
        int p = grid[startRow][startCol];
        for(int i = 3; i>=0; i--)
        {
            if (startCol+i >= grid[0].length)
            {
                return 0;
            }
            if (grid[startRow][startCol + i] != p)
            {
                return 0;
            }

        }
        return p;
    }

    public int checkVert(int[][]grid, int startRow, int startCol)
    {
        int p = grid[startRow][startCol];
        for(int i = 3; i>=0; i--)
        {
            if (startRow+i >= 6)
            {
                return 0;
            }
            if(grid[startRow+i][startCol] != p)
            {
                return 0;
            }

        }
        return p;
    }


    public int checkDiag(int[][]grid, int startRow, int startCol)
    {
        int p = grid[startRow][startCol];
        if (p == 0){
            return 0;
        }
        for(int i = 3; i>=0; i--)
        {
            if (startRow+i > 5)
            {
                return 0;
            }
            if (startCol+i > 6)
            {
                return 0;
            }
            if(grid[startRow+i][startCol+i] != p)
            {
                return 0;
            }

        }
        return p;
    }

    public int checkDiag2(int[][]grid, int startRow, int startCol)
    {
        int p = grid[startRow][startCol];
        if (p == 0){
            return 0;
        }
        for(int i = 3; i>=0; i--)
        {
            if (startRow+i > 5)
            {
                return 0;
            }
            if (startCol - i < 0)
            {
                return 0;
            }
            if(grid[startRow+i][startCol-i] != p)
            {
                return 0;
            }

        }
        return p;
    }

    public int checkWin() {
        for (int i = 5; i >= 0; i--) {
            for (int j = 6; j >= 0; j--) {
                if (checkHoriz(placeC, i, j) != 0) {
                    return checkHoriz(placeC, i, j);
                } else if (checkVert(placeC, i, j) != 0) {
                    return checkVert(placeC, i, j);
                } else if (checkDiag(placeC, i, j) != 0) {
                    return checkDiag(placeC,i,j);
                } else if (checkDiag2(placeC, i, j) != 0) {
                    return checkDiag2(placeC,i,j);
                }
            }
        }
        return 0;
    }




    }
