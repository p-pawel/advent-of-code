#!/usr/bin/env cabal

import Data.Maybe (fromMaybe, catMaybes, isNothing)
{- cabal:
build-depends: base
-}


stringToIntArray :: String -> [Int]
stringToIntArray = map (read . (:[]))


generateArray :: [Int] -> [Maybe Int]
generateArray = concat . zipWith createSequence [0..]
  where
    createSequence :: Int -> Int -> [Maybe Int]
    createSequence index count
      | even index = replicate count (Just (index `div` 2))
      | otherwise  = replicate count Nothing


findFirstNothing :: [Maybe Int] -> Maybe Int
findFirstNothing xs = go xs 0
  where
    go [] _ = Nothing
    go (Nothing:_) idx = Just idx
    go (_:rest) idx = go rest (idx + 1)


findLastJust :: [Maybe Int] -> Maybe Int
findLastJust xs = go xs 0 Nothing
  where
    go [] _ lastIdx = lastIdx
    go (Just _:rest) idx _ = go rest (idx + 1) (Just idx)
    go (Nothing:rest) idx lastIdx = go rest (idx + 1) lastIdx


switchItems :: [Maybe Int] -> Int -> Int -> [Maybe Int]
switchItems xs i j =
  [ if k == i then xs !! j
    else if k == j then xs !! i
    else x
  | (x, k) <- zip xs [0..] ]


rearrangeIfNeeded :: [Maybe Int] -> [Maybe Int]
rearrangeIfNeeded disk = do
    let firstNothingIdx = findFirstNothing disk
    let lastJustIdx = findLastJust disk
    if isNothing firstNothingIdx
      then
        disk
      else do
        if firstNothingIdx > lastJustIdx
          then
            disk
          else do
            let justFirstNothingIdx = fromMaybe (-1) firstNothingIdx
            let justLastJustIdx = fromMaybe (-1) lastJustIdx
            let fixedDisk = switchItems disk justFirstNothingIdx justLastJustIdx
            rearrangeIfNeeded fixedDisk


sumOfProducts :: [Maybe Int] -> Int
sumOfProducts xs = sum $ zipWith (*) (catMaybes xs) [0..]


main :: IO ()
main = do
    input <- getLine
    print $ sumOfProducts $ rearrangeIfNeeded $ generateArray $ stringToIntArray input