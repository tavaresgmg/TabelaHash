package dominio;

public class Info {
    public double chave; // chave tem até 14 dígitos
    public String dado;

    public Info(double c, String s) {
        this.chave = c;
        this.dado = s;
    }

    public String infoToString() {
        return "(chave: " + this.chave + ", dado: " + this.dado + ")";
    }
}
