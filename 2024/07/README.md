# AoC 2024: Day 07

I was going to use a language that is "exotic" to me for such "simple problem", but after stubborn checking corner cases in the algorithmic solution of the yesterdays labirynth loops, I couldn't afford to focus on this challenge deeply enough, so I stuck to well-known to me Java again

It is a kind of Brute Force solution, that checks every possible combination of operators between numbers. 

Perhaps the performance could be improved, e.g. by checking if the expected result was already exceeded, but assuming the size of the test data, solution seem to be enough.


## Part 1 and Part 2

```bash
cd java
./mvnw -q clean compile exec:java < ../sample.txt 
cd ..
```