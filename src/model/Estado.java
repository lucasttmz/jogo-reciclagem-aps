package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Armazena os dados referentes ao estado atual do jogo.
 */
public class Estado 
{
    private boolean iniciado;
    private boolean gameOver;
    private int recordAtual;
    private int pontos;
    private Optional<Integer> idLixeiraSelecionada;
    private List<Desenhavel> reciclaveis;
    private List<Desenhavel> lixeiras;
    private final List<EstadoObserver> observadores;
    
    public Estado()
    {
        iniciado = false;
        gameOver = false;
        reciclaveis = List.of(); // Lista imutável
        observadores = new ArrayList<>();
        lixeiras = Entidade.getLixeiras();
        idLixeiraSelecionada = Optional.empty();
    }
    
    public void registrarObserver(EstadoObserver observador)
    {
        this.observadores.add(observador);
    }
    
    public void configurarInicioPartida()
    {
        setIniciado(true);
        setPontos(0);
        setRecordAtual(10);
        
        // Quando a classe record estiver pronta.
        // setRecordAtual(new Record().getRecord());
    }
    
    public Optional<Integer> getIdLixeiraSelecionada()
    {
        return idLixeiraSelecionada;
    }

    public void setIdLixeiraSelecionada(Optional<Integer> idLixeiraSelecionada)
    {
        this.idLixeiraSelecionada = idLixeiraSelecionada;
    }
    
    public void setPontos(int pontos)
    {
        this.pontos = pontos;
        
        for (EstadoObserver obs : observadores)
        {
            obs.noIncrementoPontuacao(pontos, isRecord());
        }
    }
    
    public void incrementarPontos()
    {
        setPontos(this.pontos + 1);
    }
    
    public int getPontos()
    {
        return pontos;
    }
    
    public void setRecordAtual(int recordAtual)
    {
        this.recordAtual = recordAtual;
        
        for (EstadoObserver obs : observadores)
        {
            obs.noNovoRecord(recordAtual);
        }
    }
    
    public int getRecordAtual()
    {
        return recordAtual;
    }
    
    public boolean isRecord()
    {
        return getPontos() > getRecordAtual();
    }

    public void setIniciado(boolean iniciado)
    {
        this.iniciado = iniciado;
    }
    
    public boolean isIniciado()
    {
        return iniciado;
    }

    public void setGameOver(boolean gameOver)
    {
        this.gameOver = gameOver;
        
        if (gameOver)
        {
            for (EstadoObserver obs : observadores)
            {
                obs.noGameOver();
            }
        }
    }
    
    public boolean isGameOver()
    {
        return gameOver;
    }
    
    public List<Desenhavel> getReciclaveis()
    {
        return List.copyOf(reciclaveis);
    }

    public void setReciclaveis(List<Desenhavel> reciclaveis)
    {
        this.reciclaveis = reciclaveis;
        for (EstadoObserver obs : observadores)
        {
            obs.noMovimentoReciclaveis(this.reciclaveis);
        }
    }

    public Desenhavel getLixeira(int index)
    {
        return lixeiras.get(index);
    }
    
    public List<Desenhavel> getLixeiras()
    {
        return lixeiras;
    }

    public void setLixeiras(List<Desenhavel> lixeiras)
    {
        this.lixeiras = lixeiras;
    }
   
}