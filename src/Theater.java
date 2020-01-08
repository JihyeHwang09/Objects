public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

// 소극장이 관람객을 맞이할 수 있도록 enter 메서드를 구현
    public void enter(Audience audience) {
        // 소극장은 먼저 관람객의 가방 안에 초대장이 들어 있는지 확인한다.
        // 초대장이 들어 있다면, 이벤트에 당첨된 관람객이므로
        if (audience.getBag().hasInvitation()) {
            // 판매원에게서 받은 티켓을 관람객의 가방에 넣어준다.
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
            // 가방 안에 초대장이 없다면, 티켓을 판매해야 한다.
        } else {
            // 소극장은 관람객의 가방에서 티켓 금액만큼을 차감한 후, 매표소에 금액을 증가시킨다.
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            // 소극장은 관람객의 가방 안에 티켓을 넣어줌으로써 관람객의 입장 절차를 끝낸다.
            audience.getBag().setTicket(ticket);
        }
    }
}
