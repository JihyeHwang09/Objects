/*
    판매원은 매표소에서 초대장을 티켓으로 교환 or 티켓 판매
    판매원을 구현한 TicketSeller 클래스는 자신이 일하는 매표소(ticketOffice)을 알고 있어야 한다.
 */
public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice() {
        return ticketOffice;
    }
}
