package presenter;

/**
 * Interface para o Presenter do Menu Declara todos os métodos públicos do MenuPresenter.
 */
public interface IMenuPresenter {

    void iniciarPartida();
    void mostrarRanking();
    void atualizarDificuldade(int index);
    void habilitarMusica(boolean habilitar);
}
