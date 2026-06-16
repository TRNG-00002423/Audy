# Linear vs binary — results (rename to RESULTS.md)

## Contributors
- Driver / Navigator Round 1:
- Driver / Navigator Round 2:

## Round 1 (N = _1,000,000__)

| Algorithm | Time (ms) | Notes |
|-----------|-----------|-------|
| Linear |1.866 |  |
| Binary | 0.002 | |

## Round 2 (N = _5,000,000__)

| Algorithm | Time (ms) | Notes |
|-----------|-----------|-------|
| Linear | 11.021 | |
| Binary | 0.003 | |

## Big-O discussion
Linear search is O(n) with that being said, more elements means more time. 
Binary search is O(log n) so the time barely changed even with a much bigger array.
Binary search was hundreds of times faster in both rounds.

## Caveats (JVM, cache, warmup)
Keep in mind that the JVM does not produce consistent timing on a single run,
and the CPU cache behaves differently depending on what else is running.
Which is why Big-O matters, it tells you how an algorithm behaves at scale, not just on one run
