package dev.bumblecat.bumblecore.client.conveys;

import com.mojang.blaze3d.vertex.PoseStack;

import java.awt.*;

public class RenderEventArgs extends WindowEventArgs<RenderEventArgs> {

    private final PoseStack matrix;

    private Point mouse;

    public RenderEventArgs(PoseStack matrix) {
        super(RenderEventType.Default);
        this.matrix = matrix;
    }


    public PoseStack getMatrix() {
        return this.matrix;
    }
}
