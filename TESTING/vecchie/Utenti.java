import java.util.TreeMap;

class Utenti{
	public static void main(String[] args){
		/* Un utente verrà rappresentato tramite:
			- un ID (KEY) (String)
			- Lista di Upload (LinkedList) 
		*/
		// Creo ed inizializzo la TreeMap
		TreeMap<String, LinkedList<UploadUtente>> t=new TreeMap<String, LinkedList<UploadUtente>>();
		List<String> codiciUtenti=new LinkedList<String>();



	}

	public static boolean aggiungiCaricamentoUtente(Stirng IDUtente, UploadUtente u){
		LinkedList<UploadUtente> l=t.get(IDUtente);
		try{
			/*
				ISTRUZIONI PER LA VERIFICA DEI LOG
			*/
			l.add(u).sort();
			return true;
		}
		catch(Exception e)
		{return false;}
	}


	public static LinkedList<UploadUtente> ottieniCaricamentiDaUtente(String IDUtente){
		return t.get(IDUtente);
	}
}