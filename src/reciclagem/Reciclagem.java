package reciclagem;

import model.Dificuldade;
import model.Jogo;
import presenter.JogoPresenter;
import view.JogoView;

/**
 * Classe utilizada para iniciar a aplicação
 * Podem reescrever ela para testar as suas classes
 * Depois a gente reescreve ela quando tudo estiver pronto.
 */
public class Reciclagem {

    public static void main(String[] args) {
        Jogo jogo = new Jogo(Dificuldade.MEDIO);
        JogoView jogoView = new JogoView();
        JogoPresenter jogoPresenter = new JogoPresenter(jogoView, jogo);

    }

}
