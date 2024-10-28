import java.nio.file.Files
import java.nio.file.Paths
class Dekoder{

    fun dekodiraj(listaInstrukcija: List<String>, tastatura: Tastatura) :Int{
        var kod = 0
        for(nizInstrukcija in listaInstrukcija){
            for(instrukcija in nizInstrukcija){
                val smjer = when (instrukcija) {
                    '^' -> Smjer.GORE
                    'v' -> Smjer.DOLE
                    '<' -> Smjer.LIJEVO
                    '>' -> Smjer.DESNO
                    else -> continue
                }
                tastatura.trenutnaPozicija = tastatura.pomjeri(tastatura.trenutnaPozicija,smjer)
            }
            kod = kod * 10 + tastatura.matricaDugmadi[tastatura.trenutnaPozicija.first][tastatura.trenutnaPozicija.second]
        }

        return  kod;
    }

    fun dekodiraj(putDoFajla : String, tastatura: Tastatura) : Int{
        try{
            val listaInstrukcija = Files.readAllLines(Paths.get(putDoFajla))
            return dekodiraj(listaInstrukcija, tastatura)

        }catch (e : Exception){
            println("Desila se greška ${e.message}")

        }

        return 0

    }

}