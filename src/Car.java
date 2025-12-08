public class Car implements Comparable<Car> {
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Car(String marca, String modelo, int ano, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

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
    public int compareTo(Car outro) {
        return this.modelo.compareTo(outro.modelo);
    }

    @Override
    public String toString() {
        return String.format("%s %s (%d) - R$ %.2f",
                marca, modelo, ano, preco);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Car car = (Car) obj;
        return ano == car.ano &&
                marca.equals(car.marca) &&
                modelo.equals(car.modelo);
    }
}
