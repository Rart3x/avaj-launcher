package avaj;

import avaj.transports.Flyable;
import avaj.utils.Utils;

import java.util.ArrayList;
import java.util.List;


public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable)
    {
        observers.add(p_flyable);
        Utils.printInFile(
                Utils.concatString(
                        "Tower says: ",
                        Utils.concatString(
                                p_flyable.getType(),
                                "#",
                                p_flyable.getName(),
                                "(",
                                p_flyable.getIdAsString(),
                                ")"
                        ),
                        " registered to weather tower.",
                        "\n"
                )
        );
    }

    public void unregister(Flyable p_flyable)
    {
        observers.remove(p_flyable);
        Utils.printInFile(
                Utils.concatString(
                        "Tower says: ",
                        Utils.concatString(
                                p_flyable.getType(),
                                "#",
                                p_flyable.getName(),
                                "(",
                                p_flyable.getIdAsString(),
                                ")"
                        ),
                        " unregistered from weather tower.",
                        "\n"
                )
        );
    }

    public void unregisterAll()
    {
        while (!observers.isEmpty())
            unregister(observers.get(0));
    }

    protected void conditionChanged()
    {
        List<Flyable> toUnregister = new ArrayList<>();

        for (Flyable flyable : observers)
        {
            flyable.updateConditions();
            if (flyable.getCoordinates().getHeight() == 0)
            {
                Utils.printInFile("Tower says: " + flyable.getType() + "#" + flyable.getName() + "(" + flyable.getIdAsString() + ") landing.\n");
                toUnregister.add(flyable);
            }
            else
                Utils.printDependingOnWeather(flyable);
        }

        for (Flyable toRemoved : toUnregister)
            unregister(toRemoved);
    }
}
