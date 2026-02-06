# Enum

## Concept
Special class representing group of constants (unchangeable variables).

## Key Topics
- Enum declaration
- Enum with constructor
- Enum with methods
- Enum in switch statement
- EnumSet, EnumMap

## Files
- `LaunchEnum1.java` - Basic enum
- `LaunchEnum2.java` - Enum with constructor
- `LaunchEnum3.java` - Enum with methods
- `LaunchAN.java`, `LaunchAN2.java` - Advanced examples
- `LaunchDT1.java`, `LaunchDT2.java` - Date/Time with enum
- `LaunchFE.java` - Functional enum
- `LaunchSTR.java` - String operations

## Example
```java
// Basic enum
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// Enum with constructor and method
enum Size {
    SMALL(10), MEDIUM(20), LARGE(30);
    
    private int value;
    
    Size(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}

// Usage
Day today = Day.MONDAY;
Size size = Size.LARGE;
System.out.println(size.getValue());  // 30
```

## Benefits
- Type safety
- Readable code
- Can have fields and methods
- Can implement interfaces
