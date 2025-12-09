public class Ford extends Carro {

    public Ford(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "Ford";
    }
}