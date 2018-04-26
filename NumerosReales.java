public class NumerosReales {
	public static void numeroRealConSigno(Gramatica gramatica) {
		gramatica.agregarValorConClave("<No. Real c/signo>");

		System.out.println("\n" + gramatica + "\n");

		System.out.println("1) Numero real con signo positivo");
		System.out.println("2) Numero real con signo negativo");
		System.out.print("\nSeleciona una opcion: ");

		switch (Leer.datoInt()) {
		case 1:
			numeroRealConSingoPositivo(gramatica);
			break;
		case 2:
			numeroRealConSingoNegativo();
			break;
		default:
			opcionPorDefecto();
		}
	}

	public static void numeroRealConSingoPositivo(Gramatica gramatica) {
		gramatica.agregarValorSinClave("<No. Real c/signo>");

		System.out.println("\n" + gramatica + "\n");

		System.out.println("1) Digito");
		System.out.println("2) Digito con punto");
		System.out.print("\nSeleciona una opcion: ");

		switch (Leer.datoInt()) {
		case 1:
			// digito(gramatica);
			break;
		case 2:
			digitoPunto(gramatica);
			break;
		default:
			opcionPorDefecto();
		}
	}

	public static String numeroRealConSingoNegativo() {
		String resultado = "\n-<N. Real c/signo>";

		System.out.println("<N. Real s/signo>: \n1. <N. Real c/signo> \n2. <N. Real s/signo>");

		return resultado;
	}

	public static String numeroRealSinSigno() {
		String resultado = "<N. Real c/signo>";

		String nss = "<N. Real s/signo>";
		System.out.println("< N. Real s/signo>: \n1. <N. Real c/signo> \n2. <N. Real s/signo>");

		return resultado;
	}

	public static void digito(String gramatica) {
		// algun dia
	}

	public static void digitoPunto(Gramatica gramatica) {
		gramatica.agregarValorSinClave("<digito><punto>");

		System.out.println("\n" + gramatica + "\n");

		System.out.print("Ingresa un digito: ");
		gramatica.agregarValorSinClave(Leer.datoInt() + ".<decimales>");

		System.out.println("\n" + gramatica + "\n");
	}

    public static void opcionPorDefecto() {
        System.out.println("La opcion elegida es incorrecta :(");
    }

	public static void main(String [] args) {
		Gramatica gramatica = new Gramatica("<No. Real>");

		System.out.println("\n" + gramatica + "\n");

		System.out.println("1) Numero real con signo.");
		System.out.println("2) Numero real sin signo.");
		System.out.print("\nSeleciona una opcion: ");
		
		switch (Leer.datoInt()) {
		case 1:
			numeroRealConSigno(gramatica);
			break;
		case 2:
			numeroRealSinSigno();
			break;
		default:
			opcionPorDefecto();
		}
	}
}
