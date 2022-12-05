package xyz.applebox.kotlin.solid

abstract class Member(open val name: String) {
    abstract fun watchYoutube()
}

interface PremiumOption {
    fun listenMusic()
}

class PremiumMember(name: String) : Member(name), PremiumOption {
    override fun watchYoutube() {
        println("광고없이 유튜브 시청하기")
    }

    override fun listenMusic() {
        println("음악 듣기")
    }
}
class FreeMember(name: String) : Member(name) {
    override fun watchYoutube() {
        println("광고 포함 유튜브 시청하기")
    }
}