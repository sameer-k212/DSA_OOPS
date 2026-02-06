# Generics

## Concept
Provide type safety and eliminate need for type casting. Write code that works with any data type.

## Key Topics
- Generic classes
- Generic methods
- Bounded type parameters
- Wildcards (?, extends, super)
- Type erasure

## Files
- `Gen1.java` - Basic generic class
- `Gen2.java` - Generic methods
- `Gen3.java` - Bounded generics

## Example
```java
// Generic class
class Box<T> {
    private T value;
    
    void set(T value) {
        this.value = value;
    }
    
    T get() {
        return value;
    }
}

// Usage
Box<Integer> intBox = new Box<>();
intBox.set(10);

Box<String> strBox = new Box<>();
strBox.set("Hello");

// Generic method
<T> void printArray(T[] arr) {
    for(T element : arr) {
        System.out.println(element);
    }
}
```

## Benefits
- Type safety at compile time
- No type casting needed
- Code reusability
- Cleaner code
