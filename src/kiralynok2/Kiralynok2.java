package kiralynok2;

import java.io.IOException;

public class Kiralynok2 {

    public static void main(String[] args) throws IOException {
        Tabla tabla = new Tabla('#');
        System.out.println("4. feladat: Az üres tábla:");
        tabla.Megjelenit();
        
        System.out.println("6. feladat: A feltöltött tábla:");
        tabla.Elhelyez(8);
        tabla.Megjelenit();
        
        System.out.println("9. feladat: Üres oszlopok és sorok száma:");
        System.out.println("Oszlopok:" + tabla.UresOszlopokSzama());
        System.out.println("Sorok:" + tabla.UresSorokSzama());
        
        tabla.Fajlbair();
    }
    
}
