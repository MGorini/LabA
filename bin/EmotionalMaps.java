import java.util.LinkedList;
import java.util.TreeMap;
import java.util.Date;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
Classe principale per la gestione dell'applicazione: Emotional Maps*/
class EmotionalMaps{
	LinkedList<POI> l_POI;
	TreeMap<String, LinkedList<Dati>> collezione;
	final String FILE_LOG = "Log.txt";
	final String IMPORT = "import";
	final String CREATE_MAP = "create_map";

	/**Permette di scrivere sul file di testo eventuali errore, il file di testo usato è un log creato da noi.*/
	public static void scriviSuLog(Exception e){
		try {
			new BufferedWriter(new FileWriter(FILE_LOG, true)).write(e.getMessage());
		}catch (Exception e){}
	}

	/** suddivide l'import dall'export ed esegue le operazioni richieste.<br>
	In caso di istruzione non riconosciuta ignora l'istruzione.*/
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

	/**Funzione che mi inserisce i valori dell'import (dati.txt) all'interno della mappa dei valori.*/
	public static void importFF(String file){
		try {
			// creo il collegamento col file
			BufferedReader br = new BufferedReader(new FileReader(file));

			// creo delle variabili di supporto
			String tmp;
			String[] info;

			// scorro le righe del file fino alla fine
			while ((tmp=br.readLine()) != null){
				try{
					//Suddivido la stringa in sottostringhe che rappresentano i dati
					info = tmp.split(" ");

					// creo un oggetto di tipo dati
					Dati d = new Dati(info[0], info[1], info[2], Umore.valueOf(info[5]), new Coordinate(info[4]));

					//se la chiave della treeMap (info[3]) è già presente: aggiungo solo i dati
					if(collezione.containsKey(info[3])){
						collezione.get(info[3]).add(d);
					}
					//se la chiave della treeMap (info[3]) non è presente: creo la voce e aggiungo i dati
					else{
						collezione.put(info[3], new LinkedList<Dati>());
						collezione.get(info[3]).add(d);
					}
				}
				catch (Exception e){
					//qualsiasi errore relativo ai dati errati viene riportato sul file di log
					scriviSuLog(e);
				}
			}

		}catch(Exception e) {
			//Qualsiasi errore riguardante l'apertura o lo scorrimento del file lo ri riporta sul file di log
			scriviSuLog(e);
		}
	}

	/**Genera le mappe emozionali richieste dal progetto.*/
	public static String createMap(Date start, Date end) throws Exception{
		if(start.compareTo(end) > 0)
			throw new Exception("Intervallo temporale non corretto");
		CreateActiveUsersMap(start, end);
		CreateCompleteMap(start, end);
	}

	/**Stampa, sullo standard output, la "mappa emozionale richiesta".<br>
	La funzione viene richiamata ed andra' riscritta in caso di un implementazione a livello di applicazione mobile.*/
	private static void stampaAVideo(String s){
		System.out.println(s);
	}

	/**Genera la mappa emozionale di tutti gli utenti.*/
	private static String CreateCompleteMap(date start, date end){
		//-----------------------HashMap<POI, array di double>
		NavigableSet<String> ns = collezione.navigableKeySet();
		LinkedList<Dati> tmp;
		for(String k : ns){
			tmp=collezione.get(k);
 			for(Dati d : tmp){
 				//verifico che la data sia compresa
				if(d.getData().compareTo(start) >= 0 && d.getData().compareTo(end) <= 0) {

				}
			}
		}
	}

	/**Genera la mappa emozionale dei soli utenti attivi.*/
	private static String CreateCompleteMap(date start, date end){

	}

	/**Calcola il POI piu' vicino al caricamento dell'utente.*/
	private static int getNearestPoi(Coordinate c){
		int position = 1;
		double distance_position, distance_next;
		Coordinate cpoi_position, cpoi_next;

		for(int i=2; i<l_POI.size();i++){
			// assegno le coordinate dei POI
			cpoi_position = l_POI.get(position).coord;
			cpoi_next = l_POI.get(i).coord;

			// calcolo le distanze
			distance_position = cpoi_position.getDistanza(c);
			distance_next = cpoi_next.getDistanza(c);

			if(distance_position > distance_next)
				position=i;
		}
		return position;
	}

	public static void main(String[] args){
		//inzializzo la treeMap
		collezione = new TreeMap<String, LinkedList<Dati>>();

		// carico i POI in una lista
		l_POI=POI.caricaPOI("POI.txt");
		distinguiImportExport(args[0]);
	}
}