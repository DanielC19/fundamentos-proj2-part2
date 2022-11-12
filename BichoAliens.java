public class BichoAliens extends Bicho {
    public BichoAliens(){
        super(20);
    }

    public String getInfo() {
        return "BA-" + getSalud();
    }
}
