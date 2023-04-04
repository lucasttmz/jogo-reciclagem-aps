package view;

import java.util.List;
import java.util.Map;
import presenter.IRankingPresenter;

/**
 * Interface para o View do Ranking
 * Declara todos os métodos públicos do Ranking View.
 */
public interface IRankingView 
{
    void iniciarComponentes();
    void setPresenter(IRankingPresenter presenter);
    void atualizarRanking(List<Map<String, Integer>> pontuacoes);
}