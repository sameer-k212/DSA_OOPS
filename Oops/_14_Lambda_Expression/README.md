# Lambda Expression (Java 8)

## Concept
Anonymous function (function without name). Enables functional programming in Java.

## Syntax
```
(parameters) -> expression
(parameters) -> { statements; }
```

## Key Topics
- Functional interfaces
- Lambda syntax
- Method references
- Anonymous inner class replacement

## Files
- `_1_LambdaDemo.java` - Lambda expression examples

## Example
```java
// Without Lambda
Runnable r1 = new Runnable() {
    public void run() {
        System.out.println("Thread running");
    }
};

// With Lambda
Runnable r2 = () -> System.out.println("Thread running");

// Functional Interface
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

// Lambda usage
Calculator add = (a, b) -> a + b;
Calculator multiply = (a, b) -> a * b;

System.out.println(add.calculate(5, 3));  // 8
System.out.println(multiply.calculate(5, 3));  // 15
```

## Benefits
- Less code
- More readable
- Functional programming support
- Easy to use with Streams API
