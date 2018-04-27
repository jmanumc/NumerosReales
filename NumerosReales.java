public class NumerosReales {
    public static String opcionNumeroConSigno(Gramatica gramatica, Numero numero) {
        String etiqueta = "<No. Real c/signo>";
        gramatica.agregarValorConClave(etiqueta);

        System.out.println("\n" + gramatica);

        System.out.println("1) Numero real con signo positivo");
        System.out.println("2) Numero real con signo negativo");
        System.out.print("\nSeleciona una opcion: ");

        switch (Leer.datoInt()) {
        case 1:
            numero.setSigno("+");
            break;
        case 2:
            numero.setSigno("-");
            break;
        default:
            opcionPorDefecto();
        }

        gramatica.agregarValorSinClave(numero + etiqueta);

        return etiqueta;
    }

    public static void opcionDigitoReal(Gramatica gramatica, Numero numero, String etiqueta) {
        numero.setConPunto(false);
        gramatica.agregarValorSinClave(numero + "<digito>" + etiqueta);

        System.out.println("\n" + gramatica);

        System.out.print("Ingresa un digito: ");
        numero.addReal(Leer.dato());

        System.out.print("\n");
    }

    public static void opcionDigitoDecimal(Gramatica gramatica, Numero numero) {
        gramatica.agregarValorSinClave(numero + "<digito>");
        System.out.println("\n" + gramatica);

        System.out.print("\nIngresa un digito: ");
        numero.addDecimal(Leer.dato());

        gramatica.agregarValorSinClave(numero.toString());
        System.out.println("\n" + gramatica + "\n");
    }

    public static void opcionDigitoConDecimal(Gramatica gramatica, Numero numero) {
        gramatica.agregarValorSinClave(numero + "<digito><decimales>");
        System.out.println("\n" + gramatica + "\n");

        System.out.print("\nIngresa un digito: ");
        numero.addDecimal(Leer.dato());
    }

    public static void opcionDigitoConPunto(Gramatica gramatica, Numero numero) {
        numero.setConPunto(false);
        gramatica.agregarValorSinClave(numero + "<digito><punto>");

        System.out.println("\n" + gramatica);

        System.out.print("Ingresa un digito: ");
        numero.addReal(Leer.dato());

        numero.setConPunto(true);
        gramatica.agregarValorSinClave(numero + "<decimales>");

        System.out.println("\n" + gramatica + "\n");
    }

    public static void opcionPorDefecto() {
        System.out.println("La opcion elegida es incorrecta :(");
        System.exit(0);
    }

    /**
     * Inicializa el programa.
     *
     + @param args  los parametros.
     */
	public static void main(String [] args) {
		Gramatica gramatica = new Gramatica("<No. Real>");
        Numero numero = new Numero();
        String etiqueta = null;
        int opcion = 0;

		System.out.println("\n" + gramatica + "\n");

        ///////////////////////////////////////////////////////
        //
        // FASE 1: ASIGNAR SIGNO
        //
        ///////////////////////////////////////////////////////

		System.out.println("1) Numero real con signo.");
		System.out.println("2) Numero real sin signo.");
		System.out.print("\nSeleciona una opcion: ");

		switch (Leer.datoInt()) {
		case 1:
            etiqueta = opcionNumeroConSigno(gramatica, numero);
			break;
		case 2:
            etiqueta = "<N. Real s/signo>";
			gramatica.agregarValorConClave(etiqueta);
			break;
	    default:
            opcionPorDefecto();
		}

        System.out.println("\n" + gramatica + "\n");

        ///////////////////////////////////////////////////////
        //
        // FASE 2: ASIGNAR NUMERO(S) REAL(ES)
        //
        ///////////////////////////////////////////////////////

        do {
            System.out.println("1) Digito");
            System.out.println("2) Digito con punto");
            System.out.print("\nSeleciona una opcion: ");
            opcion = Leer.datoInt();

            switch (opcion) {
                case 1: {
                    opcionDigitoReal(gramatica, numero, etiqueta);
                    break;
                }
                case 2: {
                    opcionDigitoConPunto(gramatica, numero);
                    break;
                }
                default: {
                    opcionPorDefecto();
                }
            }
        } while (opcion != 2);

        ///////////////////////////////////////////////////////
        //
        // FASE 3: ASIGNAR NUMERO(S) DECIMAL(ES)
        //
        ///////////////////////////////////////////////////////

        do {
            System.out.println("1) Digito");
            System.out.println("2) Digito con decimales");
            System.out.print("\nSeleciona una opcion: ");
            opcion = Leer.datoInt();

            switch (opcion) {
                case 1: {
                    opcionDigitoDecimal(gramatica, numero);
                    break;
                }
                case 2: {
                    opcionDigitoConDecimal(gramatica, numero);
                    break;
                }
                default: {
                    opcionPorDefecto();
                }
            }
        } while (opcion != 1);
	}
}
