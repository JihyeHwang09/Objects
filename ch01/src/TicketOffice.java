import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
//매표소에는 관람객에게 판매할 티켓, 판매 금액이 보관되어 있어야 한다.
    //판매하거나 교환해 줄 티켓의 목록(tickets)과 판매 금액(amount)를 인스턴스 변수로 포함한다.
    private Long amount;
    //티켓을 판매하는 getTicket 메서드는 편의를 위해 tickets 컬렉션에서 맨 첫 번째 위치에 저장된 Ticket을 반환하는 것으로 구현
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    //  TicketOffice가 Audience에게 직접 티켓을 판매하기 때문에
    //  TicketOffice가 Audience에 관해 알고 있어야 한다.
    // (변경 전에는 존재하지 않았던 새로운 의존성이 추가된 것)
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
