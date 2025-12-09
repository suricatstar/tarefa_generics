public class Toyota extends Carro {

    public Toyota(String modelo, int ano, double preco) {
        super(modelo, ano, preco);
    }

    @Override
    public String getMarca() {
        return "Toyota";
    }
}