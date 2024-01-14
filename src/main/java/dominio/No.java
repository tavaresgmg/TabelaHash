package dominio;

public class No {
    public Info informacao;
    public No proximo;
    public No anterior;

    public String infoToString() {
        return this.informacao.infoToString();
    }

    public String nodeToString() {
        return this.informacao.infoToString();
    }
}
