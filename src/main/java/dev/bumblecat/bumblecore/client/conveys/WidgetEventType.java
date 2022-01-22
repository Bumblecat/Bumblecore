package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.common.conveys.IEventType;

public enum WidgetEventType implements IEventType {
    Rendering,
    VisibilityChanged,
    ValueChanged,
}
