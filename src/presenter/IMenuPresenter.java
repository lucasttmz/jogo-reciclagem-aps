package presenter;

/**
 * Interface para o Presenter do Menu
 * Declara todos os métodos públicos do Menu Presenter.
 */
public interface IMenuPresenter
{
    void iniciarPartida();
    void atualizarDificuldade(int index);
    void habilitarMusica(boolean habilitar);
}
