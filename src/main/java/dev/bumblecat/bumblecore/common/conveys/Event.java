package dev.bumblecat.bumblecore.common.conveys;

public abstract class Event implements IEvent {

    private final IEventArgs arguments;

    private boolean canceled;

    public Event(IEventArgs arguments) {
        this.arguments = arguments;
    }


    /**
     *
     * @return
     */
    public IEventArgs getArguments() {
        return this.arguments;
    }


    /**
     * @return
     */
    public boolean getCanceled() {
        return this.canceled;
    }

    /**
     * @return
     */
    public <T extends IEvent> T setCanceled() {
        return this.setCanceled(true);
    }

    /**
     * @param value
     * @return
     */
    public <T extends IEvent> T setCanceled(boolean value) {
        this.canceled = value;
        return (T)this;
    }
}
