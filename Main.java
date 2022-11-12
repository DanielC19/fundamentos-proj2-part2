import java.util.Random;
import java.util.Scanner;

public class Main{
    public static Scanner sc = new Scanner(System.in);
    public static Random ran = new Random();
    public static void main(String[] args) {
        int cantidadBichos = ran.nextInt(4) + 1;
        for (int i = 0; i < cantidadBichos; i++) {
            int tipoBicho = ran.nextInt(2) + 1;
            if (tipoBicho == 2) {
                new BichoAliens();
            } else {
                new BichoNormales();
            }
        }
        while (true) {
            if (!continuarJuego()) {
                System.out.println("\n\n¡Fin del juego!\nNo quedan bichos vivos");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
            buildTablero();
            mostrarMenu();
        }
    }

    public static void buildTablero() {
        String[][] pos = new String[2][2];

        for (int i = 0; i < Bicho.bichitos.length; i++) {
            for (int j = 0; j < Bicho.bichitos[i].length; j++) {
                if (Bicho.bichitos[i][j] != null) {
                    if (Bicho.bichitos[i][j].isAlive()) {
                        pos[i][j] = Bicho.bichitos[i][j].getInfo();
                    } else {
                        pos[i][j] = "-----";
                    }                    
                } else {
                    pos[i][j] = "-----";
                }
            }
        }
        System.out.println("\n\n----1-------2----");
        System.out.println("| " + pos[0][0] + " | " + pos[0][1] + " |");
        System.out.println("-----------------");
        System.out.println("| " + pos[1][0] + " | " + pos[1][1] + " |");
        System.out.println("----3-------4----");
    }
    
    public static void mostrarMenu() {
        System.out.println("\n********* MENU DE OPCIONES *********");
        System.out.println("------------------------------------");
        System.out.print("1: Invoca el método Disparar, el cual te permitirá disparar ");
        System.out.println("a una posición que tu selecciones como están en el tablero: 1, 2, 3 ó 4");
        System.out.println("2: Invoca una bomba atómica la cual mata a un bicho en posición aleatoria");
        System.out.println("3: Activa el bicho mutante el cual duplica la salud del bicho que tiene menos salud");
        System.out.println("4: Invoca la frase de la abuelita ");
        System.out.print("Su opción: ");
        int WhileDoAndDoWhile = sc.nextInt();
        if (WhileDoAndDoWhile == 1) {
            while (true) {
                System.out.println("\nElige la posición que quieras atacar");
                int pos = sc.nextInt();
                if (pos > 4 || pos < 1) {
                    System.out.println("Elige una posición válida");
                    continue;
                }
                if (!Bicho.validarAtaque(pos)) {
                    System.out.println("Elige una posición donde haya un bicho vivo");
                } else {
                    break;
                }
            }
        } else if (WhileDoAndDoWhile == 2) {
            Bicho bicho = Bicho.bichoAleatorio();
            bicho.matar();
        } else if (WhileDoAndDoWhile == 3) {
            Bicho bicho = Bicho.menosSalud();
            bicho.mutar();
        } else if (WhileDoAndDoWhile == 4) {
            System.out.println("\nDeme la chancla yo mato a ese malparido");
        } else {
            System.out.println("\nElige una opción válida");
        }   
    } 

    public static boolean continuarJuego() {
        int counter = 0;
        for (Bicho[] bichos : Bicho.bichitos) {
            for (Bicho bicho : bichos) {
                if (bicho != null) {
                    if (bicho.isAlive()) {
                        counter++;
                    }
                }
            }
        }
        return counter != 0;
    }
}