import java.nio.file.Files
import java.nio.file.Paths
class Dekoder{

    fun dekodiraj(listaInstrukcija: List<String>, tastatura: Tastatura) :Int{
        var kod = 0
        for(nizInstrukcija in listaInstrukcija){
            for(instrukcija in nizInstrukcija){
                tastatura.trenutnaPozicija = tastatura.pomjeri(tastatura.trenutnaPozicija, instrukcija)
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