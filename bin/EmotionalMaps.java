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
	final String IMPORT = "import";
	final String CREATE_MAP = "create_map";

	/**Permette di scrivere sul file di testo eventuali errore, il file di testo usato è un log creato da noi*/
	public static void scriviSuLog(Exception e){
		try {
			new BufferedWriter(new FileWriter(FILE_LOG, true)).write(e.getMessage());
		}catch (Exception e){}
	}

	/** suddivido l'import dall'export*/
	public static void distinguiImportExport(String file) {
		// creo il collegamento col file
		BufferedReader br = new BufferedReader(new FileReader(file));

		// creo le variabili di supporto
		String[] tmp;
		String[] tmpDate;
		String riga;
		Date start,end;

		// scorro ogni riga del file
		while ((riga = br.readLine()) != null) {
			try {
				//distingui il comando (import, createMap) dai dati veri e propri
				tmp = riga.split("(");
				if (tmp.length == 2) {
					if (tmp[0] == IMPORT)//capisce se è import ed eseguo il comando
						importFF(tmp[0].substring(0,tmp[0].length()-1));
					else if (tmp[0] == CREATE_MAP) {//verifico se è create map ed eseguo il comando

						//creo le date dalle stringhe prima di procedere
						tmpDate = tmp[1].split("-");
						start = predisponiData(tmpDate[0]);
						end = predisponiData(tmpDate[1].substring(0,tmpDate[1].length()-1));

						//lancio il comando effettivo
						createMap(start, end);
					}
					else throw new Exception(riga + " Istruzione non riconosciuta");
				}
			} catch (Exception e) { scriviSuLog(e); }
		}
	}

	public static void importFF(String file){
		// creo il collegamento col file
		BufferedReader br = new BufferedReader(new FileReader(file));
	}

	public static String createMap(Date start, Date end) throws Exception{
		if(start.compareTo(end) > 0)
			throw new Exception("Intervallo temporale non corretto");

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