import Data.MemoTrie

blink :: Int -> [Int]
blink x
    | x == 0 = [1]
    | even $ length $ show x = let
        str = show x
        half = length str `div` 2
        in [read $ take half str, read $ drop half str]
    | otherwise = [x * 2024]

countStones :: Int -> Int -> Int
countStones number repeats
    | repeats == 0 = 1
    | otherwise = sum $ map ( `countStonesMemo` (repeats-1)) $ blink number

countStonesMemo :: Int -> Int -> Int
countStonesMemo = memo2 countStones

main :: IO ()
main = do
    input <- getLine
    let intArray = map read $ words input :: [Int]
    putStrLn $ "Part 1: " ++ show (sum $ map (`countStonesMemo` 25) intArray)
    putStrLn $ "Part 2: " ++ show (sum $ map (`countStonesMemo` 75) intArray)
