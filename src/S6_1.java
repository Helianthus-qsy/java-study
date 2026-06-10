import java.util.Scanner;

public class S6_1 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("请输入三角形的三条边：");
            double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double p  =(a+b+c)/2;
        double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        System.out.println("三角形面积为："+s);
        }catch(ArithmeticException e){
            System.out.println("发生异常：" + e.getMessage());
        }
        sc.close();
    }
}
