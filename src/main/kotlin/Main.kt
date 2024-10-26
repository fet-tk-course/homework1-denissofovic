fun main() {

    val pocetnaPozicija = Pair(1,1) // Pocetna pozicija na broju 5
    val tastatura = Tastatura(pocetnaPozicija)
    val dekoder = Dekoder()
    val PATH = "" //Ovdje unesite putanju do tekstualnog fajla sa instrukcijama

    println("Sigurnosni kod je: ${dekoder.dekodiraj(PATH, tastatura)}")

}