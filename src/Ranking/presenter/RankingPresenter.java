package Ranking.presenter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import Ranking.Ranking;
import presenter.IRankingPresenter;
public class RankingPresenter implements IRankingPresenter{

    private Ranking RankingClass;
    
    @Override
    public List<Map<String, Integer>> mostrarRanking() throws IOException{
        
        RankingClass = new Ranking();
        return RankingClass.getRecord();
    }

    @Override
    public void resetarRanking() throws IOException {

        RankingClass = new Ranking();
        RankingClass.resetarRanking();


    }
    
}
