# Final Keyword

## Concept
Used to restrict user from modifying variables, methods, or classes.

## Types

### 1. Final Variable
- Value cannot be changed (constant)
- Must be initialized

### 2. Final Method
- Cannot be overridden by child class
- Can be inherited

### 3. Final Class
- Cannot be extended
- No child class possible

## Files
- `Final.java` - Final variable and method examples
- `FinalClass.java` - Final class examples

## Example
```java
// Final variable
final int MAX_VALUE = 100;

// Final method
class Parent {
    final void show() {
        System.out.println("Cannot override");
    }
}

// Final class
final class Math {
    // Cannot extend this class
}
```

## Use Cases
- Constants: `final double PI = 3.14159;`
- Security: Prevent method overriding
- Immutability: String class is final
