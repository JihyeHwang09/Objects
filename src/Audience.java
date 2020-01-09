public class Audience {
// 관람객은 소지품을 보관하기 위해 가방을 소지할 수 있다.
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

// bag에 접근하는 코드를 bag을 포함하는 Audience로 이동
// buy 메서드는 인자로 전달된 Ticket을 Bag에 넣은 후, 지불된 금액을 반환한다.
/*
 Audience는 자신의 가방 안에 초대장이 들어있는지를 스스로 확인한다.
 Audience가 Bag을 직접 처리한다.
 -> 외부에서는 더 이상 Audience가 Bag을 소유하고 있다는 사실을 알 필요가 없다!
 -> 이제, Audience 크래스에서 getBag 메서드를 제거할 수 있고,
    결과적으로 Bag의 존재를 내부로 캡슐화할 수 있게 됐다.
 */
/*
    Audience를 Bag의 구현이 아닌 인터페이스에만 의존하도록 수정하자.
 */
    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
}
