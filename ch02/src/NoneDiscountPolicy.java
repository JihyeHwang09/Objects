public class NoneDiscountPolicy implements DiscountPolicy {

    // getDiscountAmount 메서드가 어떤 값을 반환하더라도 상관 없다.
    // 부모 클래스인 DiscountPolicy에서 할인 조건이 없을 경우, getDiscountAmount()를 호출하지 않기 때문
    // -> 해결 방법: DiscountPolicy를 인터페이스로 바꾸고 NoneDiscountPolicy가 DiscountPolicy의
    // getDiscountAmount가 아닌 calculateDiscountAmount() 오퍼레이션을 오버라이딩하도록 변경한다.

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
