package Modelos;

public class Pessoa {

    private int id;

    private int matricula;
    private String nome;
    private String curso;
    private String cidadeOrigem;
    private String idade;

    public Pessoa (int matricula, String nome, String curso, String cidadeOrigem, String idade){
        this.matricula = matricula;
        this.cidadeOrigem = cidadeOrigem;
        this.nome = nome;
        this.curso = curso;
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
