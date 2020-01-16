package rectangle;

public class AnyClass {
    // 사각형의 너비와 높이를 증가시키는 메서드
    void anyMethod(Rectangle rectangle, int multiple) {
        rectangle.setRight(rectangle.getRight() * multiple);
        rectangle.setBottom(rectangle.getBottom() * multiple);
    }
}
