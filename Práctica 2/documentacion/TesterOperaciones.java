package es.uam.eps.ads.p2.operaciones;

/**
 * Tester el primer apartado de la P2
 * @author Profesores ADS
 */
public class TesterOperaciones {

	public static void main(String[] args) {
		Expresion v1 = new Valor(3.44);
		Expresion v2 = new Valor(-6.33);
		Expresion v3 = new Valor(10.22);
		Expresion suma = new Suma(new Suma(v1, v2), v3);
		Expresion ln = new Logaritmo(new Division(suma, new Suma(v1, new Valor(-1.23))));
		Expresion error = new Logaritmo(new Suma(v1, v2));
		
		System.out.print("isValida " + suma + " ? " + suma.isValida());
		System.out.println(" ---> " + suma + " = " + suma.calcular());
		
		System.out.print("isValida " + ln + " ? " + ln.isValida());
		System.out.println(" ---> " + ln + " = " + ln.calcular());
		
		System.out.print("isValida " + error + " ? " + error.isValida());
		System.out.println(" ---> " + error + " = " + error.calcular());
		
		System.out.println();
		System.out.println(v1 + " mayor " + v3 + " ? " + v1.isMayor(v3));
		System.out.println(suma + " mayor " + ln + " ? " + suma.isMayor(ln));
	}
}
