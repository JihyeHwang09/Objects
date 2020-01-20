import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public boolean isSatisfiedBy(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
                startTime.compareTo(screening.getWhenScreened().toLocalTime())<= 0 &&
                endTime.isAfter(screening.getWhenScreened().toLocalTime()>= 0);
    }
}
