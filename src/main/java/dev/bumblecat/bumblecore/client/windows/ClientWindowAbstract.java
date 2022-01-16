package dev.bumblecat.bumblecore.client.windows;

import dev.bumblecat.bumblecore.client.windows.events.*;
import dev.bumblecat.bumblecore.client.windows.widgets.IWidget;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import java.awt.*;
import java.util.ArrayList;

abstract class ClientWindowAbstract<T extends AbstractContainerMenu> extends AbstractContainerScreen<T> {

    private final ResourceLocation texture_default = new ResourceLocation("bumblecore", "textures/menu/default.png");
    private final ResourceLocation texture_generic = new ResourceLocation("bumblecore", "textures/menu/generic.png");
    private final ResourceLocation texture_machine = new ResourceLocation("bumblecore", "textures/menu/machine.png");

    private final ArrayList<IWidget> widgets = new ArrayList<>();

    private final Dimension minSize = new Dimension(176, 100);
    private final Dimension maxSize = new Dimension(256, 256);
    private final Dimension invSize = new Dimension(176, 100);

    private int labelColor = 0xC7C7C7;
    private final int labelColorInventory = 0x404040;

    /**
     * @param container
     * @param inventory
     * @param component
     */
    public ClientWindowAbstract(T container, Inventory inventory, Component component) {
        super(container, inventory, component);
        ((IClientWindow) this).onWindowCreated();
    }

    /**
     *
     */
    @Override
    protected final void init() {
        super.init();
        this.widgets.clear();
        ((IClientWindow) this).onWindowLoading();
    }

    /**
     * @param widget
     * @param <T>
     *
     * @return
     */
    public <T> T attach(IWidget widget) {
        widgets.add(widget);
        return (T) widget;
    }

    /**
     * @param widget
     * @param <T>
     *
     * @return
     */
    public <T> T detach(IWidget widget) {
        return null;
    }


    /**
     * @return
     */
    public ArrayList<IWidget> getWidgets() {
        return widgets;
    }

    /**
     * @return
     */
    public ArrayList<IWidget> getVisibleWidgets() {
        ArrayList<IWidget> results = new ArrayList<>();

        for (IWidget widget : widgets) {
            if (widget.getVisible()) {
                results.add(widget);
            }
        }

        return results;
    }

    /**
     * @param matrix
     * @param mouseX
     * @param mouseY
     * @param ticker
     */
    @Override
    public final void render(PoseStack matrix, int mouseX, int mouseY, float ticker) {
        renderBackground(matrix);
        super.render(matrix, mouseX, mouseY, ticker);
        renderTooltip(matrix, mouseX, mouseY);
    }

    /**
     * @param stack
     * @param posX
     * @param posY
     */
    @Override
    public final void renderLabels(PoseStack stack, int posX, int posY) {
        this.font.draw(stack, this.getTitle(),
                titleLabelX, titleLabelY,
                getLabelColor()
        );

        //if (this.getPlayerInventoryVisible())
        this.font.draw(stack, this.playerInventoryTitle,
                inventoryLabelX, (int) (getSize().getHeight() - getInventoryRectangle().getHeight()) + 7,
                labelColorInventory
        );
    }

    /**
     * @param matrix
     * @param ticker
     * @param mouseX
     * @param mouseY
     */
    @Override
    protected final void renderBg(PoseStack matrix, float ticker, int mouseX, int mouseY) {

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        RenderSystem.setShaderTexture(0, ((IClientWindow) this).getWindowType() == WindowType.Machine ? texture_machine : texture_generic);
        ((IClientWindow) this).onWindowRendering(
                new WindowEvent((IClientWindow) this, new RenderEventArgs(matrix))
        );


        //if (getPlayerInventoryVisible()) {
        RenderSystem.setShaderTexture(0, texture_default);
        this.blit(matrix,
                (int) (getLocation().getX() + getInventoryRectangle().getX()),
                (int) (getLocation().getY() + getInventoryRectangle().getY()),
                0, 0, (int) getInventoryRectangle().getWidth(), (int) getInventoryRectangle().getHeight()
        );
        //}


        for (IWidget widget : getVisibleWidgets()) {
            if (widget.getTexture() == null) {
                RenderSystem.setShaderTexture(0, ((IClientWindow) this).getWindowType() == WindowType.Machine ? texture_machine : texture_generic);
            } else {
                RenderSystem.setShaderTexture(0, widget.getTexture());
            }
            ((IClientWindow) this).onWidgetRendering(
                    new WidgetEvent(widget, new RenderEventArgs(matrix))
            );
        }
    }

    /**
     * @param mouseX
     * @param mouseY
     * @param button
     *
     * @return
     */
    @Override
    public final boolean mouseClicked(double mouseX, double mouseY, int button) {
        for (IWidget widget : getVisibleWidgets())
            widget.doValidateEvent(new WidgetEvent(widget,
                    new MouseEventArgs(MouseEventType.MousePressed, new Point((int) mouseX, (int) mouseY), button)));

        doValidateEvent(new WindowEvent((IClientWindow) this,
                new MouseEventArgs(MouseEventType.MousePressed, new Point((int) mouseX, (int) mouseY), button)));


        return super.mouseClicked(mouseX, mouseY, button);
    }

    /**
     * @param mouseX
     * @param mouseY
     * @param button
     *
     * @return
     */
    @Override
    public final boolean mouseReleased(double mouseX, double mouseY, int button) {
        for (IWidget widget : getVisibleWidgets())
            widget.doValidateEvent(new WidgetEvent(widget,
                    new MouseEventArgs(MouseEventType.MouseRelease, new Point((int) mouseX, (int) mouseY), button)));

        doValidateEvent(new WindowEvent((IClientWindow) this,
                new MouseEventArgs(MouseEventType.MouseRelease, new Point((int) mouseX, (int) mouseY), button)));

        return super.mouseReleased(mouseX, mouseY, button);
    }

    /**
     * @param mouseX
     * @param mouseY
     */
    @Override
    public final void mouseMoved(double mouseX, double mouseY) {
        for (IWidget widget : getVisibleWidgets())
            widget.doValidateEvent(new WidgetEvent(widget,
                    new MouseEventArgs(MouseEventType.MouseMoving, new Point((int) mouseX, (int) mouseY))));

        doValidateEvent(new WindowEvent((IClientWindow) this,
                new MouseEventArgs(MouseEventType.MouseMoving, new Point((int) mouseX, (int) mouseY))));

        super.mouseMoved(mouseX, mouseY);
    }


    private void doValidateEvent(WindowEvent event) {
//@todo.
    }


    /**
     * @return
     */
    public int getLabelColor() {
        return this.labelColor;
    }

    /**
     * @param value
     */
    public void setLabelColor(int value) {
        this.labelColor = value;
    }


    /**
     * @return
     */
    public Point getLocation() {
        return new Point(
                (int) (getScreenSize().getWidth() - getSize().getWidth()) / 2,
                (int) (getScreenSize().getHeight() - getSize().getHeight()) / 2
        );
    }

    /**
     * @return
     */
    public Dimension getScreenSize() {
        return new Dimension(this.width, this.height);
    }

    /**
     * @return
     */
    public Dimension getSize() {
        return new Dimension(this.imageWidth, this.imageHeight);
    }

    /**
     * @param dimension
     */
    public void setSize(Dimension dimension) {
        setSize(dimension.width, dimension.height);
    }

    /**
     * @param w
     * @param h
     */
    public void setSize(int w, int h) {
        this.imageWidth = (int) (w > minSize.getWidth() ? Math.min(w, maxSize.getWidth()) : minSize.getWidth());
        this.imageHeight = (int) (h > minSize.getHeight() ? Math.min(h, maxSize.getHeight()) : minSize.getHeight());
    }

    /**
     * @return
     */
    protected Rectangle getInventoryRectangle() {
        return new Rectangle(new Point(0, (int) (getSize().getHeight() - invSize.getHeight())), invSize);
    }
}
