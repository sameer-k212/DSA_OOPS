# Constructor

## Concept
Special method called when object is created. Used to initialize object state.

## Key Topics
- Default constructor
- Parameterized constructor
- Constructor overloading
- this keyword
- super keyword
- Private constructor

## Files
- `Constructor.java` - Basic constructor examples
- `Constructor1.java` - Constructor overloading
- `PrivateConstructor.java` - Singleton pattern
- `ThisAndSuper.java` - this and super usage

## Example
```java
class Student {
    String name;
    
    Student() {
        this.name = "Unknown";
    }
    
    Student(String name) {
        this.name = name;
    }
}
```
