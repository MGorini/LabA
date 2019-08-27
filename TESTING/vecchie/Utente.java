class Utente{
	//private int numinserimenti=0;
	//private TreeMap<int, UploadUtente> t;
	private Stirng IDUtente;

	/**Crea un oggetto di tipo Utente*/
	public Utente(String _IDUtente) throws UtenteException{
		setIDUtente(_IDUtente);
	}

	/**Setta l'ID dell'utente, valore univoco*/
	public void setIDUtente(String _IDUtente) throws UtenteException{
		if(_IDUtente==null || _IDUtente.length!=5)
			throw new UtenteException("IDUtente non valido");
		IDUtente=_IDUtente;
	}

	/**Restitusce l'ID dell'utente in questione*/
	public String getIDUtente(){
		return IDUtente;
	}

	/**Restituisce una Stringa*/
	public String toString(){
		return getIDUtente();
	}
}