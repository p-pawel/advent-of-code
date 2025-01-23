# AoC 2024: Day 11

## Part 1 & 2 - Haskell

```bash
cd haskell/app
cabal run < ../../sample.txt 
cd ..
```

## Observations

- TIL Haskell has typeclasses 

```haskell
class Strategy a where
    execute :: a -> Int -> Int -> Int
```
that work more like Java object interfaces or Scala functional traits: 
```haskell
data AddStrategy = AddStrategy
data MultiplyStrategy = MultiplyStrategy

instance Strategy AddStrategy where
    execute _ x y = x + y

instance Strategy MultiplyStrategy where
    execute _ x y = x * y
```
Naming aside. It means I can play with some desing patterns. 


- VSC seem to ignore "default-extensions:   GADTs" and displays error suggesting to add {-# LANGUAGE GADTs #-} when Cabal does not need it (because it's already in `.cabal` file), no idea why

- I didn't find a nice way to log output of function inline (even thought Debug.trace seems to work inline ideed). Having a piece of code probably it's not possible to log the result of `myFunction` in the same line it's executed:
```haskell
  let value = myFunction number
      result = trace ("result: " ++ show value) value
```
(in simple cases the `myFunction` can be extended like this:
```haskell
let value = myFunction number
    result = trace ("result: " ++ show value) value
```
but in case of functions with different outputs or 3rd party libs, it's too much noise needed for this


- TIL passing args to function in case of composed functions have a "funny" (not so logic) syntax in case you need to pass the output of another operation as one of more arguments to the function, e.g.
```
-- as the first argument
applyToEach :: [Int] -> Int -> [Int]
applyToEach xs y = map (`myFunction` y) xs

-- as the second argument
applyToEach :: Int -> [Int] -> [Int]
applyToEach x ys = map (myFunction x) ys
```

- Refactor - without IDE is a pain process. Note that VS Code is just an editor - on steroids, but it's not IDE. If you are beginner in a given language, having a support from IDE part
(extract functions, variables, moving to another part, scaffolding unit tests, adding dependencies etc). It is not only a magic, but also a serious improvement of learning process. 

- VCS using Haskell Language Server has the power to hint what dependencies are needed, but (1) it has no power to add it automatically, (2) it doesn't know that something is already added :-/ 

- memoization with Haskell - perhaps doable manually, more robust is with libs - "guessing" a contract for function and use it in the body is a too new thing to me still ;)

- installation of dependencies with Cabal - it rather didn't work for me as expected:
```
$ cabal install MemoTrie

Resolving dependencies...
Error: [Cabal-7127]
Cannot build the executables in the package MemoTrie because none of the components are available to build: the executable 'generic' is marked as 'buildable: False'
```
but after adding to `*.cabal` file it was able to install it if needed during the `cabal run` execution.



- last no least: knowing how to solve a problem and applying it / turning into action are two different things



## Day+1 update

- While yesterday I had enjoyed the typeclasses, after few more bites of Haskell knowledge, I needed to refactor all these Java-ish object strategies into Haskell guards



