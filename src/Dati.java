import java.util.Date;
import java.util.Calendar;

/**
Oggetto che descrive un caricamento degli utenti.*/
class Dati{
	// ATTRIBUTI
	private boolean inout;
	private boolean loginlogout;
	private Date data;
	public Coordinate c;
	public Umore u;

	/**Crea un oggetto di tipo Dati.*/
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
	Consente di settare lo stato di registrazione.<br>
	Solleva un eccezzione se il dato non è valido.
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
	Restituisce lo stato di registrazione.
	*/
	public boolean getINOUT(){
		return inout;
	}

	/**
	Consente di settare lo stato di LOG.<br>
	Solleva un eccezzione se il dato non è valido. 
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
	Restituisce lo stato di LOG.
	*/
	public boolean getLOGINLOGOUT(){
		return loginlogout;
	}

	/**Verifica che la data sia valida.*/
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

	/**suddivide le info da stringa a data vera e propria:
	<br>giorno/mese/anno. */
	public static Date predisponiData(String s) throws DatiException{
		int d,m,y;
		if(s.length()!=8)
			throw new DatiException("Formato data non valida!");

		//converto giorno, mese ed anno in interi
		d = Integer.parseInt(s.substring(0,2));
		m = Integer.parseInt(s.substring(2,4));
		y = Integer.parseInt(s.substring(4,8));

		if(!verificaData(y, m, d))
			throw new DatiException("Data non valida");

		//restituisco una data completa e validata
		return new Date(y,m,d);
	}

	/**
	Setta la data dell'informazione.<br>
	Solleva un eccezzione se il dato non è valido.
	*/
	public void setData(String data) throws DatiException{
		this.data=predisponiData(data);
	}

	/**
	Restituisce il valore della data.
	*/
	public Date getData(){
		return data;
	}

	/**
	Restituisce il dato in formato Stringa.
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