package dev.bumblecat.bumblecore.common.objects;

import dev.bumblecat.bumblecore.common.conveys.IEventType;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

public class ObjectEventItemArgs extends ObjectEventArgs {

    public ObjectEventItemArgs(IEventType eventType) {
        super(eventType);
    }

    public ObjectEventItemArgs(IEventType eventType, Level level, Entity entity) {
        super(eventType, level, entity);
    }

    public ObjectEventItemArgs(IEventType eventType, Level level, Entity entity, InteractionHand hand) {
        super(eventType, level, entity, hand);
    }
}
