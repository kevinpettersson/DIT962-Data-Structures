

-- Binary search

binarySearch :: (Ord a) => [a] -> a -> Maybe Int
binarySearch [] _       = Nothing
binarySearch xs target  = binarySearchHelper xs target 0 (length xs - 1)

binarySearchHelper :: (Ord a) => [a] -> a -> Int -> Int -> Maybe Int
binarySearchHelper xs target start end
    | start > end          = Nothing
    | middleElem == target = Just middleIndex
    | middleElem > target  = binarySearchHelper xs target start middleIndex
    | middleElem < target  = binarySearchHelper xs target middleIndex end
    where 
        middleIndex = (start + end) `div` 2
        middleElem = xs !! middleIndex

-- Reverse array

reverse' :: [a] -> [a]
reverse' []         = []
reverse' [x]        = [x] 
reverse' (x:xs)     = a ++ [b]
    where a = reverse' xs
          b = head (x:xs)

rev :: [a] -> [a]
rev [] = []
rev (x:xs) = rev xs ++ [x]

-- Interleave two strings

interleave :: String -> String -> String
interleave "" ""         = ""
interleave "" ys         = ys
interleave xs ""         = xs
interleave (x:xs) (y:ys) = x : y : interleave xs ys
