# Bitwise Operators

## Operators

| Operator | Symbol | Description | Example |
|----------|--------|-------------|---------|
| AND | & | Both bits 1 → 1 | 5 & 3 = 1 (101 & 011 = 001) |
| OR | \| | Any bit 1 → 1 | 5 \| 3 = 7 (101 \| 011 = 111) |
| XOR | ^ | Different bits → 1 | 5 ^ 3 = 6 (101 ^ 011 = 110) |
| NOT | ~ | Flip all bits | ~5 = -6 |
| Left Shift | << | Shift left, fill 0 | 5 << 1 = 10 (multiply by 2) |
| Right Shift | >> | Shift right, sign extend | 5 >> 1 = 2 (divide by 2) |
| Unsigned Right | >>> | Shift right, fill 0 | 5 >>> 1 = 2 |

## Key Properties

### XOR Properties (Most Important for CP)
- `a ^ a = 0` (same values cancel)
- `a ^ 0 = a` (identity)
- `a ^ b ^ a = b` (commutative)
- XOR is associative and commutative

### AND Properties
- `a & 0 = 0`
- `a & 1 = a`
- `a & a = a`

### OR Properties
- `a | 0 = a`
- `a | 1 = 1`
- `a | a = a`

## Common Tricks
- Multiply by 2: `n << 1`
- Divide by 2: `n >> 1`
- Check even/odd: `n & 1` (0=even, 1=odd)
- Toggle bit: `n ^ (1 << i)`
- Set bit: `n | (1 << i)`
- Clear bit: `n & ~(1 << i)`
