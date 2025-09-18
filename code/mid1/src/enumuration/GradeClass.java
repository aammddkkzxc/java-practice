package enumuration;

public class GradeClass {

    public static final GradeClass BASIC = new GradeClass(1);
    public static final GradeClass GOLD = new GradeClass(2);
    public static final GradeClass DIAMOND = new GradeClass(3);

    private final int score;

    private GradeClass(int score) {
        this.score = score;
    }

}
