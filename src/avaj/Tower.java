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

    public void unregisterAll()
    {
        while (!observers.isEmpty())
            unregister(observers.get(0));
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

    public void unregisterWithoutLog(Flyable p_flyable) {
        observers.remove(p_flyable);
    }

    protected void conditionChanged()
    {
        List<Flyable> toUnregister = new ArrayList<>();

        for (Flyable flyable : observers)
        {
            if (flyable.getCoordinates().getHeight() == 0 && !flyable.isLanded)
            {
                Utils.printInFile(flyable.getType() + "#" + flyable.getName() + "(" + flyable.getIdAsString() + ") landing.\n");
                Utils.printInFile(
                        Utils.concatString(
                                "Tower says: ",
                                Utils.concatString(
                                        flyable.getType(),
                                        "#",
                                        flyable.getName(),
                                        "(",
                                        flyable.getIdAsString(),
                                        ")"
                                ),
                                " unregistered from weather tower.",
                                "\n"
                        )
                );
                toUnregister.add(flyable);
                flyable.isLanded = true;
            }
            else
                Utils.printDependingOnWeather(flyable);
            flyable.updateConditions();
        }

        for (Flyable toRemoved : toUnregister)
            unregisterWithoutLog(toRemoved);
    }
}
