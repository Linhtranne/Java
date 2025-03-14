package Ex6;

public class TestMoveablePoint {
    public static void main(String[] args) {
        Point point = new Point(1.0, 2.0);
        System.out.println("Point: " + point);

        MoveablePoint moveablePoint = new MoveablePoint(3.0, 4.0, 0.5, 0.5);
        System.out.println("MoveablePoint Trước khi chuyển : " + moveablePoint);
        moveablePoint.move();
        System.out.println("MoveablePoint sau khi chuyển: " + moveablePoint);

        moveablePoint.setXSpeed(1.0);
        moveablePoint.setYSpeed(1.0);
        moveablePoint.move();
        System.out.println("MoveablePoint sau khi chỉnh và di chuyển: " + moveablePoint);
    }
}
