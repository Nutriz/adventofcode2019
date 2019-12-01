fun main() {
    part1FirstSolution()
    part1WithFold()
    part2()
}

private fun part1FirstSolution() {
    val fuel = inputsDay1.lines().sumBy {
        it.toInt().div(3).minus(2)
    }
    println("part1: $fuel") // 3362507
}

private fun part1WithFold() {
    val fuel1 =
        inputsDay1.lines().fold(0) { total, next ->
            next.toInt().div(3).minus(2) + total
        }
    println("part1: $fuel1") // 3362507
}

fun part2() {
    val fuel =
        inputsDay1.lines().fold(0) {
                total, next -> calculateFuel(next.toInt()) + total
        }
    // 3362507
    println("part2: $fuel")

}

fun calculateFuel(mass: Int): Int {
    var fuel = mass.div(3).minus(2)
    if (fuel.div(3).minus(2) > 0)
        fuel += calculateFuel(fuel)

    return fuel
}
//    Fuel required to launch a given module is based on its mass.
//    Specifically, to find the fuel required for a module, take its mass,
//    divide by three, round down, and subtract 2.
//
//    For example:
//        For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
//        For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
//        For a mass of 1969, the fuel required is 654.
//        For a mass of 100756, the fuel required is 33583.

//    So, for each module mass, calculate its fuel and add it to the total. Then, treat the fuel amount you just calculated as the input mass and repeat the process, continuing until a fuel requirement is zero or negative. For example:
//
//    A module of mass 14 requires 2 fuel. This fuel requires no further fuel (2 divided by 3 and rounded down is 0, which would call for a negative fuel), so the total fuel required is still just 2.
//    At first, a module of mass 1969 requires 654 fuel. Then, this fuel requires 216 more fuel (654 / 3 - 2). 216 then requires 70 more fuel, which requires 21 fuel, which requires 5 fuel, which requires no further fuel. So, the total fuel required for a module of mass 1969 is 654 + 216 + 70 + 21 + 5 = 966.
//    The fuel required by a module of mass 100756 and its fuel is: 33583 + 11192 + 3728 + 1240 + 411 + 135 + 43 + 12 + 2 = 50346.


val inputsDay1 = """113348
85199
56077
108338
88842
86765
127040
88557
87886
110849
95682
131611
79658
139439
62467
82333
79414
116672
118256
127660
59774
67990
81653
143436
101701
90571
131983
70494
86232
137759
87992
107601
141275
100261
133153
136706
84363
114771
115167
64509
97324
70627
93215
60459
145358
102741
85623
145687
106837
146764
91837
80190
114857
133985
55423
60612
63556
139326
73907
71478
95854
87886
91624
85675
141381
122392
73756
131710
99053
135684
114005
95885
75545
55703
80835
106478
74307
113562
134192
117605
138161
132905
117676
125103
147899
107373
142169
72084
68682
115345
63130
143231
72135
91780
122640
74195
84365
97015
81773
74146""".trimMargin()