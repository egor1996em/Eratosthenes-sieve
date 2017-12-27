package Kotlin.Sieve

class Eratosfen(val lastNumberForSearch :Int){

    private val numbersRow :MutableSet<Int>

    init {
        numbersRow = setNumbersRow()
    }

    private fun setNumbersRow() :MutableSet<Int>{
        return (2..lastNumberForSearch).toMutableSet()
    }

    fun searchSimpleWords() :MutableSet<Int>{
        var divider = numbersRow.elementAt(0)
        while (Math.pow(divider.toDouble(),2.0) <= lastNumberForSearch){
            removeNumsMultipleDivider(divider)
            divider = getNextDivider(divider)
        }
        return numbersRow
    }

    private fun getNextDivider(currentDivider :Int) :Int{
        val indexOfCurrentDivider = numbersRow.indexOf(currentDivider)
        return numbersRow.elementAt(indexOfCurrentDivider + 1)
    }

    private fun removeNumsMultipleDivider(divider :Int){
        val numbersToRemove :MutableSet<Int> = mutableSetOf()

        val start = numbersRow.indexOf(divider*divider)
        val end = numbersRow.size

        (start until end)
                .filter { numbersRow.elementAt(it) % divider == 0 }
                .mapTo(numbersToRemove) { numbersRow.elementAt(it) }

        numbersRow.removeAll(numbersToRemove)
    }
}