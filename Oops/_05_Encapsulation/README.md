# Encapsulation

## Concept
Wrapping data (variables) and code (methods) together. Hiding internal details.

## Key Topics
- Private variables
- Public getter/setter methods
- Access modifiers (private, public, protected, default)
- Data hiding
- Security

## Files
- `Encapsulation.java` - Complete encapsulation example

## Example
```java
class Student {
    private String name;
    private int age;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }
}
```

## Benefits
- Data security
- Control over data
- Easy to maintain
- Flexibility
