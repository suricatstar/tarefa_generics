public class Chevrolet extends Carro {

    public Chevrolet(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "Chevrolet";
    }
}