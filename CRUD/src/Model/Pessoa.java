package Model;

import Control.PessoaControl;

import java.time.LocalDate;

public class Pessoa {
    protected String nome;
    protected String telefone;
    protected Integer diaNascimento;
    protected Integer mesNascimento;
    protected Integer anoNascimento;
    protected LocalDate cadastro;
    protected LocalDate atualizacao;
    protected Integer codigo;

    public Pessoa (){
        this.nome = "";
        this.telefone = "";
        this.diaNascimento = null;
        this.mesNascimento = null;
        this.anoNascimento = null;
        this.cadastro = null;
        this.atualizacao = null;
        this.codigo = null;
    }


    public Pessoa(PessoaControl novaPessoa){
        this.codigo = novaPessoa.getCodigo();
        this.nome = novaPessoa.getNome();
        this.telefone = novaPessoa.getTelefone();
        this.diaNascimento = novaPessoa.getDiaNascimento();
        this.mesNascimento = novaPessoa.getMesNascimento();
        this.anoNascimento = novaPessoa.getAnoNascimento();
        this.cadastro = novaPessoa.getCadastro();
        this.atualizacao = novaPessoa.getAtualizacao();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public LocalDate getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDate cadastro) {
        this.cadastro = cadastro;
    }

    public LocalDate getAtualizacao() {
        return atualizacao;
    }

    public void setAtualizacao(LocalDate atualizacao) {
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
        return  '\n' + "Código = "  + codigo + '\n' +
                "Nome = " + nome + '\n' +
                "Telefone = " + telefone + '\n' +
                "Data de nascimento = " + anoNascimento +
                "-" + mesNascimento +
                "-" + diaNascimento + '\n' +
                "Data do cadastro = " + cadastro + '\n' +
                "Última atualização = " + atualizacao + '\n';
    }
}

