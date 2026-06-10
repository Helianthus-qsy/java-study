public class S6_2 {
    static void main() {
        double a = 1;
        double b = 2;
        double c = 5;
        try{
            if (a + b <= c ||
                    a + c <= b ||
                    b + c <= a){
                throw new TriangleException("无法构成三角形！");
            }
            System.out.println("可以构成三角形。");
        }catch(TriangleException e){
            System.out.println(e.getMessage());
        }
    }

}
