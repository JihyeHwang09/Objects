public class ReservationAgency {
    public Reservation reserve (Screening screening, Customer customer, int audienceCount) {
        Movie movie = screening.getMovie();
        Money fee = screening.calculateFee(audienceCount);

        boolean discountable = false;
        for (DiscountCondition : movie.getDiscountConditions()) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                discountable = screening.getWhenScreend().getDayOfWeek().equals(condition.getDayOfWeek())&&
                        condition.getStartTime().compareTo(screening.getWhenScreend().toLocalTime()) <= 0 &&
                        condition.getEndTime().compareTo(screening.getWhenScreend().toLocalTime()) >= 0;
            } else {
                discountable = condition.getSequence == screening.getSequence();
            }
            if (discountable) {
                break;
            }
        }
        Money fee;
        if (discountable) {
            Money discountableAmount = Money.ZERO;
            switch (movie.getMovieType()) {
                case AMOUNT_DISCOUNT:
                    discountableAmount = movie.getDiscountAmount();
                    break;
                case PERCENT_DISCOUNT:
                    discountableAmount = movie.getFee().times(movie.getDiscountPercent());
                    break;
                case NONE_DISCOUNT:
                    discountableAmount = movie.getFee().minus(discountableAmount).times(audienceCount);
            }
            fee = movie.getFee().minus(discountableAmount).times(audienceCount);
        } else {
            fee = movie.getFee();
        }
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
