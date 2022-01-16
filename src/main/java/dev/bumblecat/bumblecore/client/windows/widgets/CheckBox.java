package dev.bumblecat.bumblecore.client.windows.widgets;

import dev.bumblecat.bumblecore.client.windows.IClientWindow;

import java.awt.*;

public class CheckBox extends Widget<CheckBox> implements IWidget {

    private boolean checked;

    /**
     * @param window
     * @param destination
     */
    public CheckBox(IClientWindow window, Rectangle destination) {
        super(window, destination);
    }

    /**
     * @return
     */
    public boolean getValue() {
        return this.checked;
    }

    /**
     * @param value
     *
     * @return
     */
    public void setValue(boolean value) {
        this.checked = value;
    }
}
