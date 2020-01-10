/*
AmountDiscountPolicy는 DiscountPolicy의 자식 클래스로서
할인 조건 만족시, 일정한 금액을 할인해주는 금액 할인 정책을 구현한다.

 */
public class AmountDiscountPolicy extends DiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    // DiscountPolicy의 getDiscountAmount 메서드를 오버라이딩
    // 할인 요금은 인스턴스 변수인 discountAmount에 저장한다.
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
