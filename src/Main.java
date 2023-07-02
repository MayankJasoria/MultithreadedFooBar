import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of iterations");
        int n = sc.nextInt();
        sc.close();

        PrintFooBar printer = new PrintFooBar(n);
        Thread fooThread = new Thread(printer::printFoo);
        Thread barThread = new Thread(printer::printBar);

        barThread.start();
        fooThread.start();

        fooThread.join();
        barThread.join();
    }
}
