public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    /*
     수정된 Theater 클래스 어디에서도 ticketOffice에 접근하지 않는다.
     Theater는 ticketOffice가 TicketSeller 내부에 존재한다는 사실을 알지 못한다.
     단지, ticketSeller가 sellTo 메시지를 이해하고 응답할 수 있다는 사실만 알고 있을 뿐!

     Theater는 오직 ticketSeller의 인터페이스(interface)에만 의존한다.
     ticketSeller 내부에 ticketOffice 인스턴스를 포함하고 있따는 사실은 구현의 영역에 속한다.
     객체를 인터페이스와 구현으로 나누고 인터페이스만을 공개하는 것
        - 객체 사이의 결합도를 낮추고, 변경하기 쉬운 코드를 작성하기 위해 따라야 하는
        가장 기본적인 설계 원칙
     */
    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
