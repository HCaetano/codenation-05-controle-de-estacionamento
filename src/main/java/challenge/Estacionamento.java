package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    final private int CAPACIDADE_MAXIMA = 10;
    private List<Carro> listaCarros = new ArrayList<>();

    public void estacionar(Carro carro) {
//        motoristaEstaHabilitado(carro.getMotorista());
        verificaCarro(carro);

        if(haVagas()){
            listaCarros.add(carro);
        }
    }

    public int carrosEstacionados() {
        return listaCarros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return true;
    }

    public boolean haVagas() {
        if(carrosEstacionados() == CAPACIDADE_MAXIMA) {
            throw new EstacionamentoException("O estacionamento está lotado.");
        } else {
            return true;
        }
    }

    public void verificaCarro(Carro carro) {
        if(carro.getCor() == null) throw new NullPointerException("Cor do carro não foi informada.");
    }

    public void motoristaEstaHabilitado(Motorista motorista) {
//        if(motorista.getIdade() < 0) throw new IllegalArgumentException("Motorista não pode ter idade negativa");
//        if(motorista.getPontos() < 0) throw new IllegalArgumentException("Motorista não pode ter pontos negativos");
    }
}
