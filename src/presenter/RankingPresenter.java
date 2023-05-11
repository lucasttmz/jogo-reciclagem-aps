package presenter;

import model.Ranking;
import view.RankingView;

public class RankingPresenter implements IRankingPresenter{

    private RankingView view;
    
    public RankingPresenter(RankingView view)
    {
        this.view = view;
        
        this.view.setPresenter(this);
        this.view.iniciarComponentes();
        this.mostrarRanking();
    }
    
    @Override
    public void mostrarRanking()
    {
        Ranking rank = new Ranking();
        view.atualizarRanking(rank.getPontuacoes());
    }

    @Override
    public void resetarRanking()
    {
        Ranking rank = new Ranking();
        rank.resetarRanking();
        view.atualizarRanking(rank.getPontuacoes());
    }
    
}
