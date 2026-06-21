package xiancheng;

class Race {
    public static volatile boolean flag = false;
    public static long startTime;
}

class Rabbit extends Thread {
    private int distance = 0;
    private double restTime;

    public Rabbit(double restTime) {
        this.restTime = restTime;
        setName("兔子");
    }

    @Override
    public void run() {
        while (!Race.flag && distance < 50) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distance += 5;
            double time = (System.currentTimeMillis() - Race.startTime) / 1000.0;
            System.out.printf("%s跑了%d米，当前时间：%.1f秒%n", getName(), distance, time);

            if (distance == 40) {
                System.out.println("兔子开始休息...");
                try {
                    Thread.sleep((long) (restTime * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!Race.flag && distance >= 50) {
            Race.flag = true;
            double time = (System.currentTimeMillis() - Race.startTime) / 1000.0;
            System.out.printf("%s先到达终点！用时：%.1f秒%n", getName(), time);
        }
    }
}

class Turtle extends Thread {
    private int distance = 0;

    public Turtle() {
        setName("乌龟");
    }

    @Override
    public void run() {
        while (!Race.flag && distance < 50) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            distance += 3;
            double time = (System.currentTimeMillis() - Race.startTime) / 1000.0;
            System.out.printf("%s跑了%d米，当前时间：%.1f秒%n", getName(), distance, time);
        }

        if (!Race.flag && distance >= 50) {
            Race.flag = true;
            double time = (System.currentTimeMillis() - Race.startTime) / 1000.0;
            System.out.printf("%s先到达终点！用时：%.1f秒%n", getName(), time);
        }
    }
}

public class S8_2 {
    public static void main(String[] args) {
        Race.startTime = System.currentTimeMillis();

        Rabbit rabbit = new Rabbit(10.0);
        Turtle turtle = new Turtle();

        rabbit.start();
        turtle.start();
    }
}
