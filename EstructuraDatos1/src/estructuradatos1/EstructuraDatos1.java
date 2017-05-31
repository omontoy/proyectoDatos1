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
    
}
