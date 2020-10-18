package blackJack.utils

class Card(val number: Int, mark:Marks) {
    val message = "${mark}の$number"
}