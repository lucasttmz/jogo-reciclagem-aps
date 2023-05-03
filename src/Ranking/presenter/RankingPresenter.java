package Ranking.presenter;

import Ranking.Ranking;
import Ranking.view.RankingView;
import presenter.IRankingPresenter;
public class RankingPresenter implements IRankingPresenter{

    private Ranking RankingClass = new Ranking();
    private RankingView rankingView;
    
    public RankingPresenter(RankingView view)
    {
        this.rankingView = view;
    }
    
    @Override
    public void mostrarRanking(){

        rankingView.atualizarRanking(RankingClass.getRecord());

    }

    @Override
    public void resetarRanking(){



    }
    
}
