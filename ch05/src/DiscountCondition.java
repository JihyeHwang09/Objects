import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    private DiscountConditionType type;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        /*
        새로운 할인 조건 추가
        if ~ else 구문을 수정해야 한다.
        새로운 할인 조건이 새로운 데이터를 요구한다면,
        DiscountCondition에 속성을 추가하는 작업도 필요하다.
         */
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedPeriod(screening);
        }

        return isSatisfiedBySequence(screening);
    }

    /*
    기간 조건을 판단하는 로직이 변경되는 경우
    isSatisfiedPeriod 메서드의 내부 구현을 수정해야 한다.
     물론, 기간 조건을 판단하는 데 필요한 데이터가 변경된다면
    DiscountCondition의 dayOfWeek, startTime, endTime 속성 역시 변경해야 할 것이다.
     */
    private boolean isSatisfiedPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime())<= 0 &&
                endTime.isAfter(screening.getWhenScreened().toLocalTime()>= 0);
    }

    /*
    순번 조건을 판단하는 로직 변경
    isSatisfiedBySequence 메서드의 내부 구현을 수정해야 한다.
    물론, 순번 조건을 판단하는 데 필요한 데이터가 변경된다면
    DiscountCondition의 sequence 속성 역시 변경해야 할 것이다.
     */
    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }
}
