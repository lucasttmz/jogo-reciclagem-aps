package reciclagem;

import presenter.MenuPresenter;
import view.MenuView;

/**
 * Classe utilizada para iniciar a aplicação Podem reescrever ela para testar as
 * suas classes Depois a gente reescreve ela quando tudo estiver pronto.
 */
public class Reciclagem {

    public static void main(String[] args) {
        MenuView view = new MenuView();
        MenuPresenter presenter = new MenuPresenter(view);
    }

}
