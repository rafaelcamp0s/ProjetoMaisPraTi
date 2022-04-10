package Model;

import Control.PessoaControl;

public class Aluno extends Pessoa{
    Double nota;

    public Aluno() {
        super();
        this.nota = 0.0;
    }

    public Aluno(PessoaControl novaPessoa){
        super(novaPessoa);
        this.nota = novaPessoa.getNota();
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return '\n' + "Código = "  + codigo + '\n' +
                "Nome = " + nome + '\n' +
                "Telefone = " + telefone + '\n' +
                "Data de nascimento = " + anoNascimento +
                "-" + mesNascimento +
                "-" + diaNascimento + '\n' +
                "Data do cadastro = " + cadastro + '\n' +
                "Última atualização =" + atualizacao + '\n' +
                "nota = " + nota + '\n';
    }
}
