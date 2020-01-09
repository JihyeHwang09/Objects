/*
    판매원은 매표소에서 초대장을 티켓으로 교환 or 티켓 판매
    판매원을 구현한 TicketSeller 클래스는 자신이 일하는 매표소(ticketOffice)을 알고 있어야 한다.
 */
public class TicketSeller {
    /*
     TicketSeller에서 getTicketOffic 메서드가 제거됨
     -> ticketOffice의 가시성이 private이고, 접근 가능한 퍼블릭 메서드가 존재하지 않는다.
     -> 외부에서는 ticketOffice에 직접 접근할 수 X!
     -> TicketSeller는 ticketOffice에서 티켓을 꺼내거나 판매 요금을 적립하는 일을  스스로 수행할 수 밖에 없다!

     - 캡슐화: 개념적으로나 물리적으로 객체 내부의 세부적인 사항을 감추는 것
     */
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }
    /*
    TicketSeller는 TicketOffice의 sellTicketTo 메서드를 호출함으로써
    원하는 목적을 달성할 수 있다.
    -> TicketSeller가 TicketOffice의 구현이 아닌, 인터페이스에만 의존하게 되었다는 점이다!
     */
    public void sellTo(Audience audience) {
        ticketOffice.sellTicketTo(audience);
    }
}
