package model;

import java.util.List;

/**
 * Interface para os observadores da classe Estado.
 */
public interface EstadoObserver {

    void noIncrementoPontuacao(int pontuacao, boolean record);
    void noNovoRecord(int record);
    void noMovimentoReciclaveis(List<Desenhavel> reciclaveis);
    void noGameOver();
}
