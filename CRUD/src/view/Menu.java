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
                        exibeCadastros();
                        break;
                case 3: atualizaCadastro();
                        break;
                case 4:
                        apagar();
                        break;
                default:
                        System.out.println("Opção inválida.");
            }

        } while (op != 0);


    }

    public void atualizaCadastro(){
        int i = encontraAluno();
        if(i < 0){
            System.out.println("Cadastro não encontrado.");
            i = encontraPessoa();
            if(i < 0){
                System.out.println("Cadastro não encontrado.");
            } else {
                atualiza(i,0); //Pessoa
            }
        }else{
            atualiza(i,1); //Aluno
        }
    }

    public void atualiza(int ind,int j){
        Pessoa copiaPessoa = new Pessoa();
        Aluno copiaAluno = new Aluno();

        System.out.println("Cadastro encontrado:");
        if(j == 0) {
            System.out.println(pessoa.get(ind));
            copiaPessoa = pessoa.get(ind);
        }else if(j == 1) {
            System.out.println(aluno.get(ind));
            copiaAluno = aluno.get(ind);
        }else
            System.out.println("Erro! O cadastro não pode ser carregado.");


        do {
            System.out.println("O que deseja atualizar?");
            System.out.println("0) Não quero modificar dados" + '\n' + "1) Nome" + '\n' + "2) Telefone" + '\n'
                    + "3) Ano do nascimento" + '\n' + "4) Mês do nascimento" + '\n' + "5) Dia do nascimento" + '\n');
            if (j == 1) {
                System.out.println("6) Nota" + '\n');
            }
            Scanner scanner = new Scanner(System.in);
            int op = scanner.nextInt();

            switch (op) {
                case 0:
                        System.out.println("Atualização concluída!");
                        break;
                case 1:
                        System.out.println("Novo nome:");
                        if(j==0) {
                            copiaPessoa.setNome(scanner.nextLine());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setNome(scanner.nextLine());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 2:
                        System.out.println("Novo telefone:");
                        if(j==0) {
                            copiaPessoa.setTelefone(scanner.nextLine());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setTelefone(scanner.nextLine());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 3:
                        System.out.println("Novo ano:");
                        if(j==0) {
                            copiaPessoa.setAnoNascimento(scanner.nextInt());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setAnoNascimento(scanner.nextInt());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 4:
                        System.out.println("Novo mês:");
                        if(j==0) {
                            copiaPessoa.setMesNascimento(scanner.nextInt());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setMesNascimento(scanner.nextInt());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 5:
                        System.out.println("Novo dia:");
                        if(j==0) {
                            copiaPessoa.setDiaNascimento(scanner.nextInt());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setDiaNascimento(scanner.nextInt());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 6:
                        System.out.println("Nova nota:");
                        if(j==1){
                            copiaAluno.setMesNascimento(scanner.nextInt());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                default:
                        System.out.println("Opção não encontrada.");
            }
        }while (op!=0);
    }
    public void apagar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Apagar aluno (A) ou pessoa (P)?");
        String opcao = scanner.nextLine();
        if (opcao.equalsIgnoreCase("A")) {
            int i = encontraAluno();
            if(i < 0){
                System.out.println("Cadastro não encontrado.");
            }else{
                aluno.remove(i);
            }
        } else if (opcao.equalsIgnoreCase("P")){
            int i = encontraPessoa();
            if(i < 0){
                System.out.println("Cadastro não encontrado.");
            }else{
                pessoa.remove(i);
            }
        } else{
            System.out.println("NENHUM CADASTRO APAGADO.");
        }
    }

    public void exibeCadastros(){
        System.out.println('\n' + "Cadastro de não alunos:");
        System.out.println(pessoa);
        System.out.println("");
        System.out.println("");
        System.out.println("Alunos cadastrados:");
        System.out.println(aluno);
        System.out.println("");
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

    public int encontraAluno(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o código do aluno:");
        int codigo = scanner.nextInt();
        int indice = -1;
        for(Aluno procura: aluno){
            if(procura.getCodigo().equals(codigo)) {
                System.out.println(aluno.indexOf(procura));
                indice = aluno.indexOf(procura);
            }
        }
        return indice;
    }

    public int encontraPessoa(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o código da pessoa:");
        int codigo = scanner.nextInt();
        int indice = -1;
        for(Pessoa procura: pessoa){
            if(procura.getCodigo().equals(codigo)) {
                System.out.println(pessoa.indexOf(procura));
                indice = pessoa.indexOf(procura);
            }
        }
        return indice;
    }
}

