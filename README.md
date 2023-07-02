# Problem Statement
Suppose there are two threads t1 and t2. t1 prints "Foo" and t2 prints "Bar". You are required to write a program which 
takes a user input n. Then the two threads print "Foo" and "Bar" alternately n number of times. The code for the class
is as follows:
```java
public class PrintFooBar {
    
    public void printFoo() {
        for (int i = 1; i <= n; ++i) {
            System.out.println("Foo");
        }
    }
    
    public void printBar() {
        for (int i = 1; i <= n; ++i) {
            System.out.println("Bar");
        }
    }
}
```
The two threads will run sequentially. You have to synchronize the two threads so that the functions `printFoo()` and 
`printBar()`will be executed in order.

## Solution Approach
1. Add a boolean flag in `PrintFooBar` to determine which method should be executed.
2. In `printFoo()`, the thread waits till flag becomes false. Then the thread prints foo, sets flag to true, invokes
`notify()` and proceeds towards the next iteration.
3. `printBar()` follows the same logic, except it waits for flag to become true.

## Sample Output
```
Enter the number of iterations
10
Foo
Bar
Foo
Bar
Foo
Bar
Foo
Bar
Foo
Bar
Foo
Bar
Foo
Bar
Foo
Bar
Foo
Bar
Foo
Bar
```