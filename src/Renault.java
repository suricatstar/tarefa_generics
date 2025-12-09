public class Renault extends Carro {

    public Renault(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "Renault";
    }
}