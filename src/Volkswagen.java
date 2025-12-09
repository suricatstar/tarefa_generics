public class Volkswagen extends Carro {

    public Volkswagen(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "Volkswagen";
    }
}