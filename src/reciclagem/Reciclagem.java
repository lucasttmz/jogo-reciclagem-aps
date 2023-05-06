package reciclagem;

import model.Ranking;
import view.RankingView;
import presenter.RankingPresenter;

/**
 * Classe utilizada para iniciar a aplicação
 * Podem reescrever ela para testar as suas classes
 * Depois a gente reescreve ela quando tudo estiver pronto.
 */
public class Reciclagem
{

    public static void main(String[] args)
    {
        Ranking rank = new Ranking();
        RankingView view = new RankingView();
        RankingPresenter presenter = new RankingPresenter(view, rank);
    }
    
}
