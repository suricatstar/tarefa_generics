import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE GERENCIAMENTO DE CARROS         ║");
        System.out.println("║        Demonstração de Generics              ║");
        System.out.println("╚═══════════════════════════════════════════════╝\n");

        // Criar repositório genérico de Carro
        CarRepository<Carro> repository = new CarRepository<>();
        CarService<Carro> service = new CarService<>(repository);

        // 1. Adicionar carros - Cada marca é uma classe que estende Carro
        System.out.println("\n  ADICIONANDO CARROS (POLIMORFISMO):");
        System.out.println("───────────────────────────────────────");
        repository.adicionar(new Toyota("Corolla", 2023, 125000.00));
        repository.adicionar(new Honda("Civic", 2022, 135000.00));
        repository.adicionar(new Ford("Mustang", 2024, 450000.00));
        repository.adicionar(new Chevrolet("Onix", 2023, 75000.00));
        repository.adicionar(new Volkswagen("Gol", 2021, 55000.00));
        repository.adicionar(new Hyundai("HB20", 2023, 82000.00));

        // 2. Listar todos os carros
        System.out.println("\n  LISTA COMPLETA DE CARROS:");
        System.out.println("───────────────────────────────");
        repository.listarTodos().forEach(System.out::println);

        // 3. Buscar por marca
        System.out.println("\n  BUSCAR POR MARCA (Toyota):");
        System.out.println("─────────────────────────────────");
        List<Carro> toyotas = repository.buscarPorMarca("Toyota");
        toyotas.forEach(System.out::println);

        // 4. Buscar por ano
        System.out.println("\n  BUSCAR POR ANO (2023):");
        System.out.println("────────────────────────────");
        List<Carro> carros2023 = repository.buscarPorAno(2023);
        carros2023.forEach(System.out::println);

        // 5. Buscar por faixa de preço
        System.out.println("\n  BUSCAR POR FAIXA DE PREÇO (R$ 50.000 - R$ 100.000):");
        System.out.println("──────────────────────────────────────────────────────────");
        List<Carro> carrosFaixa = repository.buscarPorFaixaPreco(50000, 100000);
        carrosFaixa.forEach(System.out::println);

        // 6. Buscar com filtro customizado
        System.out.println("\n  BUSCAR COM FILTRO (Carros após 2022):");
        System.out.println("──────────────────────────────────────────");
        List<Carro> carrosRecentes = repository.buscarComFiltro(c -> c.getAno() >= 2022);
        carrosRecentes.forEach(System.out::println);

        // 7. Ordenar por preço
        System.out.println("\n  ORDENAR POR PREÇO (Crescente):");
        System.out.println("─────────────────────────────────────");
        List<Carro> ordenadosPorPreco = service.ordenarPorPreco(true);
        ordenadosPorPreco.forEach(System.out::println);

        // 8. Ordenar por ano
        System.out.println("\n  ORDENAR POR ANO (Decrescente):");
        System.out.println("─────────────────────────────────────");
        List<Carro> ordenadosPorAno = service.ordenarPorAno(false);
        ordenadosPorAno.forEach(System.out::println);

        // 9. Gerar relatório
        System.out.println("\n  RELATÓRIO ESTATÍSTICO:");
        service.gerarRelatorio();

        // 10. Aplicar desconto
        System.out.println("\n  APLICAR DESCONTO DE 10%:");
        System.out.println("─────────────────────────────");
        service.aplicarDesconto(10);
        System.out.println("\nCarros após desconto:");
        repository.listarTodos().forEach(System.out::println);

        // 11. Adicionar múltiplos carros
        System.out.println("\n  ADICIONAR MÚLTIPLOS CARROS:");
        System.out.println("──────────────────────────────────");
        List<Carro> novosCarros = List.of(
                new Fiat("Uno", 2020, 45000.00),
                new Renault("Kwid", 2021, 48000.00));
        repository.adicionarTodos(novosCarros);

        // 12. Contagem final
        System.out.println("\n  ESTATÍSTICAS FINAIS:");
        System.out.println("────────────────────────────");
        System.out.println("Total de carros no sistema: " + repository.contarCarros());
        System.out.println("Repositório está vazio? " + (repository.estaVazio() ? "Sim" : "Não"));

        // 13. Demonstrar polimorfismo
        System.out.println("\n  DEMONSTRAÇÃO DE POLIMORFISMO:");
        System.out.println("─────────────────────────────────────");
        System.out.println("Todas as marcas são do tipo Carro:");
        System.out.println("Honda instanceof Carro? " + (new Honda("City", 2023, 100000) instanceof Carro));
        System.out.println("Toyota instanceof Carro? " + (new Toyota("Etios", 2023, 80000) instanceof Carro));
        System.out.println("Hyundai instanceof Carro? " + (new Hyundai("Creta", 2023, 150000) instanceof Carro));

        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║         FIM DA DEMONSTRAÇÃO                   ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
    }
}
