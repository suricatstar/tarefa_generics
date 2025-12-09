public class Fiat extends Carro {

    public Fiat(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "Fiat";
    }
}