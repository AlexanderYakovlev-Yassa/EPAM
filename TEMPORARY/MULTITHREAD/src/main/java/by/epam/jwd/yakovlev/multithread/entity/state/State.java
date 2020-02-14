package main.java.by.epam.jwd.yakovlev.multithread.entity.state;

public interface State {

    void markAsUsed(State state);
    void markAsFree(State state);
    String getName();
}
