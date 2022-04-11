package Control;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Classe para auxiliar na construção dos objetos Pessoa e Aluno
 * Após montar PessoaControl, os dados são repassados para Pessoa ou Aluno,
 * dependendo se há nota válida ou não.
 */

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
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> listaDDD = new ArrayList<>();

        Collections.addAll(listaDDD,                    //DDDs
                11,12,13,14,15,16,17,18,19,    //SP
                            21,22,24,                   //RJ
                            27,28,                      //ES
                            31,32,33,34,35,37,38,       //MG
                            41,42,43,44,45,46,          //PR
                            47,48,49,                   //SC
                            51,53,54,55,                //RS
                            61,                         //DF
                            62,64,                      //GO
                            63,                         //TO
                            65,66,                      //MT
                            67,                         //MS
                            68,                         //AC
                            69,                         //RO
                            71,73,74,75,77,             //BA
                            79,                         //SE
                            81,87,                      //PE
                            82,                         //AL
                            83,                         //PB
                            84,                         //RN
                            85,88,                      //CE
                            86,89,                      //PI
                            91,93,94,                   //PA
                            92,97,                      //AM
                            95,                         //RR
                            96,                         //AP
                            98,99                       //MA
        );

        Integer DDD = null;
        Integer telNumero = null;

        do{
            boolean erroDDD = false;
            boolean erroCel = false;
            boolean erroFixo = false;
            boolean celular = false;
            boolean fixo = false;
            String[] numeros = telefone.split("-");
            try {
                DDD = Integer.valueOf(numeros[0]);
                telNumero = Integer.valueOf(numeros[1]);
                if(numeros[1].length()==9) {
                    celular = true;
                }
                if(numeros[1].length()==8) {
                    fixo = true;
                }
            }
            catch(Exception e){
                System.out.println("Telefone inválido.");
            }
            if(celular){
                if((telNumero - 900000000) < 0){
                    erroCel = true;
                }
            }
            if(fixo){
                if((90000000 - telNumero) < 0){
                    erroFixo = true;
                }
            }

            if(!listaDDD.contains(DDD)){
                erroDDD = true;
            }

            if(((telefone.length()-1)==10 || (telefone.length()-1)==11) && (!erroDDD) && (!erroCel) && (!erroFixo)) {
                this.telefone = telefone;
                break;
            }else if((telefone.length()-1)<10){
                System.out.println("Faltam dígitos no número informado.");
            }else if((telefone.length()-1)>11){
                System.out.println("O número informado possui digitos a mais.");
            }else if(erroDDD){
                System.out.println("DDD inválido.");
            }else if(erroCel){
                System.out.println("Telefone móvel deve inicar com 9.");
            }else if(erroFixo){
                System.out.println("Telefone fixo não inicia com 9.");
            }
            System.out.println("Informe um novo número:");
            telefone = scanner.nextLine();
        }while(true);
    }

    public void setNascimento(String nasc){
        Integer mes = 0;
        Integer dia = 0;
        Scanner scanner = new Scanner(System.in);
        boolean erro;
        do {
            erro = false;
            String[] numeros = nasc.split("-");
            try {
                this.anoNascimento = Integer.parseInt(numeros[0]);
                mes = Integer.parseInt(numeros[1]);
                dia = Integer.parseInt(numeros[2]);
            } catch (Exception e) {
                System.out.println("Data registrada incorretamente.");
            }
            if (dia > 31 || dia < 1 || mes > 12 || mes < 1) {
                System.out.println("A data contém erro.");
                erro = true;
            }
            if((mes==4 || mes==6 || mes==9 || mes==11) && (dia==31)){
                System.out.println("Não existe dia 31 neste mês.");
                erro = true;
            }
            if(mes==2 && dia>28){
                System.out.println("O sistema não está preparado para ano bissexto.");
                System.out.println("Ou o valor do dia não existe para fevereiro.");
                erro = true;
            }

            if(!erro){
                this.mesNascimento = mes;
                this.diaNascimento = dia;
                break;
            }else {
                System.out.println("Nova data:");
                nasc = scanner.nextLine();
            }
        }while(erro);
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
