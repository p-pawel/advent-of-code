# AoC 2024: Day 03

## Part 1

```bash
cd rust/part01
cargo run < ../../sample.txt
cd ../..
```

## Part 2

```bash
cd rust/part02
cargo run < ../../sample.txt
cd ../..
```

## Early observations
- first ever Rust piece code (it's done, for sure it could be better)
- because of a certain level of similarity between two parts, it could be worth of trying to cover both cases in one program
- in a "serious" case, with more "commands" to be handled, perhaps it would be worth to replace regex with a simple string processor state machine and strategies to handle these command 