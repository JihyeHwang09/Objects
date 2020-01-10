import java.time.DayOfWeek;
import java.time.LocalTime;

// PeriodCondition은 상영 시작 시간이 특정 기간에 포함되는지 여부를 판단해, 할인 여부를 결정한다.

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek; // 조건에 사용할 요일
    private LocalTime startTime; // 시작 시간
    private LocalTime endTime; // 종료 시간

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

/*
 isSatisFied 메서드는 인자로 전달된 Screening의 상영 요일이 dayOfWeek와 같고
 상영 시작 시간이 startTime과 endTime 사이에 있을 경우 true를 반환하고,
 그렇지 않은 경우에는 false를 반환한다.
 */
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
                startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
                endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
}
