package GUI;

import AntWorld.Anthill;

import java.awt.*;

public class BluePoints extends Points
{
    Anthill blue;

    public BluePoints(Anthill blue)
    {
        super();
        this.setForeground(Color.BLUE);
        this.blue = blue;
    }

    @Override
    public void run()
    {
        while (true)
        {
            updateScore(blue.getAmount_of_food());
        }
    }

}
