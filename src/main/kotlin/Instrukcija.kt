interface Instrukcija {
    fun pomjeri(trenutnaPozicija:Pair<Int,Int>, instrukcija:Smjer) : Pair<Int,Int>
}