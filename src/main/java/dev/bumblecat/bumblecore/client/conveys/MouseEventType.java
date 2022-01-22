package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.common.conveys.IEventType;

public enum MouseEventType implements IEventType {
    MousePressed,
    MouseRelease,
    MouseDragged,
    MouseScroll,
    MouseMoving,
}
