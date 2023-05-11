package view;

import presenter.IRankingPresenter;

/**
 * Interface para o View do Ranking
 * Declara todos os métodos públicos do Ranking View.
 */
public interface IRankingView {
    
    void iniciarComponentes();
    void setPresenter(IRankingPresenter presenter);
    void atualizarRanking(Object[][] pontuacoes) ;
}