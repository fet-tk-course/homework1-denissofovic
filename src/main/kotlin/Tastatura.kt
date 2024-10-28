class Tastatura(trenutnaPozicija: Pair<Int, Int>) : Instrukcija {

    val matricaDugmadi : Array<Array<Int>> = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))
    var trenutnaPozicija : Pair<Int,Int> = Pair(1,1)
        get() {
            return field
        }
        set(novaPozicija) {
            field = novaPozicija
        }

    override fun pomjeri(trenutnaPozicija: Pair<Int, Int>, instrukcija: Smjer): Pair<Int, Int> {
        var novaPozicija = matricaDugmadi[trenutnaPozicija.first][trenutnaPozicija.second]
        novaPozicija = when(instrukcija){
            Smjer.DESNO -> if(novaPozicija % 3 != 0) novaPozicija + 1 else novaPozicija
            Smjer.LIJEVO -> if((novaPozicija-1) % 3 != 0 ) novaPozicija - 1 else novaPozicija
            Smjer.GORE -> if (novaPozicija - 3 in 1..9) novaPozicija - 3 else novaPozicija
            Smjer.DOLE -> if (novaPozicija + 3 in 1..9) novaPozicija + 3 else novaPozicija
            else -> novaPozicija
        }

        return Pair((novaPozicija-1) / 3, (novaPozicija- 1) % 3)

    }


}