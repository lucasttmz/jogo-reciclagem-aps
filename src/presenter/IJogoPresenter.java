package presenter;

import java.util.List;
import model.Desenhavel;

/**
 * Interface para o Presenter do Jogo Declara todos os métodos públicos do JogoPresenter.
 */
public interface IJogoPresenter {

    void iniciar();
    void selecionarLixeira(int idLixeira);
    void desenharLixeiras();
    void desenharReciclaveis(List<Desenhavel> reciclaveis);
    void mudarPontos(int pontos, boolean record);
    void mudarRecord(int record);
    void mostrarGameOver();
    void voltarAoMenuInicial();
}
