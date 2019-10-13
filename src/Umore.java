/*
I tipi emumerativi posso tornare estremamente utili
soprattutto in caso di aggiornameti futuri
*/
public enum Umore {
	A ("ARRABBIATO"),
	F ("FELICE"),
	S ("SORPRESO"),
	T ("TRISTE"),
	N ("NEUTRO");

	private String umore;

	private Umore(String umore){
		this.umore=umore;
	}

	/**Restituisce l'umore dell'utente in formato Striga */
	public String toString(){
		return this.umore;
	}
}