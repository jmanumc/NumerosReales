public class Gramatica {
	private static final String IGUAL = "=>";
	private static final String PUNTOS = "::";
	private final String tabulador;
	private final String clave;
	private String valor;

	public Gramatica(String clave) {
		this.clave = clave;
		this.valor = "";
		this.tabulador = new String(new char[clave.length() + PUNTOS.length()]).replace("\0", " ");
	}

	public void agregarValorConClave(String valor) {
		this.valor += clave + PUNTOS + IGUAL + valor + "\n";
	}

	public void agregarValorSinClave(String valor) {
		this.valor += tabulador + IGUAL + valor + "\n";
	}

	@Override
	public String toString() {
		if (valor.isEmpty()) {
			return clave + PUNTOS + IGUAL;
		} else {
			return valor;
		}
	}
}
