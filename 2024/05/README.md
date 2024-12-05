# AoC 2024: Day 05 

**Print Queue EE**

I was going to use the Advent of Code time to experiment with different languages,
but this time I decided to do the experiment within an experiment.

This experiment involves the use of Java, that is well known to me,
and do it with some degree craftsmanship, but go make it a bit caricatured
using guns that are rather too big for such kind of task, like elements of 
Domain-Driven-Design, hexagonal architecture, or some patterns that
satirically are more suitable to legacy EE monoliths than to a small code challenge.

## Verification

```bash
cd java
./gradlew run < ../sample.txt
cd ..
```

## Conclusion

- it is a pleasure to use a language you know fluently

- despite having a dozen years or so of experience in Java, apparently the processing of standard input is
  not something I used to deal with on everyday basis, also the Gradle's `run` task until adjusted in `build.gradle` doesn't accept bash redirected std-in  

- the `gradle init` ([sinc 4 years, sic](https://github.com/gradle/gradle/pull/14210)) generates a subproject setup within `app` directory, in order to make it easier to add additional subprojects in the future, but in case of such small projects it looks like a premature overengineering (yup, it can't be switched off with flag or sth) 