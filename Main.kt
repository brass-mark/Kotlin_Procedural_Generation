
// Global Variables go here

val startBounds = (0..100)
const val neighbourBounds = 10

val xBounds = (0..9)
val yBounds = (0..9)

val mapPoints: MutableList<MutableList<Int>> =
    mutableListOf()

fun main() {

    // Populates the area of the 2D list with values 0 so it can be rewritten after
    repeat(yBounds.last + 1) {
        val addToMutableList: MutableList<Int> = mutableListOf()
        repeat(xBounds.last + 1) {
            addToMutableList.add(0)
        }

        mapPoints.add(addToMutableList)
    }

    for (yIndex in yBounds) {
        for (xIndex in yBounds) {
            mapPoints[yIndex][xIndex] = assignRandom(y=yIndex, x=xIndex)
        }
    }

    for (y in mapPoints) { println(y) }
}

fun assignRandom(y: Int, x: Int): Int {
    val xNeighbour: Int? = if (x != xBounds.first) mapPoints[y][x-1] else null
    val yNeighbour: Int? = if (y != yBounds.first) mapPoints[y-1][x] else null

    val upper: Int
    val lower: Int

    // Initializes the lowest value + 10 as the upper limit and the highest value - 10 as the lower limit

    // Uncomment for debugging
    if (yNeighbour != null && xNeighbour != null) {
        // println(1)
        upper = if (yNeighbour > xNeighbour) xNeighbour + neighbourBounds else yNeighbour + neighbourBounds
        lower = if (yNeighbour > xNeighbour) yNeighbour - neighbourBounds else xNeighbour - neighbourBounds

    } else if (yNeighbour != null) {
        // println(2)
        upper = yNeighbour + neighbourBounds
        lower = yNeighbour - neighbourBounds

    } else if (xNeighbour != null) {
        // println(3)
        upper = xNeighbour + neighbourBounds
        lower = xNeighbour - neighbourBounds

    } else {
        // println(4)
        upper = startBounds.last
        lower = startBounds.first

    }

    return (lower..upper).random()
}
