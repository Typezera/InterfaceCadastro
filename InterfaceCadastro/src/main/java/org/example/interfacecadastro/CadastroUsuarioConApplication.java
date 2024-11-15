package org.example.interfacecadastro;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CadastroUsuarioConApplication extends Application {
    @Override
    public void start(Stage stage)
    {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);


        //interface
        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();

        Label lblEmail = new Label("Email: ");
        TextField txtEmail = new TextField();

        Label lblSenha = new Label("Senha: ");
        PasswordField txtSenha = new PasswordField();

        Label lblCpf = new Label("CPF: ");
        TextField txtCpf = new TextField();

        Button btnEnviar = new Button("Enviar");

        TextArea txtResultado = new TextArea();
        txtResultado.setEditable(false);
        txtResultado.setWrapText(true);

        gridPane.add(lblNome, 0, 0);
        gridPane.add(txtNome, 1, 0);
        gridPane.add(lblEmail, 0, 1);
        gridPane.add(txtEmail, 1, 1);
        gridPane.add(lblSenha, 0, 2);
        gridPane.add(txtSenha, 1, 2 );
        gridPane.add(lblCpf, 0, 3);
        gridPane.add(txtCpf, 1, 3);
        gridPane.add(btnEnviar, 1, 4);
        gridPane.add(txtResultado, 0, 5, 4, 3);


        btnEnviar.setOnAction(e -> {
            String nome = txtNome.getText();
            String email = txtEmail.getText();
            String senha = txtSenha.getText();
            String cpf = txtCpf.getText();

            if(!nome.isEmpty() && !email.isEmpty() && !senha.isEmpty() && !cpf.isEmpty())
            {
                String res = ClienteAPI.cadastrarUsuario(nome,email,senha, cpf);
                txtResultado.setText((res));
            }else{
                txtResultado.setText("Preencha todos os campos!");
            }
        });


        Scene scene = new Scene(gridPane, 400, 300);
        stage.setTitle("Cadastro de Cliente");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}