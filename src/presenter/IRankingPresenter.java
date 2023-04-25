package presenter;

import java.io.IOException;
import java.util.*;

/**
 * Interface para o Presenter do Ranking
 * Declara todos os métodos públicos do Ranking Presenter.
 */
public interface IRankingPresenter
{
    List<Map<String, Integer>> mostrarRanking() throws IOException;
    void resetarRanking() throws IOException;
}
