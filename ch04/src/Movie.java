import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class Movie {
    private String title; // 영화 제목
    private Duration runningTime; // 상영 시간
    private Money fee;

    // 할인 조건의 목록(discountConditions)가 인스턴스 변수로 Movie안에 직접 포함되어 있다.
    private List<DiscountCondition> discountConditions;
    /*
     movieType은 현재 영화에 설정된 할인 정책의 종류를 결정하는 열거형 타입인 movieType의 인스턴스
     movieType의 값이 AMOUNT_DISCOUNT라면, discountAmount에 저장된 값을
     PERCENT_DISCOUNT라면 discountPercent에 저장된 값을 사용한다.
     NONE_DISCOUNT인 경우에는 할인 정책을 적용하지 말아야 하기 때문에
     discountAmount와 discountPercent 중 어떤 값도 사용하지 않는다!
     */

    private MovieType movieType;

    /*
    할인 정책을 DiscountPolicy라는 별도의 클래스로 분리했던 이전 예제와 달리
    금액 할인 정책에 사용되는 할인 금액(discountAmount)과
    비율 할인 정책에 사용되는 할인 비율(discountPercent)을 Movie 안에서 직접 정의하고 있다.
    */
    private Money discountAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }
    // 캡슐화
    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }
    public List<DiscountCondition> getDiscountConditions() {
        return Collections.unmodifiableList(discountConditions);
    }

    public void setDiscountConditions(List<DiscountCondition> discountCondition) {
        this.discountConditions = discountConditions;
}

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }
        return fee.minus(discountPercent);
    }

    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }
    return fee;
    }

    // isDiscountable 메서드는 discountConditions에 포함된 DiscountCondition을 하나씩 훑어 가면서
    // 할인 조건의 타입을 체크한다.
    // 기간 조건: DiscountCondition의 isDiscountable()를 호출
    // 순번 조건: isDiscountable(int s  equence)를 호출
    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }
        return false;
    }
}

