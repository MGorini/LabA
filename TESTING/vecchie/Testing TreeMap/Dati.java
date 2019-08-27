import java.util.Date;

class Dati implements Comparable<Dati>{
	Date d;
	int i;

	public Dati(int i, Date d){
		this.d=d;
		this.i=i;
	}

	public int compareTo(Dati dati){
		return dati.d.compareTo(this.d);
	}

	public int compare(Dati dati){
		return dati.d.compareTo(this.d);
	}
	
	public String toString()
	{
		return ""+i;
	}
}