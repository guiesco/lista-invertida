package Controlador;

import Modelos.ListaInvertida;
import Modelos.Pessoa;

import java.util.ArrayList;

public class Controlador {

    private ArrayList<Pessoa> pessoas;
    private ListaInvertida dirCursos;
    private ListaInvertida dirCidade;
    private ListaInvertida dirIdade;

    public Controlador(){
        pessoas = new ArrayList();
        dirCidade = new ListaInvertida();
        dirCursos = new ListaInvertida();
        dirIdade = new ListaInvertida();
    }

    //Cria uma nova entidade pessoa, coloca ela na lista geral e nos lugares devidos de diretorios
    public void criaPessoa (int matricula, String nome, String curso, String cidadeOrigem, String idade){
        //cria a instancia da pessoa nova
        Pessoa novaPessoa = new Pessoa(matricula,nome, curso, cidadeOrigem, idade);

        //adiciona a pessoa no array de pessoas
        pessoas.add(novaPessoa);

        //coloca a posicao do array como ID da pessoa
        novaPessoa.setId(pessoas.indexOf(novaPessoa));

        //busca o ID que acabou de ser atribuido
        int id = novaPessoa.getId();

        //adiciona o ID da pessoa nos respectivos diretorios
        dirIdade.adiciona(id, novaPessoa.getIdade());
        dirCursos.adiciona(id, novaPessoa.getCurso());
        dirCidade.adiciona(id, novaPessoa.getCidadeOrigem());

        //printa o id atribuido
        System.out.println("Seu id é " + id);
    }

    //Deleta uma pessoa
    public void deletaPessoa(int id){
        //busca a instancia da pessoa a ser removida
        Pessoa pessoaRemovida = pessoas.get(id);

        //retira a referencia ao id da pessoa removida nos diretorios
        dirCidade.deleta(id, pessoaRemovida.getCidadeOrigem());
        dirCursos.deleta(id, pessoaRemovida.getCurso());
        dirIdade.deleta(id,pessoaRemovida.getIdade());

        //passa nas pessoas depois da que foi removida para reajustar o id com a posicao no arraylist
        for (int i = id; i<pessoas.size(); i++){
            //busca a pessoa a qual o id deve ser ajustado
            Pessoa diminuiID = pessoas.get(i);

            //o novo id deve ser um valor a menos
            int novoId = diminuiID.getId() - 1;

            //seto o novo id no objeto
            diminuiID.setId(novoId);

            //ajusto os novos ids nos respectivos diretorios que pertencem
            dirCidade.ajusta(i, diminuiID.getCidadeOrigem());
            dirCursos.ajusta(i, diminuiID.getCurso());
            dirIdade.ajusta(i, diminuiID.getIdade());
        }
        //remove a pessoa do array
        pessoas.remove(pessoaRemovida);
    }

    //Busca com um parametro, retorna a lista com todas as pessoas daquela categoria
    public ArrayList<Pessoa> buscaSimples (String categoriaDesejada){
        //cria um array para juntar os resultados da busca
        ArrayList<Pessoa> resultadoBusca = new ArrayList<>();

        //verifica se a categoria desejada e eh do diretorio referente
        ArrayList<Integer> categoria = dirCursos.consulta(categoriaDesejada);

        //se for, retorna uma lista com os indices de quem pertence a categoria
        if (categoria!=null){
            for (int id : categoria){
                //para cada id na lista da categoria, adiciono o objeto que esta na lista pessoa ao array de resultado
                resultadoBusca.add(pessoas.get(id));
            }
        }
        categoria = dirCidade.consulta(categoriaDesejada);
        if (categoria!=null) {
            for (int id : categoria){
                resultadoBusca.add(pessoas.get(id));
            }
        }
        categoria = dirIdade.consulta(categoriaDesejada);
        if (categoria!=null){
            for (int id : categoria){
                resultadoBusca.add(pessoas.get(id));
            }
        }

        return resultadoBusca;
    }

    //Busca com dois parametros, retorna a lista com todas as pessoas daquelas categorias
    public ArrayList<Pessoa> buscaComposta (String categoriaDesejada1, String categoriaDesejada2){
        //cria um array para juntar os resultados da busca
        ArrayList<Pessoa> resultadoBusca = new ArrayList<>();


        //verifico se o primeiro parametro esta no diretorio referente
        ArrayList<Integer> categoria1 = dirCursos.consulta(categoriaDesejada1);
        if (categoria1!=null){
            //se pertencer ao diretorio, faco uma busca simples pela outra categoria
            ArrayList<Pessoa> buscaParcial = buscaSimples(categoriaDesejada2);

            //verifico os ids resultado da busca simples feita
            for (Pessoa pessoa : buscaParcial){
                //se o id estiver presente na primeira lista, a pessoa eh adicionada ao array resposta
                if (categoria1.contains(pessoa.getId())) {
                    resultadoBusca.add(pessoa);
                }
            }
        }

        categoria1 = dirCidade.consulta(categoriaDesejada1);
        if (categoria1!=null) {
            ArrayList<Pessoa> buscaParcial = buscaSimples(categoriaDesejada2);

            for (Pessoa pessoa : buscaParcial){
                if (categoria1.contains(pessoa.getId())) {
                    resultadoBusca.add(pessoa);
                }
            }
        }

        categoria1 = dirIdade.consulta(categoriaDesejada1);
        if (categoria1!=null){
            ArrayList<Pessoa> buscaParcial = buscaSimples(categoriaDesejada2);

            for (Pessoa pessoa : buscaParcial){
                if (categoria1.contains(pessoa.getId())) {
                    resultadoBusca.add(pessoa);
                }
            }
        }

        return resultadoBusca;
    }

    public ArrayList<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(ArrayList pessoas) {
        this.pessoas = pessoas;
    }

    public ListaInvertida getDirCursos() {
        return dirCursos;
    }

    public void setDirCursos(ListaInvertida dirCursos) {
        this.dirCursos = dirCursos;
    }

    public ListaInvertida getDirCidade() {
        return dirCidade;
    }

    public void setDirCidade(ListaInvertida dirCidade) {
        this.dirCidade = dirCidade;
    }

    public ListaInvertida getDirIdade() {
        return dirIdade;
    }

    public void setDirIdade(ListaInvertida dirIdade) {
        this.dirIdade = dirIdade;
    }
}
