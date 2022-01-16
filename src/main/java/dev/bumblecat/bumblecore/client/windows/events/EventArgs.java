package dev.bumblecat.bumblecore.client.windows.events;

public abstract class EventArgs<T> {

    private final IEventType eventType;
    private Event owner;


    public EventArgs(IEventType eventType) {
        this.eventType = eventType;
    }

    /**
     *
     * @param value
     * @return
     */
    public Event setOwner(Event value) {
        this.owner = value;
        return this.getOwner();
    }

    /**
     *
     * @return
     */
    public Event getOwner() {
        return this.owner;
    }


    /**
     *
     * @return
     */
    public IEventType getEventType() {
        return this.eventType;
    }
}
