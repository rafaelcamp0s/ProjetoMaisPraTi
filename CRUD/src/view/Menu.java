package view;

import Control.PessoaControl;
import Model.Aluno;
import Model.Pessoa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int op;
    private int cod = 0;
    private Scanner scanner;
    private ArrayList<Pessoa> pessoa = new ArrayList<>();
    private ArrayList<Aluno> aluno = new ArrayList<>();
    private PessoaControl novaPessoaC = new PessoaControl();

    public void exibeMenu() {
        do {
            scanner = new Scanner(System.in);
            System.out.println("1 - Novo cadastro");
            System.out.println("2 - Exibir cadastros");
            System.out.println("3 - Atualizar dados de um cadastro");
            System.out.println("4 - Apagar um cadastro (primeiro verifique o código do cadastro)");
            System.out.println("0 - Encerrar o programa");
            op = scanner.nextInt();
            Pessoa novaPessoa;
            Aluno novoAluno;

            switch (op) {

                case 0:
                        System.out.println("Programa encerrado. Obrigado!" + '\n');
                        break;
                case 1:
                        this.cod++;
                        cadastra(this.cod);
                        if (this.novaPessoaC.getNota() < 0.0) {
                            novaPessoa = new Pessoa(this.novaPessoaC);
                            this.pessoa.add(novaPessoa);
                        } else {
                            novoAluno = new Aluno(this.novaPessoaC);
                            this.aluno.add(novoAluno);
                        }
                        break;
                case 2:
                        System.out.println('\n' + "Cadastro geral:");
                        System.out.println(pessoa);
                        System.out.println("");
                        System.out.println("");
                        System.out.println("Alunos cadastrados:");
                        System.out.println(aluno);
                        System.out.println("");
                        break;
                case 3: //pessoa.atualizaCadastro();
                        break;
                case 4:
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Apagar aluno (A) ou pessoa (P)?");
                            String opcao = scanner.nextLine();
                            if (opcao.equalsIgnoreCase("A")) {
                                int i = apagaAluno();
                                if(i < 0){
                                    System.out.println("Cadastro não encontrado.");
                                }else{
                                    aluno.remove(i);
                                }
                            } else if (opcao.equalsIgnoreCase("P")){
                                //this.pessoa.remove((apagarPessoa()));
                            } else{
                                System.out.println("NENHUM CADASTRO APAGADO.");
                            }
                        break;
                default:
                        System.out.println("Opção inválida.");
            }

        } while (op != 0);


    }

    public void cadastra(int cod) {
        novaPessoaC.setCodigo(cod);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe o nome: ");
        novaPessoaC.setNome(scanner.nextLine());
        System.out.print("Preencha apenas com números e sem espaços. (Não esqueça o código de área)");
        System.out.println("Informe o número do telefone:");
        novaPessoaC.setTelefone(scanner.nextLine());
        System.out.println("Informe a data de nascimento no formato AAAA-MM-DD");
        novaPessoaC.setNascimento(scanner.nextLine());
        novaPessoaC.setCadastro(LocalDate.now());
        novaPessoaC.setAtualizacao(LocalDate.now());
        System.out.println("Há nota para informar? S - Para incluir nota");
        System.out.println("Qualquer outra tecla para continuar sem nota.");
        novaPessoaC.setNota(novaNota(scanner.nextLine()));

    }

    public Double novaNota(String op) {
        Scanner scanner = new Scanner(System.in);
        if (op.equalsIgnoreCase("S")) {
            double valor = 0;
            boolean realizarLeitura = true;
            while (realizarLeitura) {
                System.out.println("Nota de 0 a 10:");
                try {
                    valor = Double.parseDouble(scanner.nextLine());
                    if (valor > 0 && valor <= 10) {
                        return valor;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Utilize vírgula ao invés de ponto.");
                }
            }
        }
        return -1.0;
    }

    public int apagaAluno(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o código do aluno que será apagado:");
        int codigo = scanner.nextInt();
        int indice = -1;
        for(Aluno remover: aluno){
            if(remover.getCodigo().equals(codigo)) {
                System.out.println(aluno.indexOf(remover));
                indice = aluno.indexOf(remover);
            }
        }
        return indice;
    }
}

