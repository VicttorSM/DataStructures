/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

/**
 *
 * @author Michelle
 */
public class Pessoa {

    public Pessoa(String nome, 
                  String sobrenome,
                  int idade,
                  String cpf,
                  String sexo,
                  String cidade) {
        setNome(nome);
        setSobrenome(sobrenome);
        setIdade(idade);
        setCPF(cpf);
        setSexo(sexo);
        setCidade(cidade);
    }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCPF() {
        return cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    private String nome; 
    private String sobrenome;
    private int idade;
    private String cpf;
    private String sexo;
    private String cidade;
}
