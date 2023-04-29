package Ranking.presenter;

import Ranking.Ranking;
import Ranking.view.RankingView;
import presenter.IRankingPresenter;
public class RankingPresenter implements IRankingPresenter{

    private Ranking RankingClass = new Ranking();
    private RankingView rankingView = new RankingView();
    
    @Override
    public void mostrarRanking(){

        RankingClass.definirRecord();
        rankingView.atualizarRanking(RankingClass.getRecord());

    }

    @Override
    public void resetarRanking(){



    }
    
}
