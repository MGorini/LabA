class Coordinate{
	// Attributi
	double latidutine;
	double longitudine;

	/**
	Costruisce una nuova coordinata specificando i valori di longitudine e latitudine
	in una sringa, divisi da una virgola
	*/
	public Coordinate(String _coord){
		String[] tmp=_coord.split(",");
		if(tmp!=2)
			throw new Exception();

		// Converto le Stirnghe in double e le passo come parametri 
		setLatitudine(Double.doubleValue(tmp[0]));
		setLongitudine(Double.doubleValue(tmp[1]));
	}

	/**
	Setta il valore della lititudine relativa alla coordinata
	*/
	public void setLatitudine(double _latitudine){
		latidutine=_latitudine;
	}
	/**
	Restituisce il valore della latitudine relativa alla coordinata
	*/
	public double getLatitudine(){
		return latidutine;
	}

	/**
	Setta il valore della longitudine relativa alla coordinata
	*/
	public void setLongitudine(double _longitudine){
		longitudine=_longitudine;
	}
	/**
	Restituisce il valore della longitudine relativa alla coordinata
	*/
	public double getLongitudine(){
		return longitudine;
	}


	/**
	Restituisce la distanza fra la Coordinata corrente ed un altra Cordinata, sfruttando il teorema di Pitagora
	*/
	public double getDistanza(Coordinate _coord){
		// Verifico che l'oggetto passato non sia nullo
		if(_coord==NULL)
			throw new Exception();
		
		// Calcolo la distanza
		return 	Math.sqrt((_coord.getLongitudine()-this.getLongitudine())*(_coord.getLongitudine()-this.getLongitudine())+
				(_coord.getLatitudine()-this.getLatitudine())*(_coord.getLatitudine()-this.getLatitudine()));

	}
	/**
	Restituisce la distanza fra la Coordinata corrente ed un punto specificato tramite la latitudine e la longitudine, sfruttando il teorema di Pitagora
	*/
	public double getDistanza(double _latitudine, double _longitudine){
		// Calcolo la distanza
		return 	Math.sqrt((_longitudine-this.getLongitudine())*(_longitudine*this.getLongitudine())+
				(_latitudine-this.getLatitudine())*(_latitudine-this.getLatitudine()));
	}

	/**
	Restituisce la distanza fra due coordinate, sfruttando il teorema di Pitagora
	*/
	public static double getDistanza(Coordinate _coord1, Coordinate _coord2){
		// Verifico che gli oggetti passati non siano nulli
		if(_coord1==NULL || _coord2==NULL)
			throw new Exception();

		// Calcolo la distanza
		return 	Math.sqrt((_coord1.getLongitudine()-_coord2.getLongitudine())*(_coord1.getLongitudine()-_coord2.getLongitudine())+
				(_coord1.getLatitudine()-_coord2.getLatitudine())*(_coord1.getLatitudine()-_coord2.getLatitudine()));

	}


	public void toString(){
		StringBuilder sb=new StringBuilder();
		
		return sb.toString();
	}

}