package dev.bumblecat.bumblecore.common;

public class Namespace {

    /**
     * @return
     */
    public static String getDomain() {
        return Functions.Shortcuts.getContainer() == null ? "minecraft" :
                Functions.Shortcuts.getContainer().getNamespace();
    }
}
