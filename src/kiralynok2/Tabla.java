package kiralynok2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Tabla {
    
    private char [][]T;
    private char UresCella;

    public Tabla(char UresCella) {
        T = new char[8][8];
        this.UresCella = UresCella;
        feltolt();
    }
    
    public void feltolt(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                T[i][j] = UresCella;
            }
        }
    }
    
    public void Elhelyez(int n){
        int i = 0;
        while (i < n){
            int sor = (int)(Math.random()*8);
            int oszlop = (int)(Math.random()*8);
            if(T[sor][oszlop] != 'K'){
                T[sor][oszlop] = 'K';
                i++;
            }
        }
    }
    
    public void Megjelenit(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(T[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public void Tabla(){
        
    }
    public boolean UresOszlop(int sor){
        int i = 0;
        while(i < T.length && !(T[sor][i] == 'K')){
            i++;
        }
        return i >= T.length;
    }
    public boolean UresSor(int oszlop){
        int i = 0;
        while(i < T.length && !(T[i][oszlop] == 'K')){
            i++;
        }
        return i >= T.length;
    }
    
    public int UresOszlopokSzama(){
        int db = 0;
        for (int i = 0; i < 8; i++) {
            if(UresOszlop(i)){
                db++;
            }
        }
        return db;
    }
    
    public int UresSorokSzama(){
        int db = 0;
        for (int i = 0; i < 8; i++) {
            if(UresSor(i)){
                db++;
            }
        }
        return db;
    }
    
    public void Fajlbair() throws IOException{
        String fn = "tablak64.txt";
        Path path = Paths.get(fn);
        if(Files.exists(path)){
            Files.delete(path);
        }
        
        String tartalom = "";
        for (int i = 1; i <= 64; i++) {
            Tabla t = new Tabla('*');
            t.Elhelyez(i);
            tartalom += t.toString() + "\n";
        }
        
        Files.write(path,tartalom.getBytes());
        
    }

    @Override
    public String toString() {
        
        String s = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                s += T[i][j];
            }
            s += "\n";
        }
        
        return s;
    }
    
}
