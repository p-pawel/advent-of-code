use regex::Regex;
use std::io::{self, BufRead};

fn main() {

    let pattern = r"mul\(([0-9]+),([0-9]+)\)";
    let re = Regex::new(pattern).unwrap();

    let stdin = io::stdin();
    let reader = stdin.lock();
    

    for line in reader.lines() {
        let mut sum = 0;

        for captures in re.captures_iter(line.unwrap().as_str()) {
            if let Some(arg1) = captures.get(1) {
                if let Some(arg2) = captures.get(2) {
                    let product = arg1.as_str().parse::<i32>().unwrap() * arg2.as_str().parse::<i32>().unwrap();
                    sum += product
                }
            }
        }
        println!("Part 1: {}", sum);
    }


}