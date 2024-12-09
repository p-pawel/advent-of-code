# AoC 2024: Day 09


## Part 1 - Haskell

```bash
cd haskell/day09part01
cabal run < ../../sample.txt 
cd ..

## Part 2 - Java

```bash
cd java
./mvnw -q clean compile exec:java < ../sample.txt 
cd ..
```

## Observations

The task looked like a long hanging fruit, so I assumed that it could be a good idea to pick a language that is totally exitoc to me: Haskell.

It wasn't a good choice mostly due to these 2 sometime related with time issues:

1. A local installation of Haskell tools, even though there are dedicated tools, is a nightmare, the more nightmarish if something goes wrong - the tools are quite nice but under a hood they do the plain-old make-based process, which due to tarball size, even on a good machine takes a few good minutes. Adding to this that bundled Stack by "the new better integration with GHC" just breaks the previously installed GHC binaries, it breaks it a way that is not fixable with "ghcup tui". Eventually I gave up with Stack, and stuck to Cabal, as a package manager / build tool.
Update: after a few days that problem with Stack no longer occurred, so I'm assuming it could be just an anomaly caused by some coincidence of unfortunate non-deterministic events (most likely I would blaim my lack of experience with this setup)

2. Choosing Haskell doesn't seem to be a clever idea to solve algorithmic puzzles. In a nutshell: there are no loops. Instead of loops there is a... recursion :-]. It doesn't seem like a good choice for the task that needs to  operate on 100K-items long arrays, stack is skyrocketing. Luckily without overflow. 

It seems there's no good IDE support for Haskell. JetBrains' plugin no longer exists: https://plugins.jetbrains.com/plugin/8258-intellij-haskell and VCS, despite of some level of integration with Haskell Language Server, gives rather a poor experience.

Part 2. It seemed to require a non-sophisticated refactor to files from sectors ana moving rightmost files to the leftmost big enough hole. Unfornutely I was defeated by mine unfamiliarity with Haskell, so in order to resolve in it a reasonable time I switched to Java. Then it went pretty smooth to the end.


