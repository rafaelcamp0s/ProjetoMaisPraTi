package Control;

import java.time.LocalDate;

public class PessoaControl {
    private Integer codigo = null;
    private String nome = "";
    private String telefone = "";
    private Integer diaNascimento = null;
    private Integer mesNascimento = null;
    private Integer anoNascimento = null;
    private LocalDate cadastro = null;
    private LocalDate atualizacao = null;
    private Double nota = -1.0;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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

    public void setNascimento(String nasc){
        String[] numeros = nasc.split("-");
        try {
            this.anoNascimento = Integer.parseInt(numeros[0]);
            this.mesNascimento = Integer.parseInt(numeros[1]);
            this.diaNascimento = Integer.parseInt(numeros[2]);
        }
        catch(Exception e){
            System.out.println("Data registrada incorretamente.");
        }
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

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
