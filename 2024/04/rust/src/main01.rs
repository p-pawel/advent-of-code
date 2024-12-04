use crate::block_service::{
    split_anti_diagonally, split_diagonally, split_horizontally, split_vertically,
};

pub fn count_xmas(block: &Vec<Vec<char>>) -> usize {
    let strings_h = split_horizontally(&block);
    let strings_v = split_vertically(&block);
    let strings_d0 = split_diagonally(&block);
    let strings_d1 = split_anti_diagonally(&block);

    let count_h = count_in_block(strings_h);
    let count_v = count_in_block(strings_v);
    let count_d0 = count_in_block(strings_d0);
    let count_d1 = count_in_block(strings_d1);

    let count = count_h + count_v + count_d0 + count_d1;

    count
}

fn count_in_block(strings_h: Vec<String>) -> usize {
    let mut count = 0;
    for line in strings_h {
        count += line.split("XMAS").count() - 1;
        count += line.split("SAMX").count() - 1;
    }
    count
}
