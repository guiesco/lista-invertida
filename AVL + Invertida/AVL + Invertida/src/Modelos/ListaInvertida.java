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

    public void adiciona(Integer id, String subcategoria){
        if(!subCategorias.contains(subcategoria)){
            subCategorias.add(subcategoria);
            ArrayList<Integer> novaSubCategoria = new ArrayList<Integer>();
            elementos.add(novaSubCategoria);
        }

        ArrayList subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

        if (!subcategoriaEscolhida.contains(id)){
            subcategoriaEscolhida.add(id);
        }else {
            System.out.println("o elemento ja esta na lista");
        }
    }

    public void deleta (Integer id, String subcategoria){
        if(subCategorias.contains(subcategoria)) {
            ArrayList<Integer> subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

            if (subcategoriaEscolhida.contains(id)) {
                subcategoriaEscolhida.remove(subcategoriaEscolhida.indexOf(id));
            } else {
                System.out.println("o elemento nao esta na lista");
            }
        }
    }

    public void ajusta (Integer id, String subcategoria){
        if(subCategorias.contains(subcategoria)) {
            ArrayList<Integer> subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

            if (subcategoriaEscolhida.contains(id)) {
                subcategoriaEscolhida.remove(subcategoriaEscolhida.indexOf(id));
                subcategoriaEscolhida.add(id - 1);
            } else {
                System.out.println("o elemento nao esta na lista aj " + id);
            }
        }
    }

    public ArrayList consulta(String subcategoria){
        if(subCategorias.contains(subcategoria)){
            ArrayList subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

            return subcategoriaEscolhida;
        }
        return null;
    }
}
