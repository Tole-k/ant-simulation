package Ants;

import AntWorld.Anthill;
import Main.Simulation;

public class Collector extends RedAnt implements Collecting
{

    public Collector(String name, int strength, int health, Anthill anthill)
    {
        super(name, strength, health, anthill);
    }

    @Override
    public void collectLarvae() throws InterruptedException
    {
        currentVertex.semaphore.acquire();
        if (currentVertex.getNumber_of_larvae() > 0)
        {
            int amount = currentVertex.getNumber_of_larvae();
            currentVertex.removeLarvae(amount);
            collected_larvae += amount;
            if (Simulation.verbosity >= 2)
                System.out.printf(ANSI_COLOR + "%s" + ANSI_RESET + " collected %d larvae\n", name, amount);
            currentVertex.semaphore.release();
            if (collected_larvae >= strength)
            {
                returnToAnthill();
            }
        } else
        {
            if (Simulation.verbosity >= 3)
                System.out.printf(ANSI_COLOR + "%s" + ANSI_RESET + " found no larvae\n", name);
            currentVertex.semaphore.release();
        }

    }

    @Override
    public void run()
    {
        while (alive)
        {
            try
            {
                randomMove();
            } catch (InterruptedException e)
            {
                break;
            }
            try
            {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e)
            {
                break;
            }
            try
            {
                collectLarvae();
            } catch (InterruptedException e)
            {
                break;
            }
            try
            {
                sleep(SLEEP_TIME);
            } catch (InterruptedException e)
            {
                break;
            }
        }
    }
}
