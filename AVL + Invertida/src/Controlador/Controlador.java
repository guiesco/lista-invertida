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
        Pessoa novaPessoa = new Pessoa(matricula,nome, curso, cidadeOrigem, idade);

        pessoas.add(novaPessoa);

        novaPessoa.setId(pessoas.indexOf(novaPessoa));

        int id = novaPessoa.getId();

        dirIdade.adiciona(id, novaPessoa.getIdade());
        dirCursos.adiciona(id, novaPessoa.getCurso());
        dirCidade.adiciona(id, novaPessoa.getCidadeOrigem());

        System.out.println("Seu id eh " + id);
    }

    public void deletaPessoaMatricula (int matricula){
        for (Pessoa pessoa : pessoas){
            if (pessoa.getMatricula() == matricula){
                deletaPessoa(pessoa.getId());
            }
        }
    }

    public void deletaPessoa(int id){
        Pessoa pessoaRemovida = pessoas.remove(id);
        dirCidade.deleta(id, pessoaRemovida.getCidadeOrigem());
        dirCursos.deleta(id, pessoaRemovida.getCurso());
        dirIdade.deleta(id,pessoaRemovida.getIdade());
    }

    public ArrayList<Pessoa> buscaSimples (String categoriaDesejada){
        ArrayList<Pessoa> resultadoBusca = new ArrayList<>();

        ArrayList<Integer> categoria = dirCursos.consulta(categoriaDesejada);
        if (categoria!=null){
            for (int id : categoria){
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

    public ArrayList<Pessoa> buscaComposta (String categoriaDesejada1, String categoriaDesejada2){
        ArrayList<Pessoa> resultadoBusca = new ArrayList<>();

        ArrayList<Integer> categoria1 = dirCursos.consulta(categoriaDesejada1);
        if (categoria1!=null){
            ArrayList<Pessoa> buscaParcial = buscaSimples(categoriaDesejada2);

            for (Pessoa pessoa : buscaParcial){
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
