package avaj;

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
                                p_flyable.getName(),
                                "#",
                                p_flyable.getType(),
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
                                p_flyable.getName(),
                                "#",
                                p_flyable.getType(),
                                "(",
                                p_flyable.getIdAsString(),
                                ")"
                        ),
                        " unregistered from weather tower.",
                        "\n"
                )
        );
    }

    protected void conditionChanged()
    {
        for (Flyable flyable : observers)
            flyable.updateConditions();
    }
}
