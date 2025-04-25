package nested.inner;

public class InnerOuter {

    private static int outClassFeild = 1;
    private int outInstanceFeild = 2;

    public class Inner {
        private int innerInstanceFeild = 3;

        public void print() {
            System.out.println(innerInstanceFeild);
            System.out.println(outInstanceFeild);
            System.out.println(outClassFeild);
        }
    }

}
