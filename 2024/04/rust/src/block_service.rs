pub fn split_horizontally(data: &Vec<Vec<char>>) -> Vec<String> {
    data.iter().map(|row| String::from_iter(row)).collect()
}

pub fn split_vertically(data: &Vec<Vec<char>>) -> Vec<String> {

    let mut column_strings = Vec::new();

    if data.is_empty() || data[0].is_empty() {
        return column_strings;
    }

    let num_columns = data[0].len();
    let num_rows = data.len();

    for col in 0..num_columns {
        let mut column_chars = Vec::new();
        for row in 0..num_rows {
            column_chars.push(data[row][col]);
        }
        column_strings.push(String::from_iter(column_chars));
    }

    column_strings
}

pub fn split_diagonally(data: &Vec<Vec<char>>) -> Vec<String> {
    let mut results = Vec::new();

    if data.is_empty() || data[0].is_empty() {
        return results;
    }

    let n: isize = data.len() as isize; // I'm assuming it's a square 

    for i in -n + 1..n {
        let x0 = 0;
        let y0 = i;

        let mut entry = Vec::new();

        for j in 0..n {
            let x = x0 + j;
            let y = y0 + j;
            if x < 0 || y < 0 {
                continue;
            }
            if x >= n || y >= n {
                continue;
            }
            entry.push(data[y as usize][x as usize]);
        }
        results.push(String::from_iter(entry));
    }

    results
}

pub fn split_anti_diagonally(data: &Vec<Vec<char>>) -> Vec<String> {
    let mut results = Vec::new();

    if data.is_empty() || data[0].is_empty() {
        return results;
    }

    let n: isize = data.len() as isize; // I'm assuming it's a square 

    for i in -n + 1..n {
        let x0 = n-1;
        let y0 = i;

        let mut entry = Vec::new();

        for j in 0..n {
            let x = x0 - j;
            let y = y0 + j;
            if x < 0 || y < 0 {
                continue;
            }
            if x >= n || y >= n {
                continue;
            }
            entry.push(data[y as usize][x as usize]);
        }
        results.push(String::from_iter(entry));
    }

    results
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn should_split_horizontally() {
        let grid = vec![
            vec!['a', 'b', 'c'],
            vec!['d', 'e', 'f'],
            vec!['g', 'h', 'i'],
        ];

        let strings = split_horizontally(&grid);

        let expected = vec![
            String::from("abc"),
            String::from("def"),
            String::from("ghi"),
        ];

        assert_eq!(strings, expected);
    }

    #[test]
    fn should_split_vertically() {
        let grid = vec![
            vec!['a', 'b', 'c'],
            vec!['d', 'e', 'f'],
            vec!['g', 'h', 'i'],
        ];

        let strings = split_vertically(&grid);

        let expected = vec![
            String::from("adg"),
            String::from("beh"),
            String::from("cfi"),
        ];

        assert_eq!(strings, expected);
    }

    #[test]
    fn should_split_diagonally() {
        let grid = vec![
            vec!['a', 'b', 'c'],
            vec!['d', 'e', 'f'],
            vec!['g', 'h', 'i'],
        ];

        let strings = split_diagonally(&grid);

        let expected = vec![
            String::from("c"),
            String::from("bf"),
            String::from("aei"),
            String::from("dh"),
            String::from("g"),
        ];

        assert_eq!(strings, expected);
    }
    
    #[test]
    fn should_split_anti_diagonally() {
        let grid = vec![
            vec!['a', 'b', 'c'],
            vec!['d', 'e', 'f'],
            vec!['g', 'h', 'i'],
        ];

        let strings = split_anti_diagonally(&grid);

        let expected = vec![
            String::from("a"),
            String::from("bd"),
            String::from("ceg"),
            String::from("fh"),
            String::from("i"),
        ];

        assert_eq!(strings, expected);
    }
}
