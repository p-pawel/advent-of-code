
pub(crate) fn count_xmas(block: &Vec<Vec<char>>) -> usize {
    
    let mut count: usize = 0;
    for y in 1..block.len()-1 {
         for x in 1..block[y].len()-1 {
             if block[y][x] == 'A' {

                 let mut diag1 = Vec::new();
                 diag1.push(block[y-1][x-1]);
                 diag1.push(block[y][x]);
                 diag1.push(block[y+1][x+1]);

                 let mut diag2 = Vec::new();
                 diag2.push(block[y-1][x+1]);
                 diag2.push(block[y][x]);
                 diag2.push(block[y+1][x-1]);

                 let string1 = String::from_iter(diag1);
                 let string2 = String::from_iter(diag2);
                 if matches!(string1.as_str(), "SAM" | "MAS") & matches!(string2.as_str(), "SAM" | "MAS") {
                     count += 1
                 }
             }
         }
        
    }
    count
}