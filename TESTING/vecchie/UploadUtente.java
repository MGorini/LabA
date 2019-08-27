class UploadUtente implements Comparable<UploadUtente>{
	Coordinate coord;
	Date data;
	Umore u;
	boolean in_out;
	boolean log;

	/**Crea un oggetto di tipo UploadUtente tramite:
	- la Coordinata
	- la data di caricamento
	- l'umore
	- il tipo di log (IN/OUT)
	- stato registrazione (LOGIN/LOGOUT)
	*/
	public UploadUtente(boolean _in_out, boolean _log, Date data, Coordinate coord, Umore u) throws Exception{
		if(_in_out && !_log)
			throw new Exception("Dati di log non validi");

		this.coord=coord;
		this.data=data;
		this.u=u;
		this.in_out=_in_out;
		this.log=_log;
	}

	/**Restituisce il valore del ultimo accesso (IN/OUT)*/
	public boolean getINOUT(){
		return _in_out;
	}

	/**Restituisce se l'utente è iscritto o meno*/
	public boolean getLOG(){
		return log;
	}

	/**Consente di comparare due oggetti di tipo UploadUtente, 
	restituendo quale dei due upload è stato caricato prima*/
	public int compareTo(UploadUtente up){
		return up.data.compareTo(this.data);
	}
}