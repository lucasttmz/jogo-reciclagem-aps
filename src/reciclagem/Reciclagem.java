package reciclagem;

import model.Dificuldade;
import model.Jogo;
import presenter.JogoPresenter;
import presenter.MenuPresenter;
import presenter.RankingPresenter;
import view.JogoView;
import view.MenuView;
import view.RankingView;

/**
 * Classe utilizada para iniciar a aplicação
 * Podem reescrever ela para testar as suas classes
 * Depois a gente reescreve ela quando tudo estiver pronto.
 */

public class Reciclagem {

    public static void main(String[] args) 
    {
        MenuView view = new MenuView();
        MenuPresenter presenter = new MenuPresenter(view);
        
//        JogoView view = new JogoView();
//        Jogo jogo = new Jogo(Dificuldade.FACIL, true);
//        JogoPresenter presenter = new JogoPresenter(view, jogo);
    }

}
