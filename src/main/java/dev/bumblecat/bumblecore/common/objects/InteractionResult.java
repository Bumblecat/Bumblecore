package dev.bumblecat.bumblecore.common.objects;

//public class InteractionResult<T> extends InteractionResultHolder<T> {
public class InteractionResult<T> {

    private final InteractionResultType result;
    private final T object;

    public InteractionResult(T object, InteractionResultType result) {
        this.object = object;
        this.result = result;
    }


    public T getObject() {
        return this.object;
    }

    public net.minecraft.world.InteractionResult getResult() {
        return this.result.getResult();
    }



    public static <T> InteractionResult<T> success(T object) {
        return new InteractionResult<>(object, InteractionResultType.SUCCESS);
    }

    public static <T> InteractionResult<T> success(T object, boolean sided) {
        return sided ? success(object) : consume(object);
    }

    public static <T> InteractionResult<T> consume(T object) {
        return new InteractionResult<>(object, InteractionResultType.CONSUME);
    }

    public static <T> InteractionResult<T> consume(T object, boolean sided) {
        return success(object, sided);
    }

    public static <T> InteractionResult<T> failure(T object) {
        return new InteractionResult<>(object, InteractionResultType.FAIL);
    }

    public static <T> InteractionResult<T> proceed(T object) {
        return new InteractionResult<>(object, InteractionResultType.PASS);
    }
}
