package Modelos;

import java.util.ArrayList;

public class ListaInvertida {

    private ArrayList subCategorias;
    private ArrayList<ArrayList> elementos;

    public ListaInvertida (){
        this.subCategorias = new ArrayList<String>();
        this.elementos= new ArrayList<ArrayList>();
    }

    public ArrayList getSubCategorias() {
        return subCategorias;
    }

    public void setSubCategorias(ArrayList subCategorias) {
        this.subCategorias = subCategorias;
    }

    public ArrayList<ArrayList> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<ArrayList> elementos) {
        this.elementos = elementos;
    }

    //adiciona a pessoa dentro da subcategoria do diretorio referente
    public void adiciona(Integer id, String subcategoria){

        //verifico se ja existe a subcategoria desejada
        if(!subCategorias.contains(subcategoria)){

            //se nao existir, crio ela em um array de referencia
            subCategorias.add(subcategoria);

            //e crio no outro array uma estrutura pra armazenar os indices daquela categoria
            ArrayList<Integer> novaSubCategoria = new ArrayList<Integer>();
            elementos.add(novaSubCategoria);
        }

        //pego o array de indices da categoria
        ArrayList subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

        //verifico se o elemento a ser adicionado ja existe na lista ou nao
        if (!subcategoriaEscolhida.contains(id)){

            //adiciona o id a categoria desejada
            subcategoriaEscolhida.add(id);
        }else {
            System.out.println("o elemento ja esta na lista");
        }
    }

    //metodo para deletar o id da subcategoria referente ao diretorio
    public void deleta (Integer id, String subcategoria){

        //verifico se a subcategoria existe
        if(subCategorias.contains(subcategoria)) {

            //pego o array de indices da categoria
            ArrayList<Integer> subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

            //vejo de o id esta na lista
            if (subcategoriaEscolhida.contains(id)) {

                //remove o id escolhido
                subcategoriaEscolhida.remove(subcategoriaEscolhida.indexOf(id));
            } else {
                System.out.println("o elemento nao esta na lista");
            }
        }
    }

    //apos deletar e necessario ajustar os indices da subcategoria do item deletado
    public void ajusta (Integer id, String subcategoria){

        //verifico se a subcategoria existe
        if(subCategorias.contains(subcategoria)) {

            //pego o array de indices da categoria
            ArrayList<Integer> subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

            //verifico se a categoria possui o id
            if (subcategoriaEscolhida.contains(id)) {

                //removo o id antigo
                subcategoriaEscolhida.remove(subcategoriaEscolhida.indexOf(id));

                //adiciono o novo id referente aquela pessoa
                subcategoriaEscolhida.add(id - 1);
            } else {
                System.out.println("o elemento nao esta na lista");
            }
        }
    }

    //metodo para buscar os ids referentes a uma categoria
    public ArrayList consulta(String subcategoria){

        //verifico se a categoria existe no diretorio
        if(subCategorias.contains(subcategoria)){

            //pego o array de indices da categoria
            ArrayList subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));
            return subcategoriaEscolhida;
        }
        return null;
    }
}
