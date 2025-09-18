package poly;

public abstract class PayStore {

    public static Pay findPay(String option) {
        if (option.equals("kakao")) {
            return new KakaoPay();
        }

        if (option.equals("naver")) {
            return new NaverPay();
        }

        return new DefaultPay();
    }

}
