#!/usr/bin/env python3

import sys


def read_input():
    return [list(map(int, line.split())) for line in sys.stdin]


def is_ordered(nums, can_fix):
    diffs = [nums[i] - nums[i - 1] for i in range(1, len(nums))]

    increasing_ok = sum([1 <= diff <= 3 for diff in diffs])
    decreasing_ok = sum([-1 >= diff >= -3 for diff in diffs])

    if increasing_ok == len(diffs) or decreasing_ok == len(diffs):
        return True

    if not can_fix:
        return False

    for i in range(0, len(nums)):
        fixed_nums = nums[:]
        fixed_nums.pop(i)
        res = is_ordered(fixed_nums, False)
        if res:
            return True

    return False


def main():
    lines = read_input()

    part01_result = 0
    for line in lines:
        part01_result += 1 if is_ordered(line, False) else 0

    part02_result = 0
    for line in lines:
        part02_result += 1 if is_ordered(line, True) else 0

    print(f"Part 1: {part01_result}")
    print(f"Part 2: {part02_result}")


if __name__ == "__main__":
    main()
