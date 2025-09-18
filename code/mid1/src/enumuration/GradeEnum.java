package enumuration;

public enum GradeEnum {
    BASIC(1), GOLD(2), DIAMOND(3);

    private final int score;

    GradeEnum(int score) {
        this.score = score;
    }

//    public abstract void canMakeAbstractMethod();

}
