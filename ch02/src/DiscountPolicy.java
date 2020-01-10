import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    // DiscountPolicy의 생성자는 여러 개의 DiscountCondition 인스턴스를 허용한다.
    /*
    이처럼 생성자의 파라미터 목록을 이용해 초기화에 필요한 정보를 전달하도록 강제하면,
    올바른 상태를 가진 객체의 생성을 보장할 수 있다.
     */
    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money caculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            // isSatiesfiedBy 메서드는 인자로 전달된 screening이 할인 조건을 만족할 경우 true,
            // 만족시키지 못할 경우 false를 반환한다.
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }
        // 만족하는 할인 조건이 하나도 존재하지 않는다면, 할인 요금을 0원으로 반환한다.
        return Money.ZERO;
    }
    abstract protected Money getDiscountAmount(Screening screening);
}

