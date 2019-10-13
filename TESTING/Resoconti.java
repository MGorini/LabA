import java.util.TreeMap;

class Resoconti{
	public static void resocontoSingoloUtente(String IDUtente, TreeMap<String, LinkedList<UploadUtente>> t){
		// Inizializzo i contatori degli umori
		int A=0, F=0, S=0, T=0, N=0;
		/// Creo una variabile di supporto per gli Upload dell'utente
		UploadUtente up;

		LinkedList<UploadUtente> l=t.get(IDUtente);

		// Conteggio gli umori
		for(int i=0; i<l.size(); i++)
		{
			up=l.get(i);
			switch(up.u)
			{
				Umore.ARRABBIATO: A++;
								break;

				Umore.FELICE: F++
							break;

				Umore.SORPRESO: S++;
							break;

				Umore.TRISTE: T++;
							break;

				Umore.NEUTRO: N++;
							break;

				default: break;
			}
		}




	}



}