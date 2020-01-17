import java.time.Duration;

/*
Screening은  Movie와 협력하기 위해 calculateMovieFee 메시지를 전송한다.
Movie는 이 메시지에 응답하기 위해 calculateMovieFee 메서드를 구현해야 한다.
 */
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
// 현재의 Movie가 어떤 할인 정책이 적용된 영화인지를 나타내기 위한 인스턴스 변수
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money calculateMovieFee(Screening screening) {
    /*
     Movie는 먼저
     */
    }
}
