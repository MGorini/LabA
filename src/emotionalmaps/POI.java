package emotionalmaps;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;

/**Oggeto che descrive un POI (Point Of Interest = Punto di interesse).*/
public class POI{
	public Coordinate coord;
	String nome;

	/**Crea un oggetto di tipo POI richiedendo il nome e la sua locazione
	espressa per mezzo delle Coordinate.*/
	public POI(String _nome, Coordinate _coord) throws POIException{
		coord=_coord;
		setNome(_nome);
	}

	/**Crea un oggetto di tipo POI richiedendo il nome e la sua locazione
	espressa per mezzo delle Coordinate, tramite una stringa
	strutturata secondo i criteri prestabiliti:<br>
	coordinate-nome.*/
	public POI(String _info) throws Exception{
		// Divido le informazioni
		String[] i=_info.split("-");

		// Verifico che siano veritiere
		if(i.length!=2) throw new POIException("Formato dei dati non valido");

		// Assegno i valori trovati
		coord=new Coordinate(i[0]);
		setNome(i[1]);
	}

	/**Setta il nome relativo al POI.*/
	public void setNome(String _nome) throws POIException{
		if(_nome==null) throw new POIException("Nome del POI non puo' essere null");
		nome=_nome;
	}

	/**Restituisce il nome del POI.*/
	public String getNome(){
		return nome;
	}

	/**Restituisce le coordinate relative al POI*/
	public Coordinate getCoordinate() {
		return coord;
	}

	/**Consente di Caricare i POI da File, restituendo una Lista di POI.*/
	public static LinkedList<POI> caricaPOI(String _file){
		// Creo la lista dei POI
		LinkedList<POI> l=new LinkedList<POI>();

		try{

			// Creo il buffer per la lettura da file
			BufferedReader br=new BufferedReader(new FileReader(_file));

			// Creo una stringa che mi conterrà la riga del file
			String riga;

			// Scorro tutto il file, riga per riga
			while((riga=br.readLine())!=null)
			{
				try{ // Provo a caricare l'oggetto nella lista
					l.add(new POI(riga));
				}catch(Exception e){} // se non va ignoro il POI in questione
			}

			return l;
		}
		catch(Exception e)
		// se ho dei problemi col file restituisco una lista vuota
		{return new LinkedList<POI>();}
	}


	/**Restituisce le informazioni del POI in fomato stringa.*/
	public String toString(){
		return coord.toString()+"-"+getNome();
	}
}