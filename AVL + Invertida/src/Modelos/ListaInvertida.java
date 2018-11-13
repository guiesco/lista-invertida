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

    public void adiciona(int id, String subcategoria){
        if(!subCategorias.contains(subcategoria)){
            subCategorias.add(subcategoria);
            ArrayList novaSubCategoria = new ArrayList();
            elementos.add(novaSubCategoria);
        }

        ArrayList subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

        if (!subcategoriaEscolhida.contains(id)){
            subcategoriaEscolhida.add(id);
        }else {
            System.out.println("o elemento ja esta na lista");
        }
    }

    public void deleta (int id, String subcategoria){
        if(!subCategorias.contains(subcategoria)){
            System.out.println("A categoria nao existe");
        }else{
            ArrayList subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

            if (!subcategoriaEscolhida.contains(id)){
                subcategoriaEscolhida.remove(id);
            }else {
                System.out.println("o elemento nao esta na lista");
            }
        }


    }

    public ArrayList consulta(String subcategoria){
        if(!subCategorias.contains(subcategoria)){
            System.out.println("A categoria nao existe");
        }else{
            ArrayList subcategoriaEscolhida = elementos.get(subCategorias.indexOf(subcategoria));

            return subcategoriaEscolhida;
        }
        return null;
    }
}
