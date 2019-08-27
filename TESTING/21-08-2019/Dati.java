class Dati{
	// ATTRIBUTI
	private boolean inout;
	private boolean loginlogout;
	private String data;
	public Coordinate c;
	public Umore u;

	public Dati(String inout, String loginlogout, String data, Umore u, Coordinate c) throws DatiException{
		this.c=c;
		this.u=u;
		setINOUT(inout);
		setLOGINLOGOUT(loginlogout);
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

		sb.append(getINOUT()?"IN":"OUT");
		sb.append(" "+getLOGINLOGOUT()?"LOGIN":"LOGOUT");
		sb.append(" "+getData());
		sb.append(" "+u.toString());
		sb.append(" "+c.toString());

		return sb.toString();
	}
}