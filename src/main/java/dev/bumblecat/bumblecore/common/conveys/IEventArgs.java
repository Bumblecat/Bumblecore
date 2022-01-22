package dev.bumblecat.bumblecore.common.conveys;

public interface IEventArgs {

    IEvent getEvent();

    IEventArgs setEvent(IEvent event);

    IEventType getEventType();
}
