package view;

import presenter.IMenuPresenter;

/**
 * Interface para o View do Menu 
 * Declara todos os métodos públicos do Menu View.
 */
public interface IMenuView {

    void iniciarComponentes();
    void setPresenter(IMenuPresenter presenter);
    void setVisible(boolean mostrar);
    void fechar();
}
