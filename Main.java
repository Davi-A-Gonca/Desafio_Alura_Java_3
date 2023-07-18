import br.com.blablabla.Endereco;
import br.com.blablabla.EnderecoOMBD;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner escreve = new Scanner(System.in);
        List<Endereco> enderecos = new ArrayList<>();
        while (true){
        System.out.println("Qual o seu CEP? ['sair' para sair]");
        var busca = escreve.nextLine();
        if(busca.equalsIgnoreCase("sair")){break;}
        String enderecoSite = "https://viacep.com.br/ws/" + busca.replace("-", "") + "/json/";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoSite)).build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            EnderecoOMBD enderecoOMBD = new Gson().fromJson(response.body(), EnderecoOMBD.class);
            System.out.println(enderecoOMBD);
            Endereco endereco = new Endereco(enderecoOMBD);
            System.out.println(endereco);
            enderecos.add(endereco);
        } catch (Exception e) {
            System.out.println("Exceção: " + e.getMessage());
        }
    }
        System.out.println(enderecos);
        FileWriter escrita = new FileWriter("enderecos.json");
        escrita.write(new Gson().toJson(enderecos));
        escrita.close();
    }
}