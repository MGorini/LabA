/*
*	LONGOBARDI DANIELE
*
* 	GORINI MARCO
*
*/

package emotionalmaps;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.HashMap;

import java.util.Date;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.util.NavigableSet;

class EmotionalMaps{
	private static LinkedList<POI> l_POI;
	private static TreeMap<String, LinkedList<Dati>> collezione;
	final static String FILE_LOG = "./Log.txt";
	final static String IMPORT = "import";
	final static String CREATE_MAP = "create_map";
	final static int UMORI_TOTALI = 5;

	/**Inizializza il file di Log*/
	public static void initFile(){
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_LOG));
			bw.write("");
			bw.close();
		}catch (Exception ex){}
	}

	/**Permette di scrivere sul file di testo eventuali errore, il file di testo usato è un log creato da noi*/
	public static void scriviSuLog(Exception e){
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(FILE_LOG, true));
			bw.write(e.getMessage());
			bw.close();
		}catch (Exception ex){}
	}

	/** suddivido l'import dall'export*/
	public static void distinguiImportExport(String file) {
		try {
			// creo il collegamento col file
			BufferedReader br = new BufferedReader(new FileReader(file));

			// creo le variabili di supporto
			String[] tmpDate;
			String riga;
			Date start, end;

			// scorro ogni riga del file
			while ((riga = br.readLine()) != null) {
				try {
					//distingui il comando (import, createMap) dai dati veri e propri
					String[] tmp = riga.split("\\(");
					if (tmp.length == 2) {
						if (tmp[0].compareTo(IMPORT)==0){//capisce se è import ed eseguo il comando
							importFF(tmp[1].substring(0, tmp[1].length() - 1));
						}
						else if (tmp[0].compareTo(CREATE_MAP)==0) {//verifico se è create map ed eseguo il comando
							//creo le date dalle stringhe prima di procedere
							tmpDate = tmp[1].split("\\-");
							start = Dati.predisponiData(tmpDate[0]);
							end = Dati.predisponiData(tmpDate[1].substring(0, tmpDate[1].length() - 1));

							//lancio il comando effettivo
							createMap(start, end);
						} else throw new Exception(riga + " Istruzione non riconosciuta");
					}
				} catch (Exception e) {
					scriviSuLog(e);
				}
			}
		}catch (Exception ex){
			scriviSuLog(ex);
		}
	}

	/**Funzione che mi inserisce i valori dell'import (dati.txt) all'interno della treeMap*/
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

	/**Genera le due mappe emozionali richieste*/
	public static void createMap(Date start, Date end) throws Exception{

		if(start.compareTo(end) > 0)
			throw new Exception("Intervallo temporale non corretto");

		stampaAVideo("Mappa Emozionale utenti attivi");
		CreateActiveUsersMap(start, end);

		stampaAVideo("Mappa Emozionale di tutti gli utenti");
		CreateCompleteMap(start, end);
	}

	/**Stampa, sullo standard output, la "mappa emozionale richiesta"*/
	private static void stampaAVideo(String s){
		System.out.println(s);
	}

	/**Conteggia lo stato emozionale*/
	private static void Conteggia(Dati d, HashMap<POI, int[]> calcolo){
		// ottengo i valori relativi al POI piu' vicino
		int[] tmp = calcolo.get(l_POI.get(getNearestPoi(d.getCoordinate())));

		// conteggio l'umore
		switch (d.getUmore()) {
			case A:
				tmp[0]++;
				break;
			case F:
				tmp[1]++;
				break;
			case S:
				tmp[2]++;
				break;
			case T:
				tmp[3]++;
				break;
			case N:
				tmp[4]++;
				break;
			default:
				break;
		}
	}

	/**Inizializza La HashMap per poterci lavorare*/
	private static HashMap<POI, int[]> InizializzaCalcolo(){
		HashMap<POI, int[]> calcolo = new HashMap<POI, int[]>();
		int[] count;

		// inizializzo i contatori
		for(POI p: l_POI) {
			count = new int[UMORI_TOTALI];
			for (int i = 0; i < UMORI_TOTALI; i++)
				count[i] = 0;

			calcolo.put(p, count);
		}
		return calcolo;
	}

	/**Crea la mappa emozionale di tutti gli utenti*/
	private static void CreateCompleteMap(Date start, Date end){
		HashMap<POI, int[]> calcolo = InizializzaCalcolo();

		NavigableSet<String> ns = collezione.navigableKeySet();
		LinkedList<Dati> tmp;

		// scorro l'id utente
		for(String k : ns){
			// ottengo i valori per ogni utente
			tmp=collezione.get(k);
			// scorro i vari valori dell'utente
 			for(Dati d : tmp){
 				//verifico che la data sia compresa e la conteggio
				if(d.getData().compareTo(start) >= 0 && d.getData().compareTo(end) <= 0) {
					Conteggia(d, calcolo);
				}
			}
		}

		createMapString(calcolo);
	}

	/**Crea la mappa emozionale dei soli utenti attivi*/
	private static void CreateActiveUsersMap(Date start, Date end){
		HashMap<POI, int[]> calcolo = InizializzaCalcolo();

		NavigableSet<String> ns = collezione.navigableKeySet();
		LinkedList<Dati> tmp;

		// scorro l'id utente
		for(String k : ns){
			// ottengo i valori per ogni utente
			tmp=collezione.get(k);
			// scorro i vari valori dell'utente
			for(Dati d : tmp){
				//verifico che la data sia compresa e la conteggio
				if(d.getData().compareTo(start) >= 0 && d.getData().compareTo(end) <= 0) {
					if(d.getLOGINLOGOUT() && d.getINOUT()){
						Conteggia(d, calcolo);
					}
				}
			}
		}

		createMapString(calcolo);
	}

	/**Costruisce le Stringhe relative alle mappe emozionali*/
	private static void createMapString(HashMap<POI, int[]> calcolo){

		StringBuilder sb;
		for(POI p: l_POI)
		{
			sb = new StringBuilder();
			int[] tmp = calcolo.get(p);
				//System.out.println(tmp[0]);

			// ottengo il totale delle emozioni
			double totale = 0;
			for(int j=0; j< tmp.length; j++)
				totale += tmp[j];
			if(totale==0) totale = 1;

			// genero la stringa con le percentuali
			sb.append(p+" ");
			sb.append((tmp[0]/totale)*100+" A,");
			sb.append((tmp[1]/totale)*100+" F,");
			sb.append((tmp[2]/totale)*100+" S,");
			sb.append((tmp[3]/totale)*100+" T,");
			sb.append((tmp[4]/totale)*100+" N\n");

			stampaAVideo(sb.toString());
		}
	}

	/**Restituisce l'index del POI piu' vicino*/
	private static int getNearestPoi(Coordinate c){
		int position = 0;
		double distance_position, distance_next;
		Coordinate cpoi_position, cpoi_next;

		for(int i=0; i<l_POI.size();i++){
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

	public static void main(String[] args) throws Exception{
		// verifico che vi sia il file in input
		if(args.length == 0){
			// segnalo il problema
			scriviSuLog(new Exception("Impossibile eseguire il programma in assenza del file contenente le istruzioni"));
			// esco dal programma
			return ;
		}
	
		//inzializzo la treeMap
		collezione = new TreeMap<String, LinkedList<Dati>>();

		// inizializzo il file di log
		initFile();

		// carico i POI in una lista
		l_POI=POI.caricaPOI("POI.txt");

		distinguiImportExport(args[0]);
	}

}