# Multithreading

## Concept
Concurrent execution of two or more threads. Maximizes CPU utilization.

## Key Topics
- Thread creation (extends Thread, implements Runnable)
- Thread lifecycle
- Thread priority
- Synchronization
- Inter-thread communication
- Thread safety
- Deadlock

## Folders
- `Syncronization/` - Synchronization examples

## Files
- `LaunchMulti1.java` to `LaunchMulti12.java` - Progressive examples
- `SettingPriorityToThread.java` - Thread priority
- `StateOfThread.java` - Thread states
- `YeldMethod.java` - yield() method

## Thread States
```
NEW → RUNNABLE → RUNNING → TERMINATED
         ↓           ↓
      BLOCKED    WAITING
```

## Example
```java
// Method 1: Extends Thread
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

// Method 2: Implements Runnable
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running");
    }
}

// Synchronization
synchronized void printTable(int n) {
    for(int i = 1; i <= 5; i++) {
        System.out.println(n * i);
    }
}
```

## Thread Methods
- start(), run(), sleep(), join(), yield()
- setPriority(), getPriority()
- wait(), notify(), notifyAll()
