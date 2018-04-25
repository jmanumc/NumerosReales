public class NumerosReales {
	public static String numeroRealConSigno() {
		String resultado = "<N. Real c/signo>";

		System.out.println("\n< N. Real c/signo>:");
		System.out.println("\n1. +<N. Real s/signo>");
		System.out.println("2. -< N. Real s/signo >");
		System.out.print("\nSelecione una opcion: ");
		int opcion = Leer.datoInt();

		switch (opcion) {
		case 1:
			resultado = "+" + resultado;
			System.out.println("< N. Real c/signo>: \n1. +<N. Real s/signo> \n2. -< N. Real s/signo >");
			break;
		case 2:
			resultado = "-" + resultado;
			System.out.println("< N. Real s/signo>: \n1. <N. Real c/signo> \n2. < N. Real s/signo >");
			break;
		default:
			System.out.println("La opcion elegida es incorrecta :(");
		}

		return resultado;
	}

	public static String numeroRealSinSigno() {
		String resultado = "<N. Real c/signo>";

		String nss = "<N. Real s/signo>";
		System.out.println("< N. Real s/signo>: \n1. <N. Real c/signo> \n2. < N. Real s/signo >");

		return resultado;
	}

	public static void main(String [] args) {
		int opcion;
		String resultado;

		System.out.println("\n< N. Real >:");
		System.out.println("\n1.- <N. Real c/signo>");
		System.out.println("2.- < N. Real s/signo >");
		System.out.print("\nSelecione una opcion: ");
		opcion = Leer.datoInt();
		
		switch (opcion) {
		case 1:
			System.out.println(numeroRealConSigno());
			break;
		case 2:
			System.out.println(numeroRealSinSigno());
			break;
		default:
			System.out.println("La opcion elegida es incorrecta :(");
		}
	}
}