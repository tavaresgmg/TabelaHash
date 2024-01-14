package dominio;
import java.util.Arrays;
import java.util.Objects;

public class Lista {
    public int tamanho;
    public No inicio;
    public No fim;


    public void adicionarNoFinal(double c, String s) {
        No no = new No();
        no.informacao = new Info(c, s);

        if (this.buscar(c) != null) {
            System.out.println("Essa chave já exite! Elemento não adicionado!");
            return;
        }

        if (this.inicio == null && this.fim == null) { // lista vazia
            this.inicio = no;

        } else {
           no.anterior = this.fim;
           this.fim.proximo = no;
        }

        this.fim = no;
        this.tamanho++;
    }

    public No buscar(double chave) {
        No aux = this.inicio;
        while (aux != null) {
            if (aux.informacao.chave == chave) {
                return aux;
            }
            aux = aux.proximo;
        }

        return null;
    }

    public No[] buscar(String s) {
        No[] busca = null;
        No aux = this.inicio;
        while (aux != null) {
            if (Objects.equals(aux.informacao.dado, s)) {
                if(busca == null) busca = new No[0];
                busca = Arrays.copyOf(busca, busca.length + 1);
                busca[busca.length - 1] = aux;
            }
            aux = aux.proximo;
        }

        return busca;
    }

    public void removerNo(double c) {
        No remover = this.buscar(c);

        if (remover == null) {
            System.out.println("Essa chave não existe.");
            return;
        }


        if (remover == this.inicio && remover == this.fim) {  // lista com apenas 1 elemento
            this.inicio = null;
            this.fim = null;

        } else if (remover == this.inicio) { // remover o primeiro da lista
            this.inicio = remover.proximo;
            this.inicio.anterior = null;
            remover.proximo = null;

        } else if (remover == this.fim) { // remover o fim da lista
            this.fim = remover.anterior;
            this.fim.proximo = null;
            remover.anterior = null;

        } else {
            remover.anterior.proximo = remover.proximo;
            remover.proximo.anterior = remover.anterior;
            remover.proximo = null;
            remover.anterior = null;
        }

        this.tamanho--;
    }

    public String listaToString() {
        String out = "";

        No aux = this.inicio;
        while (aux != null) {

            if (aux != this.inicio) {
                out += " -> ";
            }
            out += aux.nodeToString();
            aux = aux.proximo;
        }
        return out;
    }
}
