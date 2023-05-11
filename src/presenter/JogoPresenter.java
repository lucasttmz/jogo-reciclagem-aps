package presenter;

import java.util.List;
import javax.swing.JOptionPane;
import model.Desenhavel;
import model.EstadoObserver;
import model.Jogo;
import view.IJogoView;
import view.MenuView;

/**
 * Responsável por apresentar o JogoView.
 */
public class JogoPresenter implements IJogoPresenter, EstadoObserver {

    private final IJogoView view;
    private final Jogo jogo;

    public JogoPresenter(IJogoView view, Jogo jogo) {
        this.view = view;
        this.jogo = jogo;

        this.view.setPresenter(this);
        this.jogo.registrarEstadoObserver(this);
        this.view.iniciarComponentes();

        iniciar();
    }

    @Override
    public void iniciar() {
        jogo.iniciarPartida();
    }

    @Override
    public void selecionarLixeira(int idLixeira) {
        List<Desenhavel> lixeiras = jogo.selecionarLixeira(idLixeira);
        if (lixeiras == null) {
            view.selecionarLixeira(idLixeira);
        } else {
            view.deselecionarLixeira();
            view.desenharLixeiras(lixeiras);
        }
    }

    @Override
    public void desenharLixeiras() {
        view.desenharLixeiras(jogo.getLixeiras());
    }

    @Override
    public void desenharReciclaveis(List<Desenhavel> reciclaveis) {
        view.desenharReciclaveis(reciclaveis);
    }

    @Override
    public void mudarPontos(int pontos, boolean record) {
        view.mudarPontuacao(pontos, record);
    }

    @Override
    public void mudarRecord(int record) {
        view.mudarRecord(record);
    }

    @Override
    public void mostrarGameOver() {
        String nome = JOptionPane.showInputDialog(
                null, "Digite seu nome", "Salvar Pontuação", JOptionPane.QUESTION_MESSAGE);
        if (nome != null) {
            jogo.salvarPontuacao(nome);
        }

        voltarAoMenuInicial();
    }

    @Override
    public void voltarAoMenuInicial() {
        this.jogo.interromperPartida();
        this.view.fechar();
        MenuView menuView = new MenuView();
        MenuPresenter menuPresenter = new MenuPresenter(menuView);
    }

    // Métodos do Observador
    @Override
    public void noIncrementoPontuacao(int pontuacao, boolean record) {
        mudarPontos(pontuacao, record);
    }

    @Override
    public void noNovoRecord(int record) {
        mudarRecord(record);
    }

    @Override
    public void noMovimentoReciclaveis(List<Desenhavel> reciclaveis) {
        desenharReciclaveis(reciclaveis);
    }

    @Override
    public void noGameOver() {
        mostrarGameOver();
    }

}
