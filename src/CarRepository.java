import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarRepository<T extends Car> {
    private List<T> carros;

    public CarRepository() {
        this.carros = new ArrayList<>();
    }

    // Adicionar carro
    public void adicionar(T carro) {
        carros.add(carro);
        System.out.println("✓ Carro adicionado: " + carro.getModelo());
    }

    // Adicionar múltiplos carros
    public void adicionarTodos(List<? extends T> listaCarros) {
        carros.addAll(listaCarros);
        System.out.println("✓ " + listaCarros.size() + " carros adicionados");
    }

    // Remover carro
    public boolean remover(T carro) {
        boolean removido = carros.remove(carro);
        if (removido) {
            System.out.println("✓ Carro removido: " + carro.getModelo());
        }
        return removido;
    }

    // Buscar por marca
    public List<T> buscarPorMarca(String marca) {
        return carros.stream()
                .filter(c -> c.getMarca().equalsIgnoreCase(marca))
                .collect(Collectors.toList());
    }

    // Buscar por ano
    public List<T> buscarPorAno(int ano) {
        return carros.stream()
                .filter(c -> c.getAno() == ano)
                .collect(Collectors.toList());
    }

    // Buscar por faixa de preço
    public List<T> buscarPorFaixaPreco(double precoMin, double precoMax) {
        return carros.stream()
                .filter(c -> c.getPreco() >= precoMin && c.getPreco() <= precoMax)
                .collect(Collectors.toList());
    }

    // Buscar com predicado genérico
    public List<T> buscarComFiltro(Predicate<T> filtro) {
        return carros.stream()
                .filter(filtro)
                .collect(Collectors.toList());
    }

    // Obter primeiro carro
    public Optional<T> obterPrimeiro() {
        return carros.isEmpty() ? Optional.empty() : Optional.of(carros.get(0));
    }

    // Listar todos os carros
    public List<T> listarTodos() {
        return new ArrayList<>(carros);
    }

    // Contar carros
    public int contarCarros() {
        return carros.size();
    }

    // Limpar repositório
    public void limpar() {
        carros.clear();
        System.out.println("✓ Repositório limpo");
    }

    // Verificar se está vazio
    public boolean estaVazio() {
        return carros.isEmpty();
    }
}
