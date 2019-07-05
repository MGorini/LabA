/*
I tipi emumerativi posso tornare estremamente utili
soprattutto in caso di aggiornameti futuri
*/
public enum Umore {
	ARRABBIATO ("Arrabbiato", 'A'),
	FELICE ("Felice", 'F'),
	SORPRESO ("Sorpreso", 'S'),
	TRISTE ("Triste", 'T'),
	NEUTRO ("Neutro", 'N');

	private String umore;
	private char sigla;

	private Umore(String umore, char sigla){
		this.umore=umore;
		this.sigla=sigla;
	}

	/**Restituisce la Sigla (carattere) che rappresenta l'umore*/
	public char siglaUmore(){
		return this.sigla;
	}

	/**Restituisce l'umore dell'utente in formato Striga */
	public String toString(){
		return this.umore;
	}
}