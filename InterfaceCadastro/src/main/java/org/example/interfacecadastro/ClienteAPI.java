package org.example.interfacecadastro;

import com.google.gson.JsonObject;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClienteAPI
{
    public static String cadastrarUsuario(String nome, String email, String senha, String cpf)
    {
        try{
            URL url = new URL("http://localhost:8080/usuario/cadastro");
            HttpURLConnection result = (HttpURLConnection) url.openConnection();
            result.setRequestMethod("POST");
            result.setRequestProperty("Content-Type", "application/json; utf-8");
            result.setDoOutput(true);


            JsonObject userJson = new JsonObject();
            userJson.addProperty("nome", nome);
            userJson.addProperty("email", email);
            userJson.addProperty("senha", senha);
            userJson.addProperty("cpf", cpf);

            OutputStream os = result.getOutputStream();
            byte[] input = userJson.toString().getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);

            Scanner scanner = new Scanner(result.getInputStream(), StandardCharsets.UTF_8);
            StringBuilder res = new StringBuilder();
            while(scanner.hasNext()){
                res.append(scanner.nextLine());
            }
            return "Usuario criado com sucesso: " + res.toString();
        } catch (Exception e){
            return "Erro ao registrar o cliente " + e.getMessage();
        }
    }
}
