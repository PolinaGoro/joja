public class Main {
    public final static Integer obj = 1;
    public final static Integer obj2 = 2;

    public static void main(String[] args) {
        MyThreadOne a1 = new MyThreadOne();
        MyThreadTwo a2 = new MyThreadTwo();
        a2.start();
        a1.start();
    }

    public static class MyThreadOne extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                try {
                    sleep(1000);
                    System.out.println("MyThreadOne value: " + obj);
                    obj.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static class MyThreadTwo extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                try {
                    obj.wait();
                    System.out.println("MyThreadTwo value: " + obj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}