package models

class Board(setOfLiveLocations: List<Location>){
    private var setOfLiveCells : MutableSet<Location> = mutableSetOf()

    init{
        setOfLiveCells = setOfLiveLocations.toMutableSet()
    }

    fun startGame(iterations: Long): List<Location> {
        for(iteration in 0 until iterations){
            val newSetOfLiveCells : MutableSet<Location> = mutableSetOf()
            val currentNeighbourLiveCount = mutableMapOf<Location, Long>()
            setOfLiveCells.forEach{
                updateNeighboursLiveCount(it, currentNeighbourLiveCount)
            }

            currentNeighbourLiveCount.forEach { (location, liveCellCount)->
                if(liveCellCount == 3L ||
                    (liveCellCount == 2L && isCellAlive(location.row, location.column))){
                    newSetOfLiveCells.add(location)
                }
            }

            setOfLiveCells = newSetOfLiveCells
        }

        return setOfLiveCells.toList()
    }

    private fun isCellAlive(row: Long, column: Long): Boolean{
        return setOfLiveCells.contains(Location(row, column))
    }

    private fun updateNeighboursLiveCount(location: Location, currentNeighbourLiveCount : MutableMap<Location, Long>) {
        val offsets = listOf(Pair(-1, -1),
            Pair(-1, 0),
            Pair(-1, 1),
            Pair(0, -1),
            Pair(0, 1),
            Pair(1, -1),
            Pair(1, 0),
            Pair(1, 1))

        for(offset in offsets){
            val k = location.row + offset.first
            val l = location.column + offset.second

            if(0<=k && 0<=l){
                currentNeighbourLiveCount.putIfAbsent(Location(k, l), 0L)
                currentNeighbourLiveCount[Location(k, l)] = currentNeighbourLiveCount[Location(k, l)]!!+1L
            }
        }
    }
}