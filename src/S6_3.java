class TriangleException extends Exception {
    public TriangleException(String message) {
        super(message);
    }
}
class Triangle {
    private double a;
    private double b;
    private double c;
    public Triangle(double a, double b, double c)
            throws TriangleException {
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleException("三条边无法组成三角形！");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void show() {
        System.out.println("成功创建三角形：" + a + "," + b + "," + c);
    }
}

public class S6_3 {
    public static void main(String[] args) {
        try {
            Triangle t = new Triangle(3, 4, 5);
            t.show();
        } catch (TriangleException e) {
            System.out.println(
                    e.getMessage());
        }
    }
}
