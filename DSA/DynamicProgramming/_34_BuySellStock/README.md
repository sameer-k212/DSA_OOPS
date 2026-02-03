# Buy and Sell Stock

## Problem Variations

### 1. Single Transaction (Best Time to Buy and Sell Stock I)
**Problem**: Buy once, sell once for maximum profit

**Approach**: Track minimum price seen so far, calculate profit at each step
```
maxProfit = max(maxProfit, price - minPrice)
```

**Complexity**: O(n) time, O(1) space

---

### 2. Unlimited Transactions (Best Time to Buy and Sell Stock II)
**Problem**: Buy and sell multiple times (no overlapping)

**Approach**: Add all positive differences
```
if (prices[i] > prices[i-1])
    profit += prices[i] - prices[i-1]
```

**Complexity**: O(n) time, O(1) space

---

### 3. At Most K Transactions (Best Time to Buy and Sell Stock IV)
**Problem**: At most k transactions allowed

**Approach**: DP with states
- `dp[t][d]` = max profit with at most t transactions by day d
- Track maxDiff to optimize buy price

**Complexity**: O(k×n) time, O(k×n) space

---

## Key Patterns
- **Single**: Greedy - track min price
- **Unlimited**: Greedy - sum all gains
- **Limited K**: DP - state machine approach

## Examples
```
Input: prices = [7,1,5,3,6,4]
Single: 5 (buy at 1, sell at 6)
Unlimited: 7 (buy 1 sell 5, buy 3 sell 6)
K=2: 7 (same as unlimited for this case)
```
