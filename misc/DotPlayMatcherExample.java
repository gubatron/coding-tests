import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DotPlayMatcherExample {

	
	static Pattern PATRON_DE_JUGADA =  Pattern.compile("(\\d*),(\\d*)([HhVv])");
	
	public static void main(String[] args) {
		String[] pruebas = new String[] {"1,1H", "2,1h","", "23328923,23278V", "100,442v"};
		
		for (String jugada : pruebas) {
			//paso cada una de las jugadas de prueba que defini arriba
			//en el arreglo por el matcher. (Voy a meter unas que no sirvan)
			Matcher matcher = PATRON_DE_JUGADA.matcher(jugada);
			
			if (matcher.matches()) {
				System.out.println("Jugada Valida!: ["+matcher.group(0)+"]");
				System.out.println("X:         ["+matcher.group(1)+"]");
				System.out.println("Y:         ["+matcher.group(2)+"]");
				System.out.println("Direccion: ["+matcher.group(3).toUpperCase()+"]");
				System.out.println();
			} else {
				System.out.println("Jugada Invalida!: ["+jugada+"]");
			}
		}
	}
}
