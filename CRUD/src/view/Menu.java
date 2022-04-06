package view;

import Model.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int op;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Pessoa> pessoa = new ArrayList<>();

    public void exibeMenu(){
        do {
            System.out.println("1 - Novo cadastro");
            System.out.println("2 - Exibir cadastros");
            System.out.println("3 - Atualizar dados de um cadastro");
            System.out.println("4 - Apagar um cadastro");
            System.out.println("0 - Encerrar o programa");
            op = scanner.nextInt();

            switch (op){
                case 0: System.out.println("Programa encerrado. Obrigado!");
                        break;
                case 1: pessoa.add(Pessoa.cadastra());
                        break;
                case 2: //pessoa.listaPessoa();
                        break;
                case 3: //pessoa.atualizaCadastro();
                        break;
                case 4: //pessoa.apagaCadastro();
                        break;
                default:
                    System.out.println("Opção inválida.");
            }

        }while (op!=0);


    }
}
