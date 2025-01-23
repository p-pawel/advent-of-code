package aoc.year2024.day14

import java.util.Scanner

fun readRobots(scanner: Scanner): List<Robot> {

    var res = ArrayList<Robot>();
    while (scanner.hasNextLine()) {
        val line = scanner.nextLine()
        if (line.isEmpty()) {
            continue
        }
        val parts = line.split(" ")

        when (parts.size) {
            2 -> {
                val pParts = parts[0].split("=")[1].split(",")
                val vParts = parts[1].split("=")[1].split(",")

                if (pParts.size == 2 && vParts.size == 2) {
                    val px = pParts[0].toInt()
                    val py = pParts[1].toInt()
                    val vx = vParts[0].toInt()
                    val vy = vParts[1].toInt()

                    res.add(Robot(Vector(px, py), Vector(vx, vy)))
                } else {
                    error("Invalid input format")
                }
            }

            else -> {
                error("Invalid input format")
            }
        }
    }

    return res

}