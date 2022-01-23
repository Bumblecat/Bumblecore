package dev.bumblecat.bumblecore.common.objects;

import dev.bumblecat.bumblecore.common.conveys.EventArgs;
import dev.bumblecat.bumblecore.common.conveys.IEventType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ObjectEventArgs extends EventArgs {

    private final Level level;
    private final Entity entity;
    private final InteractionHand hand;

    public ObjectEventArgs(IEventType eventType) {
        this(eventType, null, null);
    }

    public ObjectEventArgs(IEventType eventType, Level level, Entity entity) {
        this(eventType, level, entity, null);
    }

    public ObjectEventArgs(IEventType eventType, Level level, Entity entity, InteractionHand hand) {
        super(eventType);

        this.level = level;
        this.entity = entity;
        this.hand = hand;
    }






    public Level getEventLevel() {
        return this.level;
    }

    public Entity getEventEntity() {
        return this.entity;
    }

    public Player getEventPlayer() {
        return this.getEventEntity() instanceof Player ? (Player) this.getEventEntity() : null;
    }

    public InteractionHand getEventHand() {
        return this.hand == null ? this.getEventPlayer() != null ? this.getEventPlayer().getUsedItemHand() : null : this.hand;
    }
}
