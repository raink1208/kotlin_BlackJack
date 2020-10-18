package blackJack

import blackJack.utils.Deck

fun main(args: Array<String>) {
    print("名前を入力してください: ")
    val name = readLine()!!.let {
        if (it == "") "ユーザー" else it
    }

    val player = Player(name)
    val dealer = Player("ディーラー")

    val deck = Deck()

    println("ゲームを開始します")

    //プレイヤー　最初のターン
    player.addCard(deck.draw())
    player.addCard(deck.draw())

    Thread.sleep(500)

    dealer.addCard(deck.draw())
    dealer.addCard(deck.draw(), false)

    while (true) { //プレイヤーのターン
        if (player.isBurst()) {
            println("\n${player.name}はバーストしました")
            break
        }
        println("\n${player.name}の今のスコアは${player.getScore()}です")
        print("もう一枚カードを引きますか(yes/no): ")

        when (readLine()) {
            "y","Y","yes","Yes" -> player.addCard(deck.draw())
            "n","N","no","No" -> break
            else -> println("yesかnoで答えてください")
        }
        Thread.sleep(500)
    }

    Thread.sleep(1000)

    println("\n${dealer.name}の2枚目のカードは${dealer.hands[1].message}でした")

    while (dealer.getScore() <= 17 || player.getScore() > dealer.getScore()) {
        dealer.addCard(deck.draw())
        println("${dealer.name}のスコアは${dealer.getScore()}です")
        Thread.sleep(500)
        if (dealer.isBurst()) {
            println("${dealer.name}はバーストしました")
            break
        }
    }

    println("\n============リザルト============")

    println(player.name +"のスコアは" + player.getScore() + "です")
    println(dealer.name +"のスコアは" + dealer.getScore() + "です")

    println()

    when {
        (player.isBurst()) -> println("${player.name}の負けです")
        (dealer.isBurst()) -> println("${player.name}の勝ちです")
        (player.getScore() == dealer.getScore()) -> println("引き分けです")
        (player.getScore() > dealer.getScore()) -> println("${player.name}の勝ちです")
        (player.getScore() < dealer.getScore()) -> println("${player.name}の負けです")
    }
}

