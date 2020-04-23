package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Estacionamento {

    final private int CAPACIDADE_MAXIMA = 10;
    final private int IDADE_SENIOR = 55;
    final private int IDADE_ADULTO = 18;
    private List<Carro> listaCarros = new ArrayList<>();

    public void estacionar(Carro carro) {
        motoristaEstaHabilitado(carro.getMotorista());

        if(haVagas(carro)){
            listaCarros.add(carro);
        }
    }

    public int carrosEstacionados() {
        return listaCarros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return listaCarros.contains(carro);
    }

    public boolean haVagas(Carro carro) {
        if(carrosEstacionados() == CAPACIDADE_MAXIMA) {
              if(todosOsMotoristasSaoSenior(listaCarros)) {
                throw new EstacionamentoException("O estacionamento está lotado.");
              }

              if(carro.getMotorista().getIdade() < IDADE_SENIOR &&
                      !todosOsMotoristasSaoSenior(listaCarros)) {
                  for(Carro carroEstacionado : listaCarros) {
                      if(carroEstacionado.getMotorista().getIdade() < IDADE_SENIOR) {
                          listaCarros.remove(carroEstacionado);
                          break;
                      }
                  }
              }
        }

        return true;
    }

    public void motoristaEstaHabilitado(Motorista motorista) {
        if (Objects.isNull(motorista)) {
            throw new EstacionamentoException("Carro deve possuir motorista.");
        }

        if (motorista.getIdade() < IDADE_ADULTO) {
            throw new EstacionamentoException("Motorista deve ser maior de idade");
        }
    }

    public boolean todosOsMotoristasSaoSenior(List<Carro> listaCarros) {
        boolean todosSaoSenior = false;

        for(Carro carro : listaCarros) {
            if(carro.getMotorista().getIdade() > IDADE_SENIOR) {
                todosSaoSenior = true;
            } else {
                todosSaoSenior = false;
                break;
            }
        }

        return todosSaoSenior;
    }
}
