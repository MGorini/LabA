import java.util.Date;
import java.util.Calendar;

class Dati{
	// ATTRIBUTI
	private boolean inout;
	private boolean loginlogout;
	private String data;
	public Coordinate c;
	public Umore u;

	/**Crea un oggetto di tipo Dati*/
	public Dati(String inout, String loginlogout, String data, Umore u, Coordinate c) throws DatiException{
		this.c=c;
		this.u=u;
		setINOUT(inout);
		setLOGINLOGOUT(loginlogout);
		if(!getINOUT() && getLOGINLOGOUT())
			throw new DatiException("Impossibile eseguire un LOGIN senza essere iscritti");
		setData(data);
	}

	/**
	Consente di settare lo stato di registrazione
	Solleva un eccezzione se il dato non è valido 
	*/
	public void setINOUT(String inout) throws DatiException{
		if(inout=="IN")
			this.inout=true;
		else
		{
			if(inout=="OUT")
				this.inout=false;
			else
				throw new DatiException("Dati di IN/OUT non validi");
		}
	}

	/**
	Restituisce lo stato di registrazione
	*/
	public boolean getINOUT(){
		return inout;
	}

	/**
	Consente di settare lo stato di LOG
	Solleva un eccezzione se il dato non è valido 
	*/
	public void setLOGINLOGOUT(String loginlogout) throws DatiException{
		if(loginlogout=="LOGIN")
			this.loginlogout=true;
		else
		{
			if(loginlogout=="LOGOUT")
				this.loginlogout=false;
			else
				throw new DatiException("Dati di LOGIN/LOGOUT non validi");
		}
	}

	/**
	Restituisce lo stato di LOG
	*/
	public boolean getLOGINLOGOUT(){
		return loginlogout;
	}

	/**Verifica che la data sia valida*/
	public static boolean verificaData(int year, int mounth, int day){
		// Creo il calendario
		GregorianCalendar c=new GregorianCalendar(year, mounth-1, day);
		// setto la data del calendario
		cal.setLenient(false);
		try{
			// prova a crearla
			// se non causa un errore allora la data è valida
			cal.get(Calendar.DATE);
			// restituisco quindi true
			return true;
		}catch(Exception e)
		// altrimenti restituisco false
		{ return false; }
	}


	/**
	Setta la data dell'informazione
	Solleva un eccezzione se il dato non è valido 
	*/
	public void setData(String data) throws DatiException{
		this.data=data;
	}

	/**
	Restituisce il valore della data
	*/
	public String getData(){
		return data;
	}

	/**
	Restituisce il dato in formato Stringa
	*/
	public String toString(){
		StringBuilder sb=new StringBuilder();

		sb.append(getINOUT()?"IN ":"OUT ");
		sb.append(getLOGINLOGOUT()?"LOGIN":"LOGOUT");
		sb.append(" "+getData());
		sb.append(" "+u.toString());
		sb.append(" "+c.toString());

		return sb.toString();
	}
}