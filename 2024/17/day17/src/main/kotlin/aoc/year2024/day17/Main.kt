package aoc.year2024.day17


var program = listOf<Long>()

fun main() {

    val lines = generateSequence {
        readlnOrNull()
    }.toList()

    val (registers, inputProgram) = parseInputData(lines)
    program = inputProgram
    var programOutput = executeProgram(program, registers)

    println("Part 1: ${programOutput.joinToString(",")}")

    val result = part2(registers, inputProgram)
    println("Part 2: ${result ?: "failed"}")
}

private fun part2(
    registers: List<Long>,
    inputProgram: List<Long>
): Long? {
    if (registers[1] != 0L || registers[2] != 0L) {
        error("part 2 expects registers B and C initialized with 0")
    }

    val initialBF = bruteForceSearchMatchingPartialPatternUpTo(1L shl 3) // or any other multiple of 3

    val i = countNumbersMissingInResult(initialBF)
    if (i == null) {
        // note:  if the length of result doesn't depend on initial A value, maybe sample data is not Quine-prone
        // but let's give it a chance with BF
        val result = bruteForce(0..(1L shl 32))
        return result
    } else {
        val maxIndexMissingIndex = i - 1
        val shift = (maxIndexMissingIndex + 1) * 3

        var number = initialBF shl shift
        for (index in maxIndexMissingIndex downTo 2) {
            number = incrementUntilReaches(number, index, inputProgram[index])
        }

        val result = bruteForce(number..number + (1 shl 6))
        return result
    }
}

fun parseInputData(lines: List<String>): Pair<List<Long>, List<Long>> {
    return Pair(
        listOf(
            lines[0].split(": ")[1].toLong(),
            lines[1].split(": ")[1].toLong(),
            lines[2].split(": ")[1].toLong(),
        ),
        lines[4].split(": ")[1].split(",").map { it.toLong() }
    )
}

private fun bruteForceSearchMatchingPartialPatternUpTo(lng: Long): Long {
    val searchedOutput = program

    val matchingNumbersByProgramLength = mutableMapOf<Int, Long>()
    for (l: Long in 0L until lng) {
        val programOutput = runWithA(l, program)
        if (programOutput == searchedOutput.takeLast(programOutput.size)) {
            println("$programOutput == ${searchedOutput.takeLast(programOutput.size)}")
            matchingNumbersByProgramLength.putIfAbsent(programOutput.size, l);
        }
    }

    val round1result = matchingNumbersByProgramLength.maxWith { e, f -> e.key.compareTo(f.key) }.value
    return round1result
}

private fun bruteForce(numbers: LongRange): Long? {
    for (n in numbers) {
        if (runWithA(n, program) == program) {
            return n
        }
    }
    return null
}

private fun countNumbersMissingInResult(round1result: Long): Int? {
    var shift = 0;
    do {
        shift += 3
        if (shift > 63) {
            return null
        }
        val number = round1result shl shift;
        val programOutput1 = runWithA(number, program)
    } while (programOutput1.size < program.size);
    val toBeIdentified = runWithA(round1result shl shift, program).size - runWithA(round1result, program).size
    return toBeIdentified
}

private fun incrementUntilReaches(startNumber: Long, index: Int, expectedValue: Long): Long {
    var number = startNumber;
    do {
        number += 1L shl (3 * (index - 1))
        if (runWithA(number, program)[index] == expectedValue) {
            return number
        }
    } while (true)
}
