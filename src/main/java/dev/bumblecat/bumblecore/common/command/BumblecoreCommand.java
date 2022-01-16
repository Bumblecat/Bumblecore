package dev.bumblecat.bumblecore.common.command;

import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

public class BumblecoreCommand {


    private static BumblecoreCommand command;

    /**
     * @param dispatcher
     */
    private BumblecoreCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                LiteralArgumentBuilder.<CommandSourceStack>literal("bumblecore")
                        .then(BumblecoreSupportCommand.register())

                //.then()
                //.then()
                //.then()
                //.then()
        );
    }

    /**
     * @param dispatcher
     */
    public static void construct(CommandDispatcher<CommandSourceStack> dispatcher) {
        command = new BumblecoreCommand(dispatcher);
    }
}
