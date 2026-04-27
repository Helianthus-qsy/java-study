package innerclass;
public class Inner {
    private int a = 30;
    class outer{
        private int a = 20;
        public void show(){
            int a = 10;
            System.out.println(a);
            System.out.println(this.a);
            System.out.println(Inner.this.a);
        }
    }
}
