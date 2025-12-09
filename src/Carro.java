public abstract class Carro implements Comparable<Carro> {
    private String modelo;
    private int ano;
    private double preco;

    public Carro(String modelo, int ano, double preco) {
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public abstract String getMarca();

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int compareTo(Carro outro) {
        return this.modelo.compareTo(outro.modelo);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) - R$ %.2f",
                getMarca(), modelo, ano, preco);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Carro carro = (Carro) obj;
        return ano == carro.ano &&
                getMarca().equals(carro.getMarca()) &&
                modelo.equals(carro.modelo);
    }
}
