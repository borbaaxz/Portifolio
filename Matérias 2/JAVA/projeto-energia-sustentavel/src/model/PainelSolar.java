package model;

public class PainelSolar {
    private double area;
    private double potencia;

    // Construtor
    public PainelSolar(double area, double potencia) {
        this.area = area;
        this.potencia = potencia;
    }

    // Métodos operacionais
    /**
     * Calcula a energia gerada pelo painel solar em kWh.
     * @param horas Horas de exposição ao sol.
     * @return Energia gerada em kWh.
     */
    public double gerarEnergia(int horas) {
        double energia = potencia * horas;
        System.out.println("Energia gerada pelo painel solar: " + energia + " kWh");
        return energia;
    }

    /**
     * Sobrecarga do método gerarEnergia.
     * Calcula a energia gerada pelo painel solar considerando eficiência.
     * @param horas Horas de exposição ao sol.
     * @param eficiencia Eficiência do painel (0 a 1).
     * @return Energia gerada ajustada pela eficiência em kWh.
     */
    public double gerarEnergia(int horas, double eficiencia) {
        double energia = potencia * horas * eficiencia;
        System.out.println("Energia gerada com eficiência ajustada: " + energia + " kWh");
        return energia;
    }

    /**
     * Calcula o rendimento do painel solar em kW/m².
     * @return Rendimento em kW/m².
     */
    public double calcularRendimento() {
        return potencia / area;
    }

    // Métodos auxiliares
    @Override
    public String toString() {
        return "Área do Painel: " + area + " m², Potência: " + potencia + " kW";
    }
}
