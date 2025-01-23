# AoC 2024: Day 12

## Context

https://adventofcode.com/2024/day/12

## Intro

It's time for Kotlin!

- https://www.jetbrains.com/help/idea/create-your-first-kotlin-app.html

## Part 1 + Part 2

```bash
cd day18
./gradlew run -q < ../sample1.txt
./gradlew run -q < ../sample2.txt
cd ..
```

## Observation

- Kotlin provides nice amount of syntax sugar - a few Java ubiquitous keywords and statements that can be forgotten: `new`, `public`, even semicolons `;`

- no `.stream()`, stream operations are first-class passengers, and newer can be easy declared as friendly/extension functions to existing collections

- functions everywhere ;), no need to wrap them with classes (even though underneath are wrapped into ...Kt classes)

- in comparison with recent experience with Haskell:
    - Kotlin allows functional syntax while keeping Java semantic (so there'is no need to do postgrads of standard libraries or dependencies)
    - in case you need to play with a dirty side job: there are impure solutions, mutable objects, and a full range of sins to choose from ;) 
    - I can just put `sout` inside of lambda or wherever (no need to wrap with another special code block)
    - IntelliJ, unlike the VS Code, is the IDE

