package Tela;

import Controlador.Controlador;
import Modelos.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class TelaPrincipal {

    private Controlador ctrl;
    private Scanner teclado;

    public TelaPrincipal(){
        ctrl = new Controlador();
        teclado = new Scanner(System.in);
    }

    public static void main(String[] args){
        TelaPrincipal tela = new TelaPrincipal();
        tela.opcoes();
    }

    public void opcoes(){
        System.out.println(" 1 - Adiciona pessoa \n 2 - Deleta pessoa \n 3 - Mostra pessoas atuais\n 4 - Buscar por categoria simples\n 5 - Buscar por categoria composta\n 4 - Adicionar varias pessoas\n 7 - Adicionar dados padrao");
        switch (teclado.nextInt()){
            case 1:
                System.out.println("Digite a matricula");
                int matricula = teclado.nextInt();
                System.out.println("Digite o nome:");
                String nome = teclado.next();
                System.out.println("Digite a idade");
                String idade = teclado.next();
                System.out.println("Digite a cidade de origem");
                String cidade = teclado.next();
                System.out.println("Digite o curso");
                String curso = teclado.next();

                ctrl.criaPessoa(matricula, nome, curso, cidade, idade);

                opcoes();
                break;
            case 2:
                System.out.println("Digite o ID");
                int id = teclado.nextInt();
                ctrl.deletaPessoa(id);
                opcoes();
                break;
            case 3:
                String msg = "";
                ArrayList<Pessoa> pessoas = ctrl.getPessoas();
                for (Pessoa pessoa : pessoas){
                    msg += "Id: " + pessoa.getId();
                    msg += "\nNome: " + pessoa.getNome();
                    msg += "\nCidade de Origem: " + pessoa.getCidadeOrigem();
                    msg += "\nCurso: " + pessoa.getCurso();
                    msg += "\nIdade: " + pessoa.getIdade();
                    msg += "\n\n";
                }
                System.out.println(msg);
                opcoes();
                break;
            case 4:
                System.out.println("Digite o parametro desejado");

                msg = "";
                pessoas = ctrl.buscaSimples(teclado.next());;
                for (Pessoa pessoa : pessoas){
                    msg += "Id: " + pessoa.getId();
                    msg += "\nNome: " + pessoa.getNome();
                    msg += "\nCidade de Origem: " + pessoa.getCidadeOrigem();
                    msg += "\nCurso: " + pessoa.getCurso();
                    msg += "\nIdade: " + pessoa.getIdade();
                    msg += "\n\n";
                }
                System.out.println(msg);
                opcoes();
                break;
            case 5:
                System.out.println("Digite o primeiro parametro desejado");
                String param1 = teclado.next();
                System.out.println("Digite o segundo parametro desejado");
                String param2 = teclado.next();
                msg = "";
                pessoas = ctrl.buscaComposta(param1, param2);;
                for (Pessoa pessoa : pessoas){
                    msg += "Id: " + pessoa.getId();
                    msg += "\nNome: " + pessoa.getNome();
                    msg += "\nCidade de Origem: " + pessoa.getCidadeOrigem();
                    msg += "\nCurso: " + pessoa.getCurso();
                    msg += "\nIdade: " + pessoa.getIdade();
                    msg += "\n\n";
                }
                System.out.println(msg);
                opcoes();
                break;
            case 6:
                System.out.println("Quantas pessoas deseja adicionar?");
                int nLoops = teclado.nextInt();
                for (int i = nLoops; i>0; i--) {
                    System.out.println("Digite a matricula");
                    matricula = teclado.nextInt();
                    System.out.println("Digite o nome:\n");
                    nome = teclado.next();
                    System.out.println("Digite a idade");
                    idade = teclado.next();
                    System.out.println("Digite a cidade de origem");
                    cidade = teclado.next();
                    System.out.println("Digite o curso");
                    curso = teclado.next();

                    ctrl.criaPessoa(matricula, nome, curso, cidade, idade);
                }
                opcoes();
                break;
            case 7:
                ctrl.criaPessoa(1720, "guilherme", "sistemas", "osasco", "19");
                ctrl.criaPessoa(1810, "lucas", "computacao", "floripa", "19");
                ctrl.criaPessoa(1721, "roberto", "sistemas", "palhoca", "19");
                ctrl.criaPessoa(1722, "gabriel", "computacao", "osasco", "25");
                ctrl.criaPessoa(1733, "pedro", "sistemas", "floripa", "20");
                ctrl.criaPessoa(1820, "luiza", "engenharia", "palhoca", "25");
                ctrl.criaPessoa(1510, "cintia", "sistemas", "floripa", "23");
                ctrl.criaPessoa(1590, "caroline", "engenharia", "sao jose", "21");
                ctrl.criaPessoa(1520, "victor", "sistemas", "biguacu", "20");
                ctrl.criaPessoa(1920, "jose", "sistemas", "floripa", "25");
                opcoes();
                break;
        }
    }
}
