package view;

import java.io.IOException;
import java.util.*;
import presenter.IRankingPresenter;

/**
 * Interface para o View do Ranking
 * Declara todos os métodos públicos do Ranking View.
 */
public interface IRankingView 
{
    void iniciarComponentes();
    void setPresenter(IRankingPresenter presenter);
    void atualizarRanking(List<Map<String, Integer>> pontuacoes) throws IOException;
}