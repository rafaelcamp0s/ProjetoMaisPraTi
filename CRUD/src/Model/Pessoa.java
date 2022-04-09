package Model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Pessoa {
    private String nome = "";
    private String telefone = "";
    private String nascimento = "";
    private Integer diaNascimento = null;
    private Integer mesNascimento = null;
    private Integer anoNascimento = null;
    private Date cadastro = null;
    private Date atualizacao = null;


    public static Pessoa cadastra(){
        Scanner scanner = new Scanner(System.in);
        Pessoa novaPessoa = new Pessoa();
        System.out.print("Informe o nome: ");
        novaPessoa.setNome(scanner.nextLine());
        System.out.print("Informe o telefone: ");
        novaPessoa.setTelefone(scanner.nextLine());
        System.out.println("Informe a data de nascimento no formato dd/mm/aaaa");
        novaPessoa.setNascimento(scanner.nextLine());

        return novaPessoa;
    }

    public void setNascimento(String nasc){
        String[] numeros = nasc.split("/");
        try {
            this.diaNascimento = Integer.parseInt(numeros[0]);
            this.mesNascimento = Integer.parseInt(numeros[1]);
            this.anoNascimento = Integer.parseInt(numeros[2]);
        }
        catch(Exception e){
            System.out.println("Comando inválido, informe novamente.");
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

    public Integer getDiaNascimento() {
        return diaNascimento;
    }

    public void setDiaNascimento(Integer diaNascimento) {
        this.diaNascimento = diaNascimento;
    }

    public Integer getMesNascimento() {
        return mesNascimento;
    }

    public void setMesNascimento(Integer mesNascimento) {
        this.mesNascimento = mesNascimento;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    @Override
    public String toString() {
        return "Código = "  +
                "nome = " + nome + '\n' +
                ", telefone = " + telefone + '\n' +
                ", nascimento = " + diaNascimento +
                "/" + mesNascimento +
                "/" + anoNascimento + '\n' +
                ", cadastro = " + cadastro + '\n' +
                ", atualizacao=" + atualizacao + '\n';
    }
}

