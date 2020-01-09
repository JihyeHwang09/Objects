/*
Bag을 자율적인 존재로 바꿔보자.
Bag의 내부 상태에 접근하는 모든 로직을 Bag 안으로 캡슐화해서 결합도를 낮추면 된다.
-> Bag에 hold 메서드를 추가
-> Bag은 관련된 상태와 행위를 함께 가지는 응집도 높은 클래스가 되었다.
 */
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
    public Long hold(Ticket ticket) {
       if(hasInvitation()) {
           setTicket(ticket);
           return 0L;
       } else {
           setTicket(ticket);
           minusAmount(ticket.getFee());
           return ticket.getFee();
       }
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }
}
