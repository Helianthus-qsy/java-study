package xiancheng;

class TicketWindow implements Runnable {
    private int ticket = 1;
    private final int MAX = 138;

    @Override
    public void run() {
        while (true) {
            sellTicket();
        }
    }

    public synchronized void sellTicket(){
        if(ticket <= MAX){
            System.out.println(Thread.currentThread().getName()+"售出了第"+ticket+"张票");
            ticket++;
            try{
                Thread.sleep(20);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        else{
            System.exit(0);
        }
        }

}

public class S8_1 {
    public static void main(String[] args) {
        TicketWindow tw = new TicketWindow();

        Thread t1 = new Thread(tw, "窗口1");
        Thread t2 = new Thread(tw, "窗口2");
        Thread t3 = new Thread(tw, "窗口3");
        Thread t4 = new Thread(tw, "窗口4");
        Thread t5 = new Thread(tw, "窗口5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
