package presenter;

import model.Ranking;
import view.RankingView;

public class RankingPresenter implements IRankingPresenter{

    private Ranking model;
    private RankingView view;
    
    public RankingPresenter(RankingView view, Ranking model)
    {
        this.view = view;
        this.model = model;
        
        this.view.setPresenter(this);
        this.view.iniciarComponentes();
        this.mostrarRanking();
    }
    
    @Override
    public void mostrarRanking()
    {
        view.atualizarRanking(model.getPontuacoes());
    }

    @Override
    public void resetarRanking()
    {
        model.resetarRanking();
        view.atualizarRanking(model.getPontuacoes());
        System.out.println("RANKING RESETADO");
    }
    
}
