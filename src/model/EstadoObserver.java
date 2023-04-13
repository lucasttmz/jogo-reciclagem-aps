package model;

import java.util.List;

public interface EstadoObserver
{
    void noIncrementoPontuacao(int pontuacao, boolean record);
    void noNovoRecord(int record);
    void noMovimentoReciclaveis(List<Desenhavel> reciclaveis);
}
