package dev.bumblecat.bumblecore.common.objects.cubes;

public class CustomCube extends CustomCubeAbstract {

    /**
     *
     */
    public CustomCube() {
        this(new Behaviour());
    }

    /**
     * @param behaviour
     */
    public CustomCube(Behaviour behaviour) {
        super(behaviour);
    }
}
