package br.com.blablabla;

public class Endereco {
    private String logradouro, complemento, bairro, localidade, uf, cep;

    public Endereco(EnderecoOMBD enderecoOMBD){
        this.logradouro = enderecoOMBD.logradouro();
        this.complemento = enderecoOMBD.complemento();
        this.bairro = enderecoOMBD.bairro();
        this.localidade = enderecoOMBD.localidade();
        this.uf = enderecoOMBD.uf();
        this.cep = enderecoOMBD.cep();
    }

    @Override
    public String toString() {
        return "Rua/Avenida: " + logradouro + "\n" + "Complemento: " + complemento + "\n"
                + "Bairro: " + bairro + "\n" + "Localidade: " + localidade + "\n" + "UF: " + uf
                + "\n" + "CEP: " + cep;
    }
}
