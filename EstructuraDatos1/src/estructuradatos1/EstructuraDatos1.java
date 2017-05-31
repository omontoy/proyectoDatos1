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
    
}
