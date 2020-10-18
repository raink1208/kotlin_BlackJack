package blackJack.utils

import java.util.*
import kotlin.NoSuchElementException

class Deck {
    private val cards = LinkedList<Card>()
    init {
        for (num in 1..13) {
            for (mark in 0..3) {
                cards.add(Card(num, Marks.values()[mark]))
            }
        }
    }

    fun draw(): Card {
        if (cards.size <= 0) throw NoSuchElementException("カードがありません")
        cards.shuffle()
        return cards.pop()
    }
}