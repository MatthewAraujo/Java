
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3307/test";
        String user = "root";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão estabelecida!");

            int option = 1;

            while(option != 0){
                System.out.println("Digite 1 para adicionar um aluno");
                System.out.println("Digite 2 para adicionar um curso");
                System.out.println("Digite 3 para verificar os alunos matriculados em um curso");
                System.out.println("Digite 0 para sair do programa");

                Scanner scan = new Scanner(System.in);
                option = scan.nextInt();
                switch(option){
                    case 1:
                        System.out.println("Digite o número da matrícula do aluno:");
                        String matricula = scan.next();

                        System.out.println("Digite o nome do aluno:");
                        String nome = scan.next();

                        System.out.println("Digite em qual curso você deseja matricular o aluno (código do curso)");
                        showCourses(connection);
                        int codigo = scan.nextInt();

                        Aluno aluno = new Aluno(matricula, nome, codigo);

                        insertStudent(connection, aluno);
                        showStudents(connection);

                        break;


                    case 2:

                        System.out.println("Digite o código do curso:");
                        int codigoCurso = scan.nextInt();

                        System.out.println("Digite o nome do curso:");
                        String nomeCurso = scan.next();

                        System.out.println("Digite a carga horária do curso:");
                        int cargaHoraria = scan.nextInt();

                        Curso curso = new Curso(codigoCurso, nomeCurso, cargaHoraria);

                        insertCourse(connection, curso);
                        showCourses(connection);
                        break;


                    case 3:

                        System.out.println("Digite o código do curso:");
                        showCourses(connection);
                        int opcao = scan.nextInt();
                        showAlunosFromCourse(connection, opcao);
                        break;
                }




            }

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }


    //Método para inserir Aluno no banco de dados
    public static void insertStudent(Connection cn, Aluno a1) {

        try {
            String sql = "INSERT INTO ALUNO VALUES (?, ?, ?)";
            PreparedStatement pStmt = cn.prepareStatement(sql);

            pStmt.setString(1, a1.getMatricula());
            pStmt.setString(2, a1.getNome());
            pStmt.setInt(3, a1.getCodigoCurso());
            pStmt.executeUpdate();
            pStmt.close();

        } catch (SQLException e) {
            System.out.println("Comando SQL falhou!");
            e.printStackTrace();
        }

    }

        //Método para inserir Curso no banco de dados
        public static void insertCourse(Connection cn, Curso c1){

            try {
                String sql = "INSERT INTO CURSO VALUES (?, ?, ?)";
                PreparedStatement pStmt = cn.prepareStatement(sql);

                pStmt.setInt(1, c1.getCodigo());
                pStmt.setString(2, c1.getNome());
                pStmt.setInt(3, c1.getCargaHoraria());
                pStmt.executeUpdate();
                pStmt.close();

            }catch(SQLException e){
                System.out.println("Comando SQL falhou!");
                e.printStackTrace();
            }


    }


    public static void showStudents(Connection cn){

        try {
            String sql = "SELECT * FROM ALUNO";
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Aluno a1 = new Aluno();
                a1.setMatricula(rs.getString("matricula"));
                a1.setNome(rs.getString("nomeAluno"));
                a1.setCodigoCurso(rs.getInt("fk_codigo_curso"));
                System.out.println(a1);
            }


        }catch(SQLException e){
            System.out.println("Comando SQL falhou!");
            e.printStackTrace();
        }
    }




    public static void showCourses(Connection cn){

        try {
            String sql = "SELECT * FROM CURSO";
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Curso c1 = new Curso();
                c1.setCodigo(rs.getInt("codigo"));
                c1.setNome(rs.getString("nomeCurso"));
                c1.setCargaHoraria(rs.getInt("cargaHoraria"));
                System.out.println(c1);
            }


        }catch(SQLException e){
            System.out.println("Comando SQL falhou!");
            e.printStackTrace();
        }
    }

    public static void showAlunosFromCourse(Connection cn, int codigoCurso){

        try {
            String sql = "SELECT * FROM ALUNO WHERE FK_CODIGO_CURSO =" + codigoCurso;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){

                Aluno a1 = new Aluno();
                a1.setMatricula(rs.getString("matricula"));
                a1.setNome(rs.getString("nomeAluno"));
                a1.setCodigoCurso(rs.getInt("fk_codigo_curso"));

                System.out.println(a1);
            }
        }catch(SQLException e){
            System.out.println("Comando SQL falhou!");
            e.printStackTrace();
        }




    }
}
