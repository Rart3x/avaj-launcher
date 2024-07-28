import java.util.List;


public class Tower {
    List<Flyable> observers;

    public void register(Flyable p_flyable)
    {
        observers.add(p_flyable);
        Utils.printInfo(
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
                        " registered to weather tower."
                )
        );
    }

    public void unregister(Flyable p_flyable)
    {
        observers.remove(p_flyable);
        Utils.printInfo(
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
                        " unregistered from weather tower."
                )
        );
    }

    protected void conditionChanged()
    {
        for (Flyable flyable : observers)
            flyable.updateConditions();
    }
}
