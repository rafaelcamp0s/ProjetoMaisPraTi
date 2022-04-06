package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pessoa {
    private String nome = "";
    private String telefone = "";
    private Date nascimento = null;
    private Date cadastro = null;
    private Date atualizacao = null;


    public static Pessoa cadastra(){
        Scanner scanner = new Scanner(System.in);
        Pessoa novaPessoa = new Pessoa();
        System.out.print("Informe o nome: ");
        novaPessoa.setNome(scanner.nextLine());
        System.out.print("Informe o telefone: ");
        novaPessoa.setTelefone(scanner.nextLine());
        do {
            System.out.print("Informe a data de nascimento no formato DD/MM/AAAA: ");
            novaPessoa.setNascimento(stringToDate(scanner.nextLine()));
        }while (novaPessoa.getNascimento().equals(null));//não funcionou
        return novaPessoa;
    }

    public static Date stringToDate(String sDate){
        try{
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            return date;
        } catch (Exception e){
            System.out.println("Informe a data no formato correto.");
            return null;
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    public Date getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(Date atualizacao) {
        this.atualizacao = atualizacao;
    }
}

