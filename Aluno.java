public class Aluno {


    private String matricula;
    private String nome;

    private int codigoCurso;

    public Aluno(String matricula, String nome, int codigoCurso) {
        this.matricula = matricula;
        this.nome = nome;
        this.codigoCurso = codigoCurso;
    }

    public Aluno(){

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
