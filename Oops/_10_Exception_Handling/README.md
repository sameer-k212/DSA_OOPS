# Exception Handling

## Concept
Mechanism to handle runtime errors and maintain normal application flow.

## Key Topics
- try-catch-finally blocks
- Multiple catch blocks
- Nested try
- throw keyword
- throws keyword
- Custom exceptions
- Checked vs Unchecked exceptions

## Files
- `_0_ExceptionDemo.java` to `_7_ExceptionDemo.java` - Progressive examples
- `_8_ThrowKeyWord.java` - throw usage
- `_9_CustomException.java` - Creating custom exceptions
- `ExceptionFirst.java`, `ExceptionSecond.java`, `ExceptionTest.java` - Practice

## Example
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
} finally {
    System.out.println("Always executes");
}

// Custom Exception
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}
```

## Exception Hierarchy
```
Throwable
├── Error (System errors)
└── Exception
    ├── IOException (Checked)
    ├── SQLException (Checked)
    └── RuntimeException (Unchecked)
        ├── NullPointerException
        ├── ArithmeticException
        └── ArrayIndexOutOfBoundsException
```
