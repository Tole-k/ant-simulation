package Main;

import java.io.FileNotFoundException;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException, InterruptedException
    {
        Simulation simulation = new Simulation();
        simulation.run();
    }
}