# Wrapper Classes

## Concept
Convert primitive data types into objects. Each primitive has corresponding wrapper class.

## Wrapper Classes
- byte → Byte
- short → Short
- int → Integer
- long → Long
- float → Float
- double → Double
- char → Character
- boolean → Boolean

## Key Topics
- Autoboxing (primitive to object)
- Unboxing (object to primitive)
- Parsing methods
- Utility methods

## Files
- `Wrapper.java` - Wrapper class examples

## Example
```java
// Autoboxing (automatic conversion)
int a = 10;
Integer obj = a;  // int to Integer

// Unboxing (automatic conversion)
Integer obj2 = 20;
int b = obj2;  // Integer to int

// Manual conversion
int x = 100;
Integer obj3 = Integer.valueOf(x);  // Boxing
int y = obj3.intValue();  // Unboxing

// Parsing
String str = "123";
int num = Integer.parseInt(str);

// Utility methods
System.out.println(Integer.MAX_VALUE);
System.out.println(Integer.toBinaryString(10));
```

## Why Use Wrapper Classes?
- Collections only work with objects
- Null values possible
- Utility methods available
- Generics require objects
