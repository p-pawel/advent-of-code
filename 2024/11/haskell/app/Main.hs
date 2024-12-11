{-# LANGUAGE GADTs #-} -- I'm keeping this for VSC only as it ignores default-extensions from Cabal file

class StoneChangeRule s where
    isApplicable :: s -> Int -> Bool
    process :: s -> Int -> [Int]

data RuleForZero = RuleForZero
instance StoneChangeRule RuleForZero where
    isApplicable _ x = x == 0
    process _ _ = [1]

data RuleForEvenLength = RuleForEvenLength
instance StoneChangeRule RuleForEvenLength where
    isApplicable _ x = even $ length $ show x
    process _ x = do
        let s = show x
        let firstHalf = take (length s `div` 2) s
        let secondHalf = drop (length s `div` 2) s
        [read firstHalf, read secondHalf]

data RuleOtherwise = RuleOtherwise
instance StoneChangeRule RuleOtherwise where
    isApplicable _ _ = True
    process _ x = [x * 2024]

data AnyStrategy where
    AnyStrategy :: StoneChangeRule s => s -> AnyStrategy

strategies :: [AnyStrategy]
strategies = [AnyStrategy RuleForZero, AnyStrategy RuleForEvenLength, AnyStrategy RuleOtherwise]

applyFirstMatching :: [AnyStrategy] -> Int -> [Int]
applyFirstMatching [] _ = []
applyFirstMatching (AnyStrategy s : rest) x
    | isApplicable s x = process s x
    | otherwise = applyFirstMatching rest x

transformList :: [Int] -> [Int]
transformList = concatMap (applyFirstMatching strategies)

applyNTimes :: Int -> (a -> a) -> a -> a
applyNTimes 0 _ x = x
applyNTimes n f x = f (applyNTimes (n-1) f x)

main :: IO ()
main = do
    input <- getLine
    let intArray = map read $ words input :: [Int]
    print $ length $ applyNTimes 25 transformList intArray
