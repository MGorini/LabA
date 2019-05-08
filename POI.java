class POI{
	// Attributi
	Coordinate c;
	String nome;
	List<Utente> recensioni;

	/**
	Costruisce un nuovo Punto di Interesse specificando il nome e la locazione, espressa in Coordinate
	*/
	public POI(String _nome, Coordinate _coordinate){
		setNome(_nome);
		if(_coordinate==null)
			throw new Exception();
		c=_coordinate;
		recensioni=new List<Utente>();
	}

	/**
	Setta il nome relativo a un Punto di Interesse
	*/
	public void setNome(String _nome){
		if(_nome==null)
			throw new Exception();
		nome=_nome;
	}

	/**
	Restituisce il nome relativo a un Punto di Interesse
	*/
	public String getNome(){
		if(nome==null)
			throw new Exception();
		return nome;
	}


	/**
	Permette di aggiungere una recensione di un utente ad un determinato Punto di Interesse
	*/
	public void AggiungiRecensione(Utente u){
		if(u==null)
			throw new Exception();
		recensioni.add(u);
	}


	public String create_map(String data){
		return "";
	}	

}