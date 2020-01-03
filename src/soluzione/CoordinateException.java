package soluzione;

/**Descrive un eccezione a livello di locazione di un utente all'interno dell'area
sorvegliata da EmotionalMaps.*/
public class CoordinateException extends Exception{
	public CoordinateException(String msg){
		super(msg);
	}
}