package rectangle;

// 사각형의 좌표들을 포함하고, 각 속성에 대한 접근자와 수정자 메서드를 제공한다.
public class Rectangle {
    // 내부에 너비와 높이를 조절하는 로직을 캡슐화함
    // -> Rectangle을 변경하는 주체를 외부의 객체에서 Rectangle로 이동시킴
    // (책임을 이동시킴)
    public void enlarge(int multiple) {
        right += multiple;
        bottom += multiple;
    }

    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
