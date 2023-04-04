package view;

import presenter.IMenuPresenter;

/**
 * Interface para o View do Menu
 * Declara todos os métodos públicos do Menu View.
 */
public interface IMenuView
{
    void iniciarComponentes();
    void setPresenter(IMenuPresenter presenter);
}
