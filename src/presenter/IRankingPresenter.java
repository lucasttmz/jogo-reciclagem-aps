package presenter;

import java.io.IOException;

/**
 * Interface para o Presenter do Ranking
 * Declara todos os métodos públicos do Ranking Presenter.
 */
public interface IRankingPresenter
{
    void mostrarRanking() throws IOException;
    void resetarRanking() throws IOException;
}
