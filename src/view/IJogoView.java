package view;

import java.util.List;
import model.Desenhavel;
import presenter.IJogoPresenter;

/**
 * Interface para o View do Jogo
 * Declara todos os métodos públicos do Jogo View.
 */
public interface IJogoView
{
    void iniciarComponentes();
    void setPresenter(IJogoPresenter presenter);
    void desenharLixeiras(List<Desenhavel> lixeiras);
    void desenharReciclaveis(List<Desenhavel> reciclaveis);
    void selecionarLixeira(int idLixeira);
    void deselecionarLixeira();
    void mudarPontuacao(int pontuacao, boolean record);
    void mudarRecord(int record);
    void fechar();
}
