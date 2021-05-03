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
        var aceCount = 0

        for (card in hands) {
            var num = card.number
            if (num > 10) num = 10
            if (num == 1) aceCount++
                else score += num
        }

        if (aceCount == 0) return score

        var aceScore = 11 + aceCount - 1
        if (aceScore + score > 21) aceScore = aceCount

        return score + aceScore
    }

    fun isBurst() = getScore() > 21
}