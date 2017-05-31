package estructuradatos1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EstructuraDatos1 {
    static ArrayList<Pair<String, ArrayList<Pair<String, ArrayList<Pair<String,String>>>>>> semestres = new ArrayList<>();
    //static ArrayList<Pair<String, ArrayList<Pair<String,String>>>> cursos = new ArrayList<>();
    //static ArrayList<Pair<String,String>> estudiantes = new ArrayList<>();
    
    public static int buscarSemestre(String s){
        for(int i=0; i<semestres.size(); i++){
            if(semestres.get(i).getFirst().equals(s)) return i;
        }
        return -1;
    }

    public static int buscarCurso(String s, String c){
        int bSem=buscarSemestre(s);
        for(int i=0; i<semestres.get(bSem).getSecond().size(); i++){
            //System.out.println(c+"----"+semestres.get(bSem).getSecond().get(i).getFirst());
            if(semestres.get(bSem).getSecond().get(i).getFirst().equals(c)) return i;
        }
        return -1;
    }
    
    public static int buscarEstudiante(String s, String c, String e){
        int bSem=buscarSemestre(s);
        int bCur=buscarCurso(s, c);
        for(int i=0; i<semestres.get(bSem).getSecond().get(bCur).getSecond().size(); i++){
            if(semestres.get(bSem).getSecond().get(bCur).getSecond().get(i).getFirst().equals(e)) return i;
        }
        return -1;
    }

    public static void printSizes(){
        System.out.println("semestres: "+semestres.size());
        System.out.println("cursos: "+semestres.get(0).getSecond().size());
        System.out.println("estudiantes: "+semestres.get(0).getSecond().get(0).getSecond().size());
    }
    
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
    
    public static void metodo1(String semestre, String curso){
        int sem=buscarSemestre(semestre);
        if(sem!=-1){
            int cur=buscarCurso(semestre, curso);
            if(cur!=-1){
                //System.out.println(semestres.get(sem).getSecond().get(cur).getSecond().size());
                //System.out.println(sem+" "+cur);
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
                    //System.out.println("size curso: " + c + " -> " + semestres.get(bSem).getSecond().size());
                }else{
                    Pair<String,String> est = new Pair(e,n);
                    semestres.get(bSem).getSecond().get(bCur).getSecond().add(est);
                }
            }
        }
        //System.out.println("size semestres: " + semestres.size());
    }
    
    
}
