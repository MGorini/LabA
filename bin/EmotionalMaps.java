import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Date;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

class EmotionalMaps{
	LinkedList<POI> l_POI;
	TreeMap<String, LinkedList<Dati>>;
	final String FILE_LOG = "Log.txt";

	/**Permette di scrivere sul file di testo eventuali errore, il file di testo usato è un log creato da noi*/
	public static void scriviSuLog(Exception e){
		try {
			new BufferedWriter(new FileWriter(FILE_LOG, true)).write(e.getMessage());
		}catch (Exception e){}
	}

	public static void distinguiImportExport(String file){
		// suddivido l'import dall'export

	}

	public static void importFF(String file){

	}

	public static String createMap(Date inizio, Date fine){

	}

	/**Stampa, sullo standard output, la "mappa emozionale richiesta"*/
	private static void stampaAVideo(String s){
		System.out.println(s);
	}

	public static void main(String[] args){
		// carico i POI in una lista
		l_POI=POI.caricaPOI("POI.txt");
		distinguiImportExport(args[0]);
	}
}