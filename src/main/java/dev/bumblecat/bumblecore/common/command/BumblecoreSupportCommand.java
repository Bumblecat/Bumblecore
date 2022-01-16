package dev.bumblecat.bumblecore.common.command;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.TranslatableComponent;

import com.mojang.brigadier.builder.ArgumentBuilder;

public class BumblecoreSupportCommand {

    /**
     * @return
     */
    public static ArgumentBuilder<CommandSourceStack, ?> register() {

        return Commands.literal("support")
                .requires(source -> source.hasPermission(2))
                .executes(context -> run(context.getSource()));
    }

    /**
     * @param source
     *
     * @return
     */
    public static int run(CommandSourceStack source) {
        source.sendSuccess(new TranslatableComponent("bumblecore.support", "https://bumblecat.dev/support"), true);
        return 1;
    }
}
