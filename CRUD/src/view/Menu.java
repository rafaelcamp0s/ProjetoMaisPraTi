package view;

import Control.PessoaControl;
import Model.Aluno;
import Model.Pessoa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int op;
    private int cod = 0;
    private Scanner scanner;
    private ArrayList<Pessoa> pessoa = new ArrayList<>();
    private ArrayList<Aluno> aluno = new ArrayList<>();

    //Pessoa auxilar (recebe nota também), usada para depois montar o objeto Pessoa ou o objeto Aluno
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
            Pessoa novaPessoa; //para lista de pessoas
            Aluno novoAluno; //para lista de alunos

            switch (op) {

                case 0:
                        System.out.println("Programa encerrado. Obrigado!" + '\n');
                        break;
                case 1:
                        //cod é o código do cadastro, cada cadastro novo incrementa ele.
                        this.cod++;
                        cadastra(this.cod);
                        if (this.novaPessoaC.getNota() < 0.0) {
                            //se nota < 0 então não é aluno.
                            //cria nova Pessoa, que recebe os dados de novaPessoaC
                            novaPessoa = new Pessoa(this.novaPessoaC);
                            this.pessoa.add(novaPessoa);
                        } else {
                            //se não foi Pessoa então é Aluno.
                            //cria novo Aluno, que recebe os dados de novaPessoaC
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o código do cadastro:");

        //recebe em String e converte para int, direto em int estava ocorrendo erro na leitura.
        String sCodigo = scanner.nextLine();
        int codigo = Integer.valueOf(sCodigo);

        int i = encontraAluno(codigo);
        if(i < 0){
            System.out.println("Cadastro não encontrado.");
            i = encontraPessoa(codigo);
            if(i < 0){
                System.out.println("Cadastro não encontrado.");
            } else {
                atualiza(i,0); //j=0 -> Pessoa
            }
        }else{
            atualiza(i,1); //j=1 -> Aluno
        }
    }

    public void atualiza(int ind,int j){
        Pessoa copiaPessoa = new Pessoa();
        Aluno copiaAluno = new Aluno();

        System.out.println("Cadastro encontrado:");
        if(j == 0) {
            System.out.println(pessoa.get(ind));
            copiaPessoa = pessoa.get(ind); //copia a Pessoa da Lista
        }else if(j == 1) {
            System.out.println(aluno.get(ind));
            copiaAluno = aluno.get(ind); //copia o Aluno da lista
        }else
            System.out.println("Erro! O cadastro não pode ser carregado.");

        Boolean repete = true;
        do {
            System.out.println("O que deseja atualizar?");
            System.out.println("0) Não quero modificar dados" + '\n' + "1) Nome" + '\n' + "2) Telefone" + '\n'
                    + "3) Ano do nascimento" + '\n' + "4) Mês do nascimento" + '\n' + "5) Dia do nascimento");
            if (j == 1) {
                System.out.println("6) Nota" + '\n');
            }

            //por erros de leitura foi criado um novo scanner para verificar se era algum conflito.
            //Nota: remover esse scanner para testar com o criado anteriormente.
            Scanner scanner1 = new Scanner(System.in);
            String sop = scanner1.nextLine();
            int op = Integer.valueOf(sop);

            switch (op) {
                case 0:
                        System.out.println("Atualização concluída!");
                        repete = false;
                        break;
                case 1:
                        System.out.println("Novo nome:");
                        String nome = scanner1.nextLine();

                        if(j==0) {
                            copiaPessoa.setNome(nome);
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            System.out.println("j = " + j);
                            copiaAluno.setNome(nome);
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 2:
                        System.out.println("Novo telefone:");
                        if(j==0) {
                            copiaPessoa.setTelefone(scanner1.nextLine());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setTelefone(scanner1.nextLine());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 3:
                        System.out.println("Novo ano:");
                        if(j==0) {
                            copiaPessoa.setAnoNascimento(scanner1.nextInt());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setAnoNascimento(scanner1.nextInt());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 4:
                        System.out.println("Novo mês:");
                        if(j==0) {
                            copiaPessoa.setMesNascimento(scanner1.nextInt());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setMesNascimento(scanner1.nextInt());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 5:
                        System.out.println("Novo dia:");
                        if(j==0) {
                            copiaPessoa.setDiaNascimento(scanner1.nextInt());
                            copiaPessoa.setAtualizacao(LocalDate.now());
                        }else if(j==1){
                            copiaAluno.setDiaNascimento(scanner1.nextInt());
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                case 6:
                        System.out.println("Nova nota:");
                        if(j==1){
                            copiaAluno.setNota(novaNota("S"));
                            copiaAluno.setAtualizacao(LocalDate.now());
                        }
                        break;
                default:
                        System.out.println("Opção não encontrada.");
            }
        }while (repete);
    }


    //Modificar para que o método encontre pelo código sem informar se é aluno ou pessoa
    //Parecido com o método de atualização
    public void apagar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Apagar aluno (A) ou pessoa (P)?");
        String opcao = scanner.nextLine();

        if (opcao.equalsIgnoreCase("A")) {
            System.out.println("Informe o código do aluno:");
            String sCodigo = scanner.nextLine();
            int codigo = Integer.valueOf(sCodigo);
            int i = encontraAluno(codigo);
            if(i < 0){
                System.out.println("Cadastro não encontrado.");
            }else{
                aluno.remove(i);
            }
        } else if (opcao.equalsIgnoreCase("P")){
            System.out.println("Informe o código da pessoa:");
            String sCodigo = scanner.nextLine();
            int codigo = Integer.valueOf(sCodigo);
            int i = encontraPessoa(codigo);
            if(i < 0){
                System.out.println("Cadastro não encontrado.");
            }else{
                pessoa.remove(i);
            }
        } else{
            System.out.println("NENHUM CADASTRO APAGADO.");
        }
    }

    //tentar modificar a exibição juntado as listas em uma só e organizar com collections
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
                    System.out.println("Utilize ponto ao invés de vírgula.");
                }
            }
        }
        return -1.0;//nota negativa = Não é aluno
    }

    public int encontraAluno(int codigo){
        int indice = -1; //indice negativo = cadastro não encontrado
        for(Aluno procura: aluno){
            if(procura.getCodigo().equals(codigo)) {
                System.out.println(aluno.indexOf(procura));
                indice = aluno.indexOf(procura);
            }
        }
        return indice;
    }

    public int encontraPessoa(int codigo){
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

