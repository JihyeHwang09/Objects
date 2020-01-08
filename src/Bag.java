public class Bag {
    private Long amount; // 현금
    private Invitation invitation;
    private Ticket ticket;

    /*
    이벤트에 당첨된 관람객의 가방 안- 현금 O, 초대장 O
    이벤트에 당첨 X - 현금 O, 초대장 X
    -> Bag의 인스턴스를 생성하는 시점에 이 제약을 강제할 수 있도록
    생성자를 추가
     */
    public Bag(long amount) {
        this(null, amount);
    }

    public Bag(Invitation invitation, long amount) {
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
