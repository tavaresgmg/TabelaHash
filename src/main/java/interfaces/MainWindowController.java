package interfaces;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {

    @FXML
    private TextField textFieldChave;

    @FXML
    private TextField textFieldDados;

    @FXML
    private Label labelRetorno;

    @FXML
    private Button buttonInserir;

    @FXML
    private Button buttonBuscar;

    @FXML
    private Button buttonRemover;

    // Método chamado quando o botão "Confirmar" é pressionado
    @FXML
    private void handleConfirmar() {
        try {
            double chave = Double.parseDouble(textFieldChave.getText());
            String dados = textFieldDados.getText();

            // Chama a função de inserção na tabela hash
            HashTableApp.handleInserir(chave, dados);
        } catch (NumberFormatException e) {
            // Trate a exceção se o usuário inserir um valor inválido para a chave
            labelRetorno.setText("Chave inválida. Insira um valor numérico.");
        }
    }

    // Adicione métodos semelhantes para os botões "Buscar" e "Remover"
}
