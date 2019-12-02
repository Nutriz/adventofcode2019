
val ADD = 1
val MUL = 2
val END = 99

fun main() {

    val program = inputsDay2.split(",").map(String::toInt)

    // part 1
    println("part1: " + run(program, 12, 2))

    //part 2
    for (noun in 0 until 100)
        for (verb in 0 until 100)
            if (run(program, noun, verb) == 19690720)
                println("part2: " + (100 * noun) + verb)
}

fun run(program: List<Int>, noun: Int, verb: Int): Int {
    val memory = program.toMutableList()
    memory[1] = noun
    memory[2] = verb

    var currentPos = 0

    fun addAndSave(a: Int, b: Int, savePos: Int) {
        val newValue = memory[a] + memory[b]
        memory[savePos] = newValue
        currentPos += 4
    }

    fun mulAndSave(a: Int, b: Int, savePos: Int) {
        val newValue = memory[a] * memory[b]
        memory[savePos] = newValue
        currentPos += 4
    }

    loop@while (true) {
        when (val opcode = memory[currentPos]) {
            ADD -> addAndSave((memory[currentPos+1]), (memory[currentPos+2]), (memory[currentPos+3]))
            MUL -> mulAndSave((memory[currentPos+1]), (memory[currentPos+2]), (memory[currentPos+3]))
            END -> break@loop
            else -> error("unknown opcode $opcode")
        }
    }

    return memory[0]
}

var inputsDay2 = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,6,19,2,19,6,23,1,23,5,27,1,9,27,31,1,31,10,35,2,35,9,39,1,5,39,43,2,43,9,47,1,5,47,51,2,51,13,55,1,55,10,59,1,59,10,63,2,9,63,67,1,67,5,71,2,13,71,75,1,75,10,79,1,79,6,83,2,13,83,87,1,87,6,91,1,6,91,95,1,10,95,99,2,99,6,103,1,103,5,107,2,6,107,111,1,10,111,115,1,115,5,119,2,6,119,123,1,123,5,127,2,127,6,131,1,131,5,135,1,2,135,139,1,139,13,0,99,2,0,14,0"
