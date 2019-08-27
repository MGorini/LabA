import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeMap;

class GestisciIO{
	
	public static TreeMap<String,Dati> import(String file, TreeMap<String,Dati> t){
		try{
			// Creo il collegamento al file
			BufferedReader br=new BufferedReader(new FileReader(file));

			// variabili di supporto per la lettura
			String riga;
			String[] tmp;

			while((riga=br.readLine())!=null){
				// testo se le informazioni sono valide
				// verrà sollevata un eccezzione se non lo sono
				try{
					tmp=riga.split("");
					// verifico se ho il numero giusto di informazioni (6)
					// se non le ho so che sono sbagliate a prescindere
					if(tmp.length!=6)
						throw new Exception(riga+" non valida\nVerra' ignorata");

					// verifico se l'utente è gia presente
					if(t.get(tmp[3])!=null){

					}
					else
					{
						// se i dati di log sono validi lo inserisco
						// un nuovo utente non poù aver eseguito un LOGOUT
						// se è nuovo
						if(tmp[0]=="IN" && tmp[1]=="LOGIN")
							t.put(tmp[3],new Dati(tmp[0],tmp[1],tmp[2],new Coordinate(tmp[4]),tmp[5]));
						// altrimenti segnalo un errore
						else
							throw new Exception("Dati di LOG non validi\nVerranno ignorati");

					}

				}catch(Exception e){}
			}
			return t;
		}catch(Exception e){}
		return null;
	}

}