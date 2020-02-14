package main.java.by.epam.jwd.yakovlev.multithread.entity.state;

public class StateUsed implements State {

    private static State instance = new StateUsed();

    private final String name = "USED";

    private StateUsed() {
    }

    @Override
    public void markAsUsed(State state) {
        return;
    }

    @Override
    public void markAsFree(State state) {

        if (state == null){
            return;
        }

        state = StateFree.getInstance();
    }

    @Override
    public String getName() {
        return name;
    }

    public static State getInstance() {
        return instance;
    }
}
