package dominio;
import java.util.Arrays;

public class Hash {
    private final int linhas = 50_000;
    public Lista[] tabelaHash;

    public void makeTable() {
        this.tabelaHash = new Lista[this.linhas];
        for (int i=0; i < this.linhas; i++) {
            this.tabelaHash[i] = new Lista();
        }
    }

    public Object showTable() {
        System.out.println("\n================ TABELA HASH ================");
        if (this.tabelaHash == null) {
            System.out.println("Tabela Vazia");
        }

        int c = 0;
        for (int i = 0; i< tabelaHash.length; i++) {
            Lista lista = tabelaHash[i];
            if (lista.tamanho == 0) continue;
            System.out.println(i + ": " + lista.listaToString());
            c++;
        }

        if (c == 0) System.out.println("Tabela Vazia.");

        System.out.println("=============================================");

        return null;
    }

    public void destroyTable() {
        this.makeTable();
        System.out.println("Tabela foi totalmente limpa com sucesso.");
    }

    public int sizeTable() {
        int soma = 0;
        for (Lista lista : this.tabelaHash) {
            soma += lista.tamanho;
        }

        return soma;
    }

    public void insertTable(double x, String dados) {
        if (x < 0.000001 || x > 99999999.999999) {
            System.out.println("Chave primária inválida. Elemento não adicionado.");
            return;
        }

        if (this.sizeTable() >= 50_000_000) {
            System.out.println("Valor máximo de elementos alcançado. Não é possível inserir mais!");
        }
        int pos = hashFunction(x);
        this.tabelaHash[pos].adicionarNoFinal(x, dados);
    }

    public No searchTable(double x) {
        int pos = hashFunction(x);
        return this.tabelaHash[pos].buscar(x);
    }

    public No[] searchTable(String s) {
        No[] busca = null;

        for (Lista lista: this.tabelaHash) {
            if (lista.buscar(s) != null) {
                if(busca == null) busca = new No[0];
                for (No no: lista.buscar(s)) {
                    busca = Arrays.copyOf(busca, busca.length + 1);
                    busca[busca.length - 1] = no;
                }
            }
        }

        return busca;
    }

    public void removeTable(double x) {
        int pos = hashFunction(x);
        tabelaHash[pos].removerNo(x);
    }

    public void removeTable(String s) {
        No[] busca = this.searchTable(s);

        if (busca == null) {
            System.out.println("Não há elementos com essa informação");
            return;
        }

        for (No no : busca) {
            this.removeTable(no.informacao.chave);
        }
    }

    private int hashFunction(double chave) {
        int k = (int) ((chave * 1_000_000) % this.linhas);
        return k;
    }
}
