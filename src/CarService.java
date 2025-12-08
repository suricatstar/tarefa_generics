import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarService<T extends Car> {
    private CarRepository<T> repository;

    public CarService(CarRepository<T> repository) {
        this.repository = repository;
    }

    // Ordenar por preço
    public List<T> ordenarPorPreco(boolean crescente) {
        List<T> carros = repository.listarTodos();
        if (crescente) {
            return carros.stream()
                    .sorted(Comparator.comparing(Car::getPreco))
                    .collect(Collectors.toList());
        } else {
            return carros.stream()
                    .sorted(Comparator.comparing(Car::getPreco).reversed())
                    .collect(Collectors.toList());
        }
    }

    // Ordenar por ano
    public List<T> ordenarPorAno(boolean crescente) {
        List<T> carros = repository.listarTodos();
        if (crescente) {
            return carros.stream()
                    .sorted(Comparator.comparing(Car::getAno))
                    .collect(Collectors.toList());
        } else {
            return carros.stream()
                    .sorted(Comparator.comparing(Car::getAno).reversed())
                    .collect(Collectors.toList());
        }
    }

    // Calcular preço médio
    public double calcularPrecoMedio() {
        return repository.listarTodos().stream()
                .mapToDouble(Car::getPreco)
                .average()
                .orElse(0.0);
    }

    // Encontrar carro mais caro
    public T encontrarMaisCaro() {
        return repository.listarTodos().stream()
                .max(Comparator.comparing(Car::getPreco))
                .orElse(null);
    }

    // Encontrar carro mais barato
    public T encontrarMaisBarato() {
        return repository.listarTodos().stream()
                .min(Comparator.comparing(Car::getPreco))
                .orElse(null);
    }

    // Aplicar desconto
    public void aplicarDesconto(double percentual) {
        repository.listarTodos().forEach(carro -> {
            double novoPreco = carro.getPreco() * (1 - percentual / 100);
            carro.setPreco(novoPreco);
        });
        System.out.println("✓ Desconto de " + percentual + "% aplicado");
    }

    // Relatório de estatísticas
    public void gerarRelatorio() {
        List<T> carros = repository.listarTodos();
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        RELATÓRIO DE CARROS            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total de carros: " + carros.size());
        System.out.println("Preço médio: R$ " + String.format("%.2f", calcularPrecoMedio()));

        T maisCaro = encontrarMaisCaro();
        if (maisCaro != null) {
            System.out.println("Mais caro: " + maisCaro);
        }

        T maisBarato = encontrarMaisBarato();
        if (maisBarato != null) {
            System.out.println("Mais barato: " + maisBarato);
        }
        System.out.println("════════════════════════════════════════\n");
    }
}
