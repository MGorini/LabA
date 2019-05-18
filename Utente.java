import java.util.Date;
import java.util.LinkedList;

class Utente{
	// Attributi
	String codiceutente;
	LinkedList<Coordinate> c;
	LinkedList<Boolean> inout;
	LinkedList<Boolean> log;
	LinkedList<Date> date;

	/**
	Crea un oggetto di tipo utente
	*/
	public Utente(Stirng _cod, Coordinate _coord, boolean _inout, boolean _log, Date _data){
		setCodUtente(_cod);
		addCoordinata(_coord);
		addINOUT(_inout);
		addLOG(_log);
	}


	/**
	Consente di aggiungere le informazioni relative ad un evento
	*/
	public void AggiungiInfo(Coordinate _coord, boolean _inout, boolean _log, Date _data){
		// Verifico che la Coordinata sia valida
		// Verifico che la data non sia nulla
		// Verifico che la data sia valida
		// Se così non è esco dalla funzione ignorando i dati passati
		if(_coord==NULL || _data==NULL ||)
			return ;
		
		// Verificato che le informazioni sono valide procedo con l'inserimento
		addCoordinata(_coord);
		addINOUT(_inout);
		addLOG(_log);
		addData(_data);
	}

	/**
	Permette di inserire il codice dell'utente
	La funzione è privata poichè una volta inserito il codice, esso non deve essere più cambiato
	*/
	private void setCodUtente(Stirng _codutente){
		// Verifico che il codice utente sia valido
		if(_cod==NULL)
			throw new Exception();
		codiceutente=_codutente;
	}

	/**
	Restituisce il codice del utente (stringa alfanumerica)
	*/
	public String getCodiceUtente(){
		return codutente;
	}

	/**
	Permette di aggiungere una nuova coordinata alla lista delle Coordinate del utente
	*/
	private void addCoordinata(Coordinate _coord){
		c.add(_coord);
	}

	/**
	Consente di aggiungere l'Iscrizione o la Disiscrizione
	*/
	private void addINOUT(boolean b){
		// trasformo la varibile booleana in un oggetto affinchè possa essere inserito
		// all'interno della lista
		inout.add(new Boolean(b));
	}

	/**
	Consente di aggiungere un nuovo LOGIN o LOGOUT
	*/
	private void addLOG(boolean _log){
		// trasformo la varibile booleana in un oggetto affinchè possa essere inserito
		// all'interno della lista
		log.add(new Boolean(_log));
	}

	/**
	Permette di aggiungere una nuova data nella lista delle date
	*/
	private void addData(Date _data){
		date.add(_data);
	}


	/**
	Restituisce una stringa contenente: 
	- Data
	- Coordinata
	- Iscrizione/Disiscrizione
	- Login/Logout

	Di tutte le volte che l'utente ha eseguito un operazione con l'app
	*/
	public String toString(){
		// Inizializzo il contatore
		int count=c.size()+1;

		// Creo un oggetto per la concatenazione delle informazioni
		StringBuilder sb=new StringBuilder();

		// Aggiungo, quasi come titolo, il codice del utente
		sb.append("Utente: "+this.getCodiceUtente());

		// Scorro le varie liste in modo da prendere tutte le informazioni memorizzate
		// Va in ordine decrescente ed aogni volta eseguito il ciclo, il contatore viene decrementato
		while(count--!=0)
		{
			// Inserisco una barretta divisoria, per ogni inserimento
			sb.append("------------------");
			sb.append("Data: "+date.get(i));
			sb.append("Coordinate: "+c.get(i));
			sb.append("IN/OUT: "+inout.get(i));
			sb.append("LOGIN/LOGOUT: "+log.get(i)+"\n");
		}

		return sb.toString();
	}
}