package model;

public class SistemaFrenagem {
    private double eficiencia;

    public SistemaFrenagem(double eficiencia) {
        this.eficiencia = eficiencia;
    }

    public double gerarEnergia(double desaceleracao) {
        double energiaGerada = eficiencia * desaceleracao;
        System.out.println("Energia gerada pelo sistema de frenagem: " + energiaGerada + " kWh");
        return energiaGerada;
    }

    public double calcularDesgaste(double frenagens) {
        return frenagens * 0.05; // Exemplo de cálculo de desgaste
    }

    @Override
    public String toString() {
        return "Eficiência: " + eficiencia * 100 + "%";
    }
    
    // Remover a anotação @Override e garantir que a assinatura seja única
    public double gerarEnergia(int horas) {
        return eficiencia * horas * 2; // Exemplo ajustado para contexto
    }
}

