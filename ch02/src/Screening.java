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

    public Reservation reserve(Customer customer, int audienceCount) {
        // calculateFee라는 private 메서드를 호출해서 요금을 계산한 후, 그 결과를 Reservation의 생성자에 전달한다.
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        /*
         다시 Movie의 caculateMovieFee 메서드를 호출한다.(메시지를 전송한다.)
         Movie의 caculateMovieFee 메서드의 반환 값은 1인당 예매 요금
         -> Screening은 전체 예매 요금을 구하기 위해 caculateMovieFee 메서드의 반환값에
            인원수인 audienceCount를 곱한다.
         */
        return Movie.calculateMovieFee(this).times(audienceCount);
    }
}
