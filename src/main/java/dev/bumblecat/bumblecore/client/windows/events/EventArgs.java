package dev.bumblecat.bumblecore.client.windows.events;

abstract class EventArgs<T> {

    private Event owner;

    public EventArgs() {
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
}
