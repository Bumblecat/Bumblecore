package dev.bumblecat.bumblecore.common.conveys;

public interface IEvent {

    /**
     * @return
     */
    boolean getCanceled();

    /**
     * @return
     */
    IEvent setCanceled();

    /**
     * @param value
     * @return
     */
    IEvent setCanceled(boolean value);

    /**
     * @return
     */
    IEventArgs getArguments();
}
