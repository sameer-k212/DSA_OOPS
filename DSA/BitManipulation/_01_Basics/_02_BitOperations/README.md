# Bit Operations

## Basic Operations

### 1. Get Bit (Check if ith bit is set)
```java
boolean getBit(int num, int i) {
    return (num & (1 << i)) != 0;
}
```

### 2. Set Bit (Make ith bit 1)
```java
int setBit(int num, int i) {
    return num | (1 << i);
}
```

### 3. Clear Bit (Make ith bit 0)
```java
int clearBit(int num, int i) {
    return num & ~(1 << i);
}
```

### 4. Toggle Bit (Flip ith bit)
```java
int toggleBit(int num, int i) {
    return num ^ (1 << i);
}
```

### 5. Update Bit (Set ith bit to val)
```java
int updateBit(int num, int i, int val) {
    num = clearBit(num, i);
    return num | (val << i);
}
```

## Examples
```
num = 10 (1010)
getBit(10, 1) = true (bit 1 is 1)
setBit(10, 0) = 11 (1011)
clearBit(10, 1) = 8 (1000)
toggleBit(10, 2) = 14 (1110)
```

## Key Points
- Bit positions start from 0 (rightmost)
- `1 << i` creates mask with only ith bit set
- Use & for checking, | for setting, ^ for toggling
