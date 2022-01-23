package dev.bumblecat.bumblecore.common.conveys;

public interface IEvent {

    /**
     * @return
     */
    boolean getCanceled();

    /**
     * @return
     */
    <T extends IEvent> T setCanceled();

    /**
     * @param value
     * @return
     */
    <T extends IEvent> T setCanceled(boolean value);

    /**
     * @return
     */
    IEventArgs getArguments();
}
