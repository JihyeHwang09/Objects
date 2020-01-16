import java.time.DayOfWeek;
import java.time.LocalTime;


// ReservationAgency로 새어나간 데이터에 대한 책임을 실제 데이터를 포함하고 있는 객체로 옮겨보자.
public class DiscountCondition {
// 1. 이 객체가 어떤 데이터를 포함해야 하는가? -> 어떤 데이터를 관리해야 하는가?
    private DiscountConditionType type;

    private int sequence; // 순번 조건일 경우 이용
    // 기간 조건일 경우 이용
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    // 캡슐화의 원칙에 따라 이 속성들을 클래스 외부로 노출해서는 안 된다.
    // -> 메서드를 추가한다.
    /*
    2. 이 객체가 데이터에 대해 수행해야 하는 오퍼레이션은 무엇인가?
    -> 이 데이터에 대해 수행할 수 있는 오퍼레이션이 무엇인가를 묻는 것이다.
     */
    public DiscountConditionType getType() {
        return type;
    }

    public void setType(DiscountConditionType type) {
        this.type = type;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    /*
    DayOfWeek 타입의 요일 정보와 LocalTime 타입의 시간 정보를 파라미터로 받는다.
    -> 이 메서드는 객체 내부에 DayOfWeek 타입의 요일과 LocalTime 타입의 시간 정보가 인스턴스 변수로
    포함되어 있다는 사실을 인터페이스를 통해 외부에 노출하고 있는 것이다.
     */
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }
        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;
    }

    /*
     isDiscountable(sequence)
     */
    public boolean isDiscountable(sequence) {
        if (type != DiscountConditionType.SEQUENCE) {
            throw new IllegalArgumentException();
        }

        return this.sequence == this.sequence;
    }
}
