package dev.bumblecat.bumblecore.client.windows.events;

import java.awt.*;

public class MouseEventArgs extends EventArgs<MouseEventArgs> {

    private final Point mouse;
    private final int button;

    public MouseEventArgs(MouseEventType eventType) {
        this(eventType, null);
    }

    public MouseEventArgs(MouseEventType eventType, Point position) {
        this(eventType, position, -1);
    }

    public MouseEventArgs(MouseEventType eventType, Point position, int button) {
        super(eventType);
        this.mouse = position;
        this.button = button;
    }


    /**
     * @return
     */
    public Point getMousePointOnScreen() {
        return this.mouse;
    }

    /**
     * @return
     */
    public Point getMousePointOnWindow() {
        return new Point(
                (int) (getMousePointOnScreen().getX() - this.getOwner().getWindow().getLocation().getX()),
                (int) (getMousePointOnScreen().getY() - this.getOwner().getWindow().getLocation().getY())
        );
    }
}
