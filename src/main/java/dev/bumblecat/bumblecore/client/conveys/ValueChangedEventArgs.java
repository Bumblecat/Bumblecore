package dev.bumblecat.bumblecore.client.conveys;

import dev.bumblecat.bumblecore.common.conveys.IEventType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ValueChangedEventArgs<T> extends WidgetEventArgs<ValueChangedEventArgs> {

    private final T oldValue;
    private final T newValue;

    /**
     *
     */
    public ValueChangedEventArgs() {
        this(null, null);
    }

    public ValueChangedEventArgs(@Nullable T oldValue, @Nullable T newValue) {
        this(WidgetEventType.ValueChanged, oldValue, newValue);
    }

    public ValueChangedEventArgs(@NotNull IEventType eventType, @Nullable T oldValue, @Nullable T newValue) {
        super(eventType);

        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * @return
     */
    public T getOldValue() {
        return this.oldValue;
    }

    /**
     * @return
     */
    public T getNewValue() {
        return this.newValue;
    }
}
