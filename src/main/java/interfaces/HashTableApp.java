package interfaces;

import dominio.Hash;
import dominio.No;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HashTableApp extends Application {

    private static Hash tabelaHash = new Hash();  // Instância da sua classe Hash

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/MainWindow.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Hash Table App");
        stage.setScene(scene);
        stage.show();
    }

    // Função para inserção na tabela hash
    public static void handleInserir(double chave, String dados) {
        tabelaHash.insertTable(chave, dados);
        System.out.println("Elemento inserido com sucesso!");
    }

    // Função para busca na tabela hash
    public static No handleBuscar(double chave) {
        No resultado = tabelaHash.searchTable(chave);
        if (resultado != null) {
            System.out.println("Elemento encontrado: " + resultado.informacao);
        } else {
            System.out.println("Elemento não encontrado.");
        }
        return resultado;
    }

    // Função para remoção na tabela hash
    public static void handleRemover(double chave) {
        tabelaHash.removeTable(chave);
        System.out.println("Elemento removido com sucesso!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
