package dev.bumblecat.bumblecore.common.conveys;

public class InteractionEventArgs extends EventArgs {

    /**
     * @param eventType
     */
    public InteractionEventArgs(IEventType eventType) {
        super(eventType);
    }
}
