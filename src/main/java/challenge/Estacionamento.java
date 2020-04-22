package challenge;

import challenge.Exceptions.EstacionamentoLotadoException;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    final private int CAPACIDADE_MAXIMA = 10;
    private List<Carro> listaCarros = new ArrayList<>();

    public void estacionar(Carro carro) {
        if(haVagas()){
            listaCarros.add(carro);
        }
    }

    public int carrosEstacionados() {
        return 0;
    }

    public boolean carroEstacionado(Carro carro) {
        return true;
    }

    public boolean haVagas() {
        if(listaCarros.size() >= CAPACIDADE_MAXIMA) {
            throw new EstacionamentoLotadoException("O estacionamento está lotado.");
        } else {
            return true;
        }
    }
}
