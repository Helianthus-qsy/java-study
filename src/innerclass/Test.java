package innerclass;

public class Test {
    public static void main(String[] args) {
        Inner.outer oio= new Inner().new outer();
        oio.show();
    }
}
