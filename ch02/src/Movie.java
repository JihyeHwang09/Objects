import java.time.Duration;

public class Movie {
    private String title; // 제목
    private Duration runningTime; // 상영 시간
    private Money fee; // 기본 요금
    private DiscountPolicy discountPolicy; // 할인 정책

    // Movie의 생성자는 오직 하나의 DiscountPolicy 인스턴스만 받을 수 있도록 선언돼 있다.
    /*
    만약, 금액 할인 정책을 적용하고 싶다면, Movie의 인스턴스를 생성할 때 인자로 AmountDiscountPolicy를 전달하면 된다.

     */
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }
    /*
    calculateMovieFee 메서드는 discountPolicy에 caculateDiscountAmount 메시지를 전송해
    할인 요금을 반환 받는다.
    Movie는 기본요금인 fee에서 반환된 할인 요금을 차감한다.
     */
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.caculateDiscountAmount(screening));
    }
}
