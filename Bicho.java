import java.util.Random;

public class Bicho {
    private int salud;
    public static Bicho[][] bichitos = new Bicho[2][2];

    public Bicho(int salud) {
        this.salud = salud;

        boolean agregado = false;
        for (int i = 0; i < bichitos.length; i++) {
            for (int j = 0; j < bichitos[i].length; j++) {
                if (bichitos[i][j] == null) {
                    bichitos[i][j] = this;
                    agregado = true;
                    break;
                }
            }
            if (agregado) {
                break;
            }
        }
    }

    /**
     * * Opciones de juego
     */
    public void ataque() {
        this.setSalud(this.salud - 5);
    }

    public void matar() {
        this.setSalud(0);
    }

    public void mutar() {
        this.setSalud(this.salud * 2);
    }

    public static Bicho menosSalud() {
        Bicho bichoMenor = bichitos[0][0];
        for (Bicho[] bichos : bichitos) {
            for (Bicho bicho : bichos) {
                if (bicho != null) {
                    if (bicho.getSalud() < bichoMenor.getSalud() && bicho.isAlive()) {
                        bichoMenor = bicho;
                    }                       
                }
            }
        }
        return bichoMenor;
    }

    public static Bicho bichoAleatorio() {
        Random ran = new Random();
        Bicho bicho = Bicho.bichitos[ran.nextInt(2)][ran.nextInt(2)];
        if (bicho == null) {
            return bichoAleatorio();
        }
        return bicho;
    }

    public static boolean validarAtaque(int pos) {
        if (pos == 1) {
            if (bichitos[0][0] != null) {
                if (bichitos[0][0].isAlive()) {
                    bichitos[0][0].ataque();
                    return true;
                }
            }
        }
        if (pos == 2) {
            if (bichitos[0][1] != null) {
                if (bichitos[0][1].isAlive()) {
                    bichitos[0][1].ataque();
                    return true;
                }
            }
        }
        if (pos == 3) {
            if (bichitos[1][0] != null) {
                if (bichitos[1][0].isAlive()) {
                    bichitos[1][0].ataque();
                    return true;
                }
            }
        }
        if (pos == 4) {
            if (bichitos[1][1] != null) {
                if (bichitos[1][1].isAlive()) {
                    bichitos[1][1].ataque();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * * SETTERS Y GETTERS
     */
    public int getSalud() {
        return salud;
    }
    public void setSalud(int salud) {
        this.salud = salud;
    }
    public String getInfo() {
        return "B-" + getSalud();
    }
    // Revisar que esté vivo
    public boolean isAlive() {
        return this.salud > 0;
    }

}
