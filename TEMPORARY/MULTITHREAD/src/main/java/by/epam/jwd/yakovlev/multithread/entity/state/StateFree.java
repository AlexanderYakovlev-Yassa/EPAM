package main.java.by.epam.jwd.yakovlev.multithread.entity.state;

public class StateFree implements State {

    private static State instance = new StateFree();

    private final String name = "FREE";

    private StateFree() {
    }

    @Override
    public void markAsUsed(State state) {

        if (state == null){
            return;
        }

        state = StateUsed.getInstance();
    }

    @Override
    public void markAsFree(State state) {
        return;
    }

    @Override
    public String getName() {
        return name;
    }

    public static State getInstance() {
        return instance;
    }
}
