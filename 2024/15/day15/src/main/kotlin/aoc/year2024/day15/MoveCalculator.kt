package aoc.year2024.day15

fun moveTheLine(input: String) : String {
    return if (input.startsWith('.') || input.startsWith('#') || input.isEmpty()) {
        input;
    } else {
        val subMoved = moveTheLine(input.drop(1))
        if (subMoved.startsWith('.')) {
            ".O" + subMoved.drop(1);
        } else {
            input;
        }
    }

}