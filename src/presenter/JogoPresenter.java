package presenter;

import java.util.List;
import model.Desenhavel;
import model.EstadoObserver;
import model.Jogo;
import view.IJogoView;

public class JogoPresenter implements IJogoPresenter, EstadoObserver
{
    private final IJogoView view;
    private final Jogo jogo;
    
    public JogoPresenter(IJogoView view, Jogo jogo)
    {
        this.view = view;
        this.jogo = jogo;
        
        this.view.setPresenter(this);
        this.jogo.registrarEstadoObserver(this);
        this.view.iniciarComponentes();
        
        // Talvez remover o iniciar do construtor e iniciar pelo menu do jogo.
        iniciar();
    }
    
    @Override
    public void iniciar()
    {
        jogo.iniciarPartida();
    }

    @Override
    public void selecionarLixeira(int idLixeira)
    {
        List<Desenhavel> lixeiras = jogo.selecionarLixeira(idLixeira);
        if (lixeiras == null)
        {
            view.selecionarLixeira(idLixeira);
        }
        else
        {
            view.deselecionarLixeira();
            view.desenharLixeiras(lixeiras);
        }
    }

    @Override
    public void desenharLixeiras()
    {
        view.desenharLixeiras(jogo.getLixeiras());
    }

    @Override
    public void desenharReciclaveis(List<Desenhavel> reciclaveis)
    {
        view.desenharReciclaveis(reciclaveis);
    }

    @Override
    public void mudarPontos(int pontos, boolean record)
    {
        view.mudarPontuacao(pontos, record);
    }

    @Override
    public void mudarRecord(int record)
    {
        view.mudarRecord(record);
    }
    
    @Override
    public void mostrarGameOver()
    {
        view.mostrarGameOver();
        
        // Voltar ao menu principal / Mostrar pontuacao / etc
        // Fazer quando a parte dos records ficar pronta
    }

    // Métodos do Observador
    
    @Override
    public void noIncrementoPontuacao(int pontuacao, boolean record)
    {
        mudarPontos(pontuacao, record);
    }

    @Override
    public void noNovoRecord(int record)
    {
        mudarRecord(record);
    }

    @Override
    public void noMovimentoReciclaveis(List<Desenhavel> reciclaveis)
    {
        desenharReciclaveis(reciclaveis);
    }

    @Override
    public void noGameOver()
    {
        mostrarGameOver();
    }

}