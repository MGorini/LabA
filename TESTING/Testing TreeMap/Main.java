import java.util.TreeMap;
import java.util.Date;
import java.util.LinkedList;

public class Main{
	public static void main(String[] args){
		TreeMap<String, LinkedList<Dati>> t=new TreeMap<String, LinkedList<Dati>>();
		LinkedList<Dati> l=new LinkedList<Dati>();

		l.add(new Dati(1, new Date(1999,01,16)));
		l.add(new Dati(2, new Date(1989,01,16)));
		l.add(new Dati(3, new Date(1899,01,16)));

		t.put("test1", l);

		l=new LinkedList<Dati>();

		l.add(new Dati(6, new Date(2899,01,16)));
		l.add(new Dati(4, new Date(2999,01,16)));
		l.add(new Dati(5, new Date(2989,01,16)));

		t.put("test2", l);

		l=t.get("test1");

		//l.sort();

		System.out.println(l.get(0));
	}
}