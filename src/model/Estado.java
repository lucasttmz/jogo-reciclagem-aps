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
    private int pontuacao;
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
    
    public Optional<Integer> getIdLixeiraSelecionada()
    {
        return idLixeiraSelecionada;
    }

    public void setIdLixeiraSelecionada(Optional<Integer> idLixeiraSelecionada)
    {
        this.idLixeiraSelecionada = idLixeiraSelecionada;
    }
    
    public void setPontuacao(int pontuacao)
    {
        this.pontuacao = pontuacao;
        
        for (EstadoObserver obs : observadores)
        {
            obs.noIncrementoPontuacao(pontuacao, isRecord());
        }
    }
    
    public void incrementarPontuacao()
    {
        setPontuacao(this.pontuacao + 1);
    }
    
    public int getPontuacao()
    {
        return pontuacao;
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
        return getPontuacao() > getRecordAtual();
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

    public Entidade getLixeira(int index)
    {
        return (Entidade) lixeiras.get(index);
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