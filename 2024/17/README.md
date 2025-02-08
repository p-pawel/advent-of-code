# AoC 2024: Day 17

## Context

https://adventofcode.com/2024/day/17


## Part 1 + Part 2

```bash
cd day17
./gradlew -q run < ../sample.txt
cd ..
```

Note: this bases on a sample dataset that may be not suitable for part 2. Due to copyright restriction of AoC data I cannot share my test dataset. Feel free to try it with your dataset available from the URL listed in the top.

## Observations

- for part 2 brute force didn't work (full integer range appeared to be not enough) - would took roughly 500kk years 

- without any educated guess where to start any clever analysis, I treated the Strange Device as a black box

- by trial and error analysis of its outputs it turned out that there's some dependency between A register value and the program output, and every 3 bits difference in the input result in the next positions in the output occupied the way that the obtained pattern is moving right within the output

```
run program with(a = 4)       -> 0
run program with(a = 4 * 2^3) -> 4,0
run program with(a = 4 * 2^6) -> 4,4,0
```
- this allowed to identify the input that asserts proper very last number in the output - that corresponds to the largest step of the value (magnitude of 2^[16*3])

- having this one set, we can take another steps smaller by 2^8 times with a quick "brute-force" until a proper number pops up, and continue toward the start - I could imagine the Enigma rotors blocking one after the other during breaking the cypher - in case if my math imagination is misleading here's more about the real principles behind that device https://en.wikipedia.org/wiki/Cryptanalysis_of_the_Enigma

- this didn't work for last (first) two numbers, but bruteforcing them is not a big-deal

- this worked for my set of test data, there's no guarantee it can work with another; e.g. the part 2 doesn't work with the task example data as then output length is not dependent on the input registers

## Yet another approach to part 2

The 2nd part was quite demanding, in terms of not-a-straight way to discover the dependencies between input and output 
(not to mention that probably "the easiest" solution was to revert a part of the calculations done by the Strange Device in a mathematical way; but to me, it still sounds like test data-dependent solution - note last comment from the above section)

Having it solved that way, after a few hours break from this subject, I experienced a kind of "eureka moment". 
When we have a large dataset to be analyzed (far too large to brute-force it), and the input can take a form of quite straightforward feature vector,
then the meta-heuristic methods look to be a perfect candidate to use here. Moreover, from the mathematical nature of the Strange Device we can expect it have some local minima. 

Particularly, I picked the Genetic Algorithm, about which I did quite a cool presentation while being yet at university 
(and beside holding sentiments, I hold some knowledge). As I recall, then it could present a few variants of the geographical optimization in the real time 
(on poor mobile Celeron), so it must have been quite performant algorithm.

And it works in this case too. The only issue is that the Strange Device seem to return 0 for a several values and as we need to return only the first of them (the smallest),
I just run it the whole algorithm several times and return the smallest of found matching inputs.
