use regex::Regex;
use std::io::{self, BufRead};

fn main() {

    let pattern = r"(mul)\(([0-9]+),([0-9]+)\)|(don't)\(\)|(do)\(\)";
    let re = Regex::new(pattern).unwrap();

    let stdin = io::stdin();
    let reader = stdin.lock();

    for line in reader.lines() {
        let mut sum = 0;
        let mut doing = true;

        for captures in re.captures_iter(line.unwrap().as_str()) {
            if captures.get(1) != None && captures.get(1).unwrap().as_str() == "mul" {
                if let Some(arg2) = captures.get(2) {
                    if let Some(arg3) = captures.get(3) {
                        let product = arg2.as_str().parse::<i32>().unwrap() * arg3.as_str().parse::<i32>().unwrap();
                        if doing {
                            sum += product
                        }
                    }
                }
            }

            if captures.get(4) != None && captures.get(4).unwrap().as_str() == "don't" {
                doing = false;
            }

            if captures.get(5) != None && captures.get(5).unwrap().as_str() == "do" {
                doing = true;
            }
        }

        println!("Part 2: {}", sum);
    }
}
