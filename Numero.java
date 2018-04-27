/**
 * Ejemplo de un numero:
 *
 * +58.67
 *
 * signo = +
 * reales = 58
 * PUNTO = .
 * decimales = 67
 */
public class Numero {
    private String signo;
    private String reales;
    private String decimales;
    private static final String PUNTO = ".";
    private boolean conPunto;

    public Numero() {
        this("");
    }

    public Numero(String reales) {
        this(reales, "");
    }

    public Numero(String reales, String decimales) {
        this(reales, decimales, "");
    }

    public Numero(String reales, String decimales, String signo) {
        this.reales = reales;
        this.decimales = decimales;
        this.signo = signo;
        this.conPunto = true;
    }

    public String getReales() {
        return this.reales;
    }

    public void setReales(String obtenerReales) {
        this.reales = reales;
    }

    public void addReal(String real) {
        this.reales += real;
    }

    public String getDecimales() {
        return this.decimales;
    }

    public void setDecimales(String decimales) {
        this.decimales = decimales;
    }

    public void addDecimal(String decimal) {
        this.decimales += decimal;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public String getSigno() {
        return this.signo;
    }

    public void setConPunto(boolean conPunto) {
        this.conPunto = conPunto;
    }

    @Override
    public String toString() {
        if (reales.isEmpty()) {
            return this.signo;
        } else if (this.conPunto) {
            return this.signo + this.reales + PUNTO + this.decimales;
        } else {
            return this.signo + this.reales;
        }
    }
}
