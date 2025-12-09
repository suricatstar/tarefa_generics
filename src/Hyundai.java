public class Hyundai extends Carro {

    public Hyundai(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "Hyundai";
    }
}