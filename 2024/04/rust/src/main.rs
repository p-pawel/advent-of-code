use std::io::{self, BufRead};

mod block_service;
mod main01;
mod main02;

fn main() {

    let block = read_block_from_stdin();

    println!("Day 04. Part 01: {}", main01::count_xmas(&block));
    println!("Day 04. Part 02: {}", main02::count_xmas(&block));
}

fn read_block_from_stdin() -> Vec<Vec<char>> {
    let stdin = io::stdin();
    let reader = stdin.lock();

    let mut block = Vec::new();
    for line in reader.lines() {
        let mut row = Vec::new();

        let line = line.unwrap();
        line.chars().for_each(|c| { row.push(c); });
        block.push(row);
    }
    block
}