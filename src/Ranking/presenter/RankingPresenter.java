package Ranking.presenter;

import java.io.IOException;

import Ranking.Ranking;
import Ranking.view.RankingView;
import presenter.IRankingPresenter;
public class RankingPresenter implements IRankingPresenter{

    private Ranking RankingClass;
    private RankingView rankingView;
    
    @Override
    public void mostrarRanking() throws IOException{

        rankingView.atualizarRanking(RankingClass.getRecord());

    }

    @Override
    public void resetarRanking() throws IOException {

        RankingClass = new Ranking();
        RankingClass.resetarRanking();


    }
    
}
