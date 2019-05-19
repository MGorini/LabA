import java.io.FileReader;
import java.io.BufferedReader;
import java.util.TreeMap;

public class EmotionalMaps{

	public static void String(String[] args){
		// Creo una TreeMap di utenti
		// Il campo Stringa indica il CodiceUtente
		TreeMap<String, Utente> listaUtenti=new TreeMap<>();
		String file="";

		AggiungiUtenti(listaUtenti, file);

	}

	public static void AggiungiUtenti(TreeMap<String, Utente> listaUtenti, String file){
		// Creo il buffer per leggere il file
		BufferedReader br=new BufferedReader(new FileReader(file));
		// Creo una stringa che mi conterrà, una alla volta, ogni riga del file
		String riga;

		// Creo un array pe memorizzare i dati, di ogni stringa
		// temporaneamente
		String[] tmp;

		// Scorro il file fino alla fine
		while((riga=br.readLine())!=NULL){

			// Estraggo da una stringa i vari campi, poichè separati da uno spazio
			tmp=riga.split(" ");

			// Verifico che siano effettivamente 6 i campi
			if(tmp.lenght==6){

				// Verifico se l'Utente è gia presente o sia nuovo
				// Se è nuovo lo inserisco
				if(!listaUtenti.containsKey(tmp[3])){

					// Se avviene un Errore nell'Inserimento dell'Utente i dati non sono validi
					// Dunque non lo inserisco; le garbage collections penseranno poi ad eliminare i dati
					try{
						listaUtenti.put("Cod Utente",new Utente());
					}
					catch(Exception){}
				}
				else // Se invece esiste
				{

				}
			}
		}
	}
	

}