package main;

import model.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o modelo do carro elétrico: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite a marca do carro elétrico: ");
        String marca = scanner.nextLine();
        System.out.print("Digite o ano do carro elétrico: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Digite a capacidade da bateria (exemplo: 220kWh): ");
        double capacidadeBateria = parseInputToDouble(scanner.nextLine());
        System.out.print("Digite o nível inicial da bateria (exemplo: 10kWh): ");
        double nivelBateria = parseInputToDouble(scanner.nextLine());

        CarroEletrico carro = new CarroEletrico(modelo, marca, ano, capacidadeBateria, nivelBateria);

        System.out.print("Digite a área do painel solar (m²): ");
        double area = parseInputToDouble(scanner.nextLine());
        System.out.print("Digite a potência do painel solar (exemplo: 0.35): ");
        double potencia = parseInputToDouble(scanner.nextLine());

        PainelSolar painel = new PainelSolar(area, potencia);

        System.out.print("Digite a eficiência do sistema de frenagem (exemplo: 0.8 para 80%): ");
        double eficiencia = parseInputToDouble(scanner.nextLine());

        SistemaFrenagem sistema = new SistemaFrenagem(eficiencia);

        System.out.println("\nResumo dos dados:");
        System.out.println(carro);
        System.out.println(painel);
        System.out.println(sistema);

        System.out.println("\nSimulação:");
        double energiaGeradaPainel = painel.gerarEnergia(5); // Simulação de 5 horas
        double energiaGeradaFrenagem = sistema.gerarEnergia(10); // Simulação de desaceleração
        carro.carregarBateria(energiaGeradaPainel + energiaGeradaFrenagem);

        // Exemplo de entrada para o cálculo de autonomia
        System.out.print("Digite o consumo médio por km (exemplo: 0.2 kWh/km): ");
        double consumoPorKm = parseInputToDouble(scanner.nextLine());
        double autonomia = carro.calcularAutonomia(consumoPorKm);
        System.out.println("Autonomia estimada do carro: " + autonomia + " km");

        // Exemplo de cálculo de energia gerada pelo painel solar
        System.out.print("Digite as horas de exposição ao sol: ");
        int horasSol = scanner.nextInt();
        double energiaGeradaPainelHorasSol = painel.gerarEnergia(horasSol);
        System.out.println("Energia gerada pelo painel solar: " + energiaGeradaPainelHorasSol + " kWh");

        // Exemplo de cálculo de energia gerada pelo sistema de frenagem
        System.out.print("Digite as horas de frenagem: ");
        int horasFrenagem = scanner.nextInt();
        double energiaGeradaFrenagemHoras = sistema.gerarEnergia(horasFrenagem);
        System.out.println("Energia gerada pelo sistema de frenagem: " + energiaGeradaFrenagemHoras + " kWh");
    }

    // Método para processar a entrada e converter para double
    public static double parseInputToDouble(String input) {
        try {
            // Remover quaisquer sufixos, como "kWh", "kW", "m²", etc.
            input = input.replaceAll("[^0-9.]", ""); 
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Entrada inválida: " + input);
        }
    }
}
