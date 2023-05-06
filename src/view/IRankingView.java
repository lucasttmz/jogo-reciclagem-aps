package view;

import java.util.*;
import Ranking.presenter.RankingPresenter;

/**
 * Interface para o View do Ranking
 * Declara todos os métodos públicos do Ranking View.
 */
public interface IRankingView 
{
    void iniciarComponentes();
    void setPresenter(RankingPresenter presenter);
    void atualizarRanking(Object[][] pontuacoes) ;
}