package thread.sync;

import static thread.util.ThreadUtils.sleep;
import static thread.util.logger.MyLogger.log;

public class BankAccountSynchronized implements BankAccount {

    private int balance;
//    private volatile int balance;
    // 동시성 문제와 메모리 가시성 문제는 다름

    public BankAccountSynchronized(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        synchronized (this) {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                log("거래 종료");
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000); // 출금에 걸리는 시간으로 가정
            balance = balance - amount;
            log("[출금 완료] 출금액: " + amount + ", 변경 잔액: " + balance);
        }

        log("거래 종료");
        return true;

    }

    @Override
    public int getBalance() {
        return balance;
    }

}
