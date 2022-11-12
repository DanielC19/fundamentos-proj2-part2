public class BichoNormales extends Bicho {
    public BichoNormales() {
        super(10);
    }
    
    public String getInfo() {
        return "BN-" + getSalud();    
    }
}