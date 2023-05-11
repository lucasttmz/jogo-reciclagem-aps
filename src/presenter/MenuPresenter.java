package presenter;

import model.Dificuldade;
import model.Jogo;
import view.IMenuView;
import view.JogoView;
import view.RankingView;

/**
 * Responsável por apresentar o MenuView.
 */
public class MenuPresenter implements IMenuPresenter {

    private final IMenuView view;
    private boolean musicaHabilitada;
    private Dificuldade dificuldadeSelecionada;

    public MenuPresenter(IMenuView view) {
        this.view = view;
        this.dificuldadeSelecionada = Dificuldade.MEDIO;
        this.musicaHabilitada = true;

        this.view.setPresenter(this);
        this.view.iniciarComponentes();
    }

    @Override
    public void iniciarPartida() {
        this.view.fechar();
        Jogo jogo = new Jogo(dificuldadeSelecionada, musicaHabilitada);
        JogoView view = new JogoView();
        JogoPresenter presenter = new JogoPresenter(view, jogo);
    }

    @Override
    public void mostrarRanking() {
        this.view.setVisible(false);
        RankingView rView = new RankingView();
        RankingPresenter rPresenter = new RankingPresenter(rView);
        rView.setVisible(true);
        this.view.setVisible(true);
    }

    @Override
    public void atualizarDificuldade(int index) {
        this.dificuldadeSelecionada = Dificuldade.values()[index];
        System.out.println(dificuldadeSelecionada);
    }

    @Override
    public void habilitarMusica(boolean habilitar) {
        this.musicaHabilitada = habilitar;
        System.out.println(musicaHabilitada);
    }

}
