public class PrintFooBar {

    private final int n;
    private boolean flag;

    public PrintFooBar(int n) {
        this.n = n;
        flag = false;
    }

    public synchronized void printFoo() {
        for (int i = 1; i <= n; ++i) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
            System.out.println("Foo");
            flag = true;
            notify();
        }
    }

    public synchronized void printBar() {
        for (int i = 1; i <= n; ++i) {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // do nothing
                }
            }
            System.out.println("Bar");
            flag = false;
            notify();
        }
    }
}