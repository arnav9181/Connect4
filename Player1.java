import java.util.ArrayList;
import java.util.List;
public class Player1
{
    private Game game;
    public Player1(Game game)
    {
        this.game = game;
    }

    public int move() {
        List<Integer> open = new ArrayList<>();
        for(int i = 6; i >= 0; i--)
        {
            if(game.placeC[0][i] == 0)
            {
                open.add(i);
            }
        }
        int position = (int) (Math.random() * 6);
        return position;
//        game.play(position, 2);
    }

}
