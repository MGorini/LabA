import java.util.Date;
import java.util.LinkedList;

class Utente {
	// Attributi
	LinkedList<Coordinate> c;
	LinkedList<Boolean> inout;
	LinkedList<Boolean> log;
	LinkedList<Date> date;

	/**
	Crea un oggetto di tipo utente
	*/
	public Utente(Coordinate _coord, String _inout, String _log, Date _data){
		// Ovviamente un nuovo utente non può aver eseguito il LOGOUT o la disiscrizione
		// sennò non sarebbe un nuovo utente
		// Verifico i campi, data compresa, e proseguo
		if(_inout!="IN" || _log!="LOGIN")
			throw new Exception();

		// Istanzio le liste
		date=new LinkedList<Date>();
		inout=new LinkedList<Boolean>();
		log=new LinkedList<Boolean>();
		c=new LinkedList<Coordinate>();

		// Assegno i primi valori
		addCoordinata(_coord);
		addData(_data);
		inout.add(true);
		log.add(true);
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
	private void addINOUT(String b){
		// trasformo la varibile booleana in un oggetto affinchè possa essere inserito
		// all'interno della lista
		inout.add(new Boolean(b));
	}

	/**
	Consente di aggiungere un nuovo LOGIN o LOGOUT
	*/
	private void addLOG(Stirng _log){
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