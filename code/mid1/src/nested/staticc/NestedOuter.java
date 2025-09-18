package nested.staticc;

public class NestedOuter {

    private static int outClassFeild = 1;
    private int outInstanceFeild = 2;

    public static class Nested {
        private int nestedInstanceFeild = 3;

        public void method() {
            System.out.println(nestedInstanceFeild);

            //바깥 클래스 인스턴스 멤버 접근 불가
            //System.out.println(outInstanceFeild);

            //바깥 클래스 클래스 멤버 접근 가능 (private이어도)
            System.out.println(outClassFeild);
        }
    }

}
