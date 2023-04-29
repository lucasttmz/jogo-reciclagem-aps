package reciclagem;

import javax.swing.SwingUtilities;
import model.Dificuldade;
import model.Jogo;
import presenter.IJogoPresenter;
import presenter.JogoPresenter;
import view.IJogoView;
import view.TempJogoView;

/**
 * Classe utilizada para iniciar a aplicação
 * Podem reescrever ela para testar as suas classes
 * Depois a gente reescreve ela quando tudo estiver pronto.
 */
public class Reciclagem
{
    public Reciclagem()
    {
        Jogo jogo = new Jogo(Dificuldade.MEDIO);
        IJogoView view = new TempJogoView();
        IJogoPresenter presenter = new JogoPresenter(view, jogo);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(Reciclagem::new);
    }
    
}
