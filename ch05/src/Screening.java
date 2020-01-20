import java.time.LocalDateTime;

public class Screening {
//   Screening은 상영 시간과 상영 순번을 인스턴스 변수로 포함한다.
//    Movie에 가격을 계산하라 메시지를 전송해야 하기 때문에 영화(movie)에 대한 참조도 포함해야 한다.
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {

    }
    /*
     영화를 예매하기 위해서는 movie에게 '가격을 계산하라' 메시지를 전송해서
     계산된 영화 요금을 반환받아야 한다.
     calculateFee 메서드는 이렇게 반환된 요금에 예매 인원수를 곱해서
     전체 예매 요금을 계산 -sh> Reservation을 생성해서 반환한다.
     */
    private Money calculateFee() {
        /*
         Movie에 전송하는 메시지의 시그니처를 calculateMovieFee(Screening screening)으로 선언했다는 사실에 주목하라!
         중요한 것: screening이 Movie의 내부 구현에 대한 어떤 지시도 없이 전송할 메시지를 결정했다는 것!

         */
//        Screening은  Movie와 협력하기 위해 calculateMovieFee 메시지를 전송한다.
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }
}
