package dev.bumblecat.bumblecore.common.conveys;

public abstract class EventArgs<T> implements IEventArgs {

    private IEvent event;
    private final IEventType eventType;

    /**
     * @param eventType
     */
    public EventArgs(IEventType eventType) {
        this.eventType = eventType;
    }

    /**
     * @param event
     * @return
     */
    public IEventArgs setEvent(IEvent event) {
        if (this.event == null) {
            this.event = event;
        }
        return this;
    }

    /**
     * @return
     */
    public IEvent getEvent() {
        return this.event;
    }

    /**
     * @return
     */
    public IEventType getEventType() {
        return this.eventType;
    }
}
