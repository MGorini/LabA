public class Main{
	public static void main(String[] args){
		String tmp;
		while(true){
			System.out.print("Inserire una sigla>");
			tmp=System.console().readLine();
			System.out.println(Umore.valueOf(tmp));
		}
	}
}