# AoC 2024: Day 15

## Context

https://adventofcode.com/2024/day/15


## Part 1 + Part 2

```bash
cd day15
./gradlew -q run < ../sample.txt
cd ..
```

## Observations


- a hard day of work in fish warehouse ;)

- I started with a smartly extracted problem (note "radar" methods in previous commmit), it was to well fitted to the part 1, and it did hit back in part 2

- finally refactored to the game-like behaviour, and into object Sprite, so at least I could knew what I'm debugging

- DDD (or even well crafted OOP) is freaking good - the responsibiliy for the ifologies goes to domain objects


- open issues: 
    - SpriteType.moveable is not used but it could be in applyMove or tryToPushTheBox
    - the flow based on the expection can be regarded as an anti-pattern, perhaps the dedicated output value for this could be use (either just null or Go-like pair of outputs) 
    - perhaps Sprite parsing return type could be simplified if a BIG_WALL sprite type is included
