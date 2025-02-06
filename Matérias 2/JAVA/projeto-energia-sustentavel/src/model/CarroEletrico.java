package model;

public class CarroEletrico extends Veiculo {
    private double capacidadeBateria;
    private double nivelBateria;

    public CarroEletrico(String modelo, String marca, int ano, double capacidadeBateria, double nivelBateria) {
        super(modelo, marca, ano);
        this.capacidadeBateria = capacidadeBateria;
        this.nivelBateria = nivelBateria;
    }

    public void carregarBateria(double energia) {
        if (nivelBateria + energia <= capacidadeBateria) {
            nivelBateria += energia;
            System.out.println("Bateria carregada. Nível atual: " + nivelBateria + " kWh");
        } else {
            System.out.println("Não é possível carregar mais do que a capacidade máxima.");
        }
    }

    public void usarBateria(double consumo) {
        if (nivelBateria >= consumo) {
            nivelBateria -= consumo;
            System.out.println("Bateria utilizada. Nível restante: " + nivelBateria + " kWh");
        } else {
            System.out.println("Bateria insuficiente para o consumo solicitado.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidade da Bateria: " + capacidadeBateria + " kWh, Nível da Bateria: " + nivelBateria + " kWh";
    }
    /**
 * Calcula a autonomia restante do carro elétrico com base no nível da bateria.
 * @param consumoPorKm Consumo de energia em kWh por quilômetro.
 * @return Autonomia estimada em quilômetros.
 */
public double calcularAutonomia(double consumoPorKm) {
    return nivelBateria / consumoPorKm;
}
}

