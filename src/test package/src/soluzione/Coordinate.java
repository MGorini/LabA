package soluzione;


/**
Oggetto che descrive una locazione all'interno della mappa emozionale.*/
public class Coordinate{
	private double longitudine;
	private double latitudine;

	/**Crea un oggetto di tipo Coordinate tramite i valori
	della latitudine e della longitudine.*/
	public Coordinate(double _latitudine ,double _longitudine){
		setLatitudine(_latitudine);
		setLongitudine(_longitudine);
	}

	/**Crea un oggettto di tipo Coordinate tramite i valori
	della latitudine e della longitudine in formato stringa
	secondo i criteri prestabiliti:<br>
	latitudine,longitudine.*/
	public Coordinate(String _coordinate) throws CoordinateException{
		// Separo le due coordinate
		String[] i=_coordinate.split(",");

		// verifico che effettivamente siano due
		if(i.length!=2)	throw new CoordinateException("Formato Coordinate non valido: \"latitudine,longitudine\"");

		// Creo l'oggetto; se tutto va bene non da errore
		setLatitudine(Double.valueOf(i[0]));
		setLongitudine(Double.valueOf(i[1]));
	}

	/**Consente di Settare il valore relativo alla Latitudine.*/
	public void setLatitudine(double _latitudine){
		latitudine=_latitudine;
	}

	/**Restituisce il valore della latitudine.*/
	public double getLatitudine(){
		return latitudine;
	}

	/**Consente di Settare il valore relativo alla longitudine.*/
	public void setLongitudine(double _longitudine){
		longitudine=_longitudine;
	}

	/**Restituisce il valore della longitudine.*/
	public double getLongitudine(){
		return longitudine;
	}

	/**Restituisce la distanza fra due Coordinate.*/
	public double getDistanza(Coordinate _c){
		//Restuisce la distanza adottando il teorema di Pitagora
		double c1=_c.getLatitudine()-this.getLatitudine();
		double c2=_c.getLongitudine()-this.getLongitudine();
		return Math.sqrt(c1*c1+c2*c2);
	}

	/**Restituisce un formato stringa le coordinate
	secondo i criteri prestabiliti:<br>
	latitudine,longitudine.*/
	public String toString(){
		return getLatitudine()+","+getLongitudine();
	}
}