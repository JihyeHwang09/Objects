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
// 이 방식의 문제점: 할인 정책이 없는 경우를 예외 케이스로 취급하기 때문에 지금까지 일관성 있던 협력 방식이 무너지게 된다.
//   -> 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분의 경우 좋지 않은 선택이다.
//        if (discountPolicy == null) {
//            return fee;
//        }

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
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
