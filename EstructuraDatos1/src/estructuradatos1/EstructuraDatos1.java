package estructuradatos1;

/**
 * @author Orlando Montoya
 * @author Valeria Castro
 * Esta clase me representa la estructura de datos creada
 * para resolver el problema en el que una universidad
 * necesita almacenar un conjunto de datos de manera óptima.
 * Se utilizan bibliotecas para la lectura de archivos,
 * manejo de excepciones y listas dinámicas.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EstructuraDatos1 {
    /**
     * Esta es la base inicial de la estructura a utilizar,
     * la cual es una lista de semestres con su nombre, 
     * que guarda una lista de cursos con sus nombres,
     * y estos cursos a su vez guardan los el nombre
     * y la nota de los estudiantes que hay matriculados.
     */
    static ArrayList<Pair<String, ArrayList<Pair<String, ArrayList<Pair<String,String>>>>>> semestres = new ArrayList<>();
    
    /**
     * Este método permite buscar un semestre.
     * Si el semestre existe, entonces retorna su posición,
     * si no existe retorn -1 en su lugar.
     * @param s se ingresa el semestre que se quiere buscar.
     * @return un entero dependiendo si existe o no el semestre a buscar.
     */
    public static int buscarSemestre(String s){
        for(int i=0; i<semestres.size(); i++){
            if(semestres.get(i).getFirst().equals(s)) return i;
        }
        return -1;
    }
    
    /**
     * Este método permite buscar un curso en un semestre dado.
     * @param s semestre en el que se quiere buscar el curso.
     * @param c curso que se quiere buscar.
     * @return devuelve la posición en dónde está el curso, de no existir, retorna -1.
     */
    public static int buscarCurso(String s, String c){
        int bSem=buscarSemestre(s);
        for(int i=0; i<semestres.get(bSem).getSecond().size(); i++){
            if(semestres.get(bSem).getSecond().get(i).getFirst().equals(c)) return i;
        }
        return -1;
    }
    
    /**
     * Este método permite buscar un estudiante en un curso de un semestre dado.
     * @param s semestre en dónde está el curso en el que se quiere buscar el estudiante.
     * @param c curso en el que se quiere buscar el semestre.
     * @param e estudiante que se quiere buscar.
     * @return devuelve la posición en dónde está el estudiante, de no existir, retorna -1.
     */
    public static int buscarEstudiante(String s, String c, String e){
        int bSem=buscarSemestre(s);
        int bCur=buscarCurso(s, c);
        for(int i=0; i<semestres.get(bSem).getSecond().get(bCur).getSecond().size(); i++){
            if(semestres.get(bSem).getSecond().get(bCur).getSecond().get(i).getFirst().equals(e)) return i;
        }
        return -1;
    }
    
    /**
     * Este método me imprime los tamaños de las listas de arreglos, cursos y estudiantes.
     * Es utilizado principalmente para pruebas.
     */
    public static void printSizes(){
        System.out.println("semestres: "+semestres.size());
        System.out.println("cursos: "+semestres.get(0).getSecond().size());
        System.out.println("estudiantes: "+semestres.get(0).getSecond().get(0).getSecond().size());
    }
    
    /**
     * Este método me imprime en consola todos y cada uno de los datos
     * que se han almacenado en la estructura hasta el momento.
     * Se utilizó principalmente para pruebas.
     */
    public static void imprimir(){
        for(int i=0; i<semestres.size(); i++){
            System.out.println("Semetre: " + semestres.get(i).getFirst());
            for(int j=0; j<semestres.get(i).getSecond().size(); j++){
                System.out.println("    Curso: "+semestres.get(i).getSecond().get(j).getFirst());
                for(int k=0; k<semestres.get(i).getSecond().get(j).getSecond().size(); k++){
                    System.out.print("        Estudiante: "+semestres.get(i).getSecond().get(j).getSecond().get(k).getFirst());
                    System.out.println(" ----> Nota final: "+semestres.get(i).getSecond().get(j).getSecond().get(k).getSecond());
                }
            }
        }
    }
    
    /**
     * Este método era uno de los pedidos en el proyecto, el cual tiene la siguiente descripción:
     * Dado un curso y un semestre del año, mostrar todos los estudiantes matriculados,
     * y la nota final de cada uno.
     * En caso de no existir el semestre o el curso a consultar, se notificará al usuario.
     * @param semestre semestre a consultar.
     * @param curso curso a consultar.
     */
    public static void metodo1(String semestre, String curso){
        int sem=buscarSemestre(semestre);
        if(sem!=-1){
            int cur=buscarCurso(semestre, curso);
            if(cur!=-1){
                for(int i=0; i<semestres.get(sem).getSecond().get(cur).getSecond().size(); i++){
                    System.out.print("Estudiante: "+semestres.get(sem).getSecond().get(cur).getSecond().get(i).getFirst());
                    System.out.println(" --- Nota final: "+semestres.get(sem).getSecond().get(cur).getSecond().get(i).getSecond());
                }
            }else{
                System.out.println("El curso "+curso+" no existe.");
            }
        }else{
            System.out.println("El semestre "+semestre+" no existe.");
        }
    }
    
    /**
     * Este método era uno de los pedidos en el proyecto, el cual tiene la siguiente descripción:
     * Dado un estudiante y un semestre del año, mostrar todos los cursos en los que está
     * matriculado y la nota final en cada uno de ellos.
     * En caso de que no exista el semestre o el estudiante, se notificará al usuario.
     * @param semestre semestre a consultar.
     * @param estudiante estudiante a consultar.
     */
    public static void metodo2(String semestre, String estudiante){
        boolean e=false;
        int sem=buscarSemestre(semestre);
        if(sem!=-1){
            for(int i=0; i<semestres.get(sem).getSecond().size(); i++){
                for(int j=0; j<semestres.get(sem).getSecond().get(i).getSecond().size(); j++){
                    if(semestres.get(sem).getSecond().get(i).getSecond().get(j).getFirst().equals(estudiante)){
                        System.out.print("Curso: "+semestres.get(sem).getSecond().get(i).getFirst());
                        System.out.println(" --- Nota final: "+semestres.get(sem).getSecond().get(i).getSecond().get(j).getSecond());
                        e=true;
                    }
                }
            }
            if(!e) System.out.println("El estudiante "+estudiante+" no existe");
        }else{
            System.out.println("El semestre "+semestre+" no existe.");
        }
    }
    
    /**
     * Este método se utiliza para guardar un dato a la estructura y funciona así:
     * dados los datos necesarios que son el semestre, el curso, el estudiante y su nota
     * almacenelos de la forma adecuada en la estructura.
     * @param s semestre a guardar
     * @param c curso a guardar
     * @param e estudiante a guardar
     * @param n nota a guardar
     */
    public static void guardar(String s, String c, String e, String n){
        if(semestres.isEmpty()){
            Pair<String,String> est = new Pair(e,n);
            ArrayList<Pair<String,String>> cur = new ArrayList<>();
            cur.add(est);
            Pair<String,ArrayList<Pair<String,String>>> curs = new Pair(c,cur);
            ArrayList<Pair<String, ArrayList<Pair<String,String>>>> sem= new ArrayList<>();
            sem.add(curs);
            Pair<String, ArrayList<Pair<String, ArrayList<Pair<String,String>>>>> semes = new Pair(s,sem);
            semestres.add(semes);
        }else{
            int bSem=buscarSemestre(s);
            if(bSem==-1){
                Pair<String,String> est = new Pair(e,n);
                ArrayList<Pair<String,String>> cur = new ArrayList<>();
                cur.add(est);
                Pair<String,ArrayList<Pair<String,String>>> curs = new Pair(c,cur);
                ArrayList<Pair<String, ArrayList<Pair<String,String>>>> sem= new ArrayList<>();
                sem.add(curs);
                Pair<String, ArrayList<Pair<String, ArrayList<Pair<String,String>>>>> semes = new Pair(s,sem);
                semestres.add(semes);
            }else{
                int bCur=buscarCurso(s, c);
                if(bCur==-1){
                    Pair<String,String> est = new Pair(e,n);
                    ArrayList<Pair<String,String>> cur = new ArrayList<>();
                    cur.add(est);
                    Pair<String,ArrayList<Pair<String,String>>> curs = new Pair(c,cur);
                    semestres.get(bSem).getSecond().add(curs);
                }else{
                    Pair<String,String> est = new Pair(e,n);
                    semestres.get(bSem).getSecond().get(bCur).getSecond().add(est);
                }
            }
        }
    }
    
    /**
     * Utilizamos un archivo con un formato predefinido y guardamos los datos
     * que hay en este en la estructura.
     */
    public static void leer(){
        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/MONTOYA/Documents/EstructuraDatos1/notas.txt"))){
            String linea = br.readLine();
            while(!linea.isEmpty()){
                String datos[] = linea.split(";");
                String estudiante = datos[0];
                String semestre = datos[1];
                String curso = datos[2];
                String nota = datos[3];
                guardar(semestre, curso, estudiante, nota);
                linea = br.readLine();
                if(linea == null){
                    break;
                }
            }
        }catch(IOException e){
            System.out.println("Error al leer el fichero: "+e.getMessage());
        }
    }
    
    /**
     * Método principal para controlar las acciones del usuario y para cargar
     * inicialmente la estructura con una base de datos.
     * @param args 
     */
    public static void main(String[] args) {
        leer();
        Scanner sc = new Scanner(System.in);
        System.out.println("BIENVENIDO AL SISTEMA DE NOTAS DE LA UNIVERSIDAD");
        while (true) {
            System.out.println();
            System.out.println("DIGITE LA OPCIÓN QUE DESEA");
            System.out.println("1. Método 1");
            System.out.println("2. Método 2");
            System.out.println("3. Salir");
            System.out.println();
            System.out.print("---> ");
            String metodo = sc.nextLine();
            if (metodo.equals("1")) {
                System.out.println("------------------");
                System.out.print("INGRESE EL SEMESTRE: ");
                String semest = sc.nextLine();
                System.out.print("INGRESE EL CURSO: ");
                String curs = sc.nextLine();
                //System.out.println(curs);
                metodo1(semest, curs);
                System.out.println("---------------------------------------------");
            }
            if (metodo.equals("2")) {
                System.out.println("------------------");
                System.out.print("INGRESE EL SEMESTRE: ");
                String semest = sc.nextLine();
                System.out.print("INGRESE EL ESTUDIANTE: ");
                String estud = sc.nextLine();
                metodo2(semest, estud);
                System.out.println("---------------------------------------------");
            }
            if (metodo.equals("3")) {
                break;
            }
        }
    }
    
}
