class Coordinate{
	// Attributi
	double latidutine;
	double longitudine;

	/**
	Costruisce una nuova coordinata specificando i valori di longitudine e latitudine
	*/
	public Coordinate(double _latitudine, double _longitudine){
		setLatitudine(_latitudine);
		setLatitudine(_longitudine);
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



	public void toString(){
		StringBuilder sb=new StringBuilder();

		return sb.toString();
	}

}