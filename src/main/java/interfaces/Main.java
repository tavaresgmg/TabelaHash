import dominio.Hash;
import dominio.Lista;
import dominio.No;

public class Main {
    public static void main(String[] args) {
        // inicializa tabela nula
        Hash hash = new Hash();
        System.out.println(hash.tabelaHash == null);

        // Criar tabela vazia
        hash.makeTable();

        // Inserir dados
        hash.insertTable(0, "ABC");
        hash.insertTable(0.05, "Posição 0");
        hash.insertTable(0.000001, "ABC");
        hash.insertTable(0.000002, "ABC");
        hash.insertTable(0.000003, "ABC");
        hash.insertTable(0.000004, "DEF");
        hash.insertTable(765_903.8965, "DEF");
        hash.insertTable(7_345_234.985132, "Mensagem");
        hash.insertTable(23_543.348762, "dado satélite");
        hash.insertTable(50.003945, "coisa");

        // Mostrar Tabela
        hash.showTable();

        // Mostra a quantidade de elementos na tabela
        System.out.println(hash.sizeTable());

        // busca por chave
        System.out.println("Procurar pela chave 11.111.111,111111");
        No procuraChave = hash.searchTable(11_111_111.111111);
        if (procuraChave != null)
            System.out.println(procuraChave.nodeToString());
        else
            System.out.println("Chave não encontrada.\n");

        System.out.println("Procurar pela chave 0,000001");
        procuraChave = hash.searchTable(0.000001);
        if (procuraChave != null)
            System.out.println(procuraChave.nodeToString());
        else
            System.out.println("Chave não encontrada.\n");


        // busca por dado
        System.out.println("Procurar por dado \"ABC\"");
        No[] procuraDado = hash.searchTable("ABC");
        if (procuraDado != null) {
            for (No no : hash.searchTable("ABC")) {
                System.out.println(no.nodeToString());
            }
        } else {
            System.out.println("Não há nenhum elemento com esses dados!\n");
        }

        System.out.println("Procurar por dado \"123\"");
        procuraDado = hash.searchTable("123");
        if (procuraDado != null) {
            for (No no : hash.searchTable("123")) {
                System.out.println(no.nodeToString());
            }
        } else {
            System.out.println("Não há nenhum elemento com esses dados!\n");
        }

        // Remover elemento por chave primária
        hash.removeTable(0.000001);
        hash.showTable();
        System.out.println(hash.sizeTable());

        //Remover elementos por dados
        hash.removeTable("ABC");
        hash.showTable();
        System.out.println(hash.sizeTable());

        // Destruir / Limpar Tabela
        hash.destroyTable();
        hash.showTable();
        System.out.println(hash.sizeTable());


    }
}
