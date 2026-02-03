# Fibonacci Numbers

## Problem Statement
Find the nth Fibonacci number where F(0) = 0, F(1) = 1, and F(n) = F(n-1) + F(n-2).

## Example
```
Input: n = 5
Output: 5
Explanation: 0, 1, 1, 2, 3, 5
```

## Approaches

### 1. Recursion
```java
if (n <= 1) return n;
return fib(n-1) + fib(n-2);
```
**Complexity**: O(2^n) time, O(n) space

### 2. Memoization
```java
if (dp[n] != -1) return dp[n];
return dp[n] = fib(n-1) + fib(n-2);
```
**Complexity**: O(n) time, O(n) space

### 3. Tabulation
```java
dp[0] = 0; dp[1] = 1;
for (int i = 2; i <= n; i++)
    dp[i] = dp[i-1] + dp[i-2];
```
**Complexity**: O(n) time, O(n) space

### 4. Space Optimized
```java
int prev2 = 0, prev1 = 1;
for (int i = 2; i <= n; i++) {
    int curr = prev1 + prev2;
    prev2 = prev1;
    prev1 = curr;
}
```
**Complexity**: O(n) time, O(1) space

## Key Points
- Foundation problem for understanding DP
- Demonstrates all DP optimization techniques
- Classic example of overlapping subproblems
