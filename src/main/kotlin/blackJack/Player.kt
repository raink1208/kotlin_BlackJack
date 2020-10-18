package blackJack

import blackJack.utils.Card

class Player(val name:String) {
    val hands = arrayListOf<Card>()

    fun addCard(card: Card,msg: Boolean = true) {
        hands.add(card)

        if (msg) {
            println("${name}は${card.message}を引いた")
        } else {
            println("カードはふせられています")
        }
    }

    fun getScore():Int {
        var score = 0
        for (card in hands) {
            score += if (card.number >= 10) 10 else card.number
        }
        return score
    }

    fun isBurst() = getScore() > 21
}