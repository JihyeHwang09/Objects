import java.time.LocalDateTime;

/*
사용자들이 예매하는 대상인 '상영'을 구현
상영할 영화, 순번, 상영 시작 시간을 인스턴스 변수로 포함

주목할 점: 인스턴스 변수의 가시성은 private, 메서드의 가시성은 public이라는 점
 */
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreend;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreend) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreend = whenScreend;
    }

    public LocalDateTime getStartTime() {
        return whenScreend;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}
