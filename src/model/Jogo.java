package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Contém toda a lógica do Jogo.
 */
public class Jogo implements Runnable 
{
    private final Estado estado;
    private int delayMovimento;
    private int delayNovaEntidade;
    private int qtdMovimento;
    private int msDesdeNovaEntidade;
    private int pontosAcelerarJogo;
    private int pontosIncrementarReciclaveis;
    private boolean ocorreuColisao;
    
    private static final int TAMANHO_JANELA = 450;
    private static final int TAMANHO_LIXEIRAS = 100;
    
    public Jogo(Dificuldade dificuldade)
    {
        this.estado = new Estado();
        this.ocorreuColisao = false;
        
        this.qtdMovimento = 50;
        this.msDesdeNovaEntidade = 0;
        
        this.delayMovimento = dificuldade.getDelayMovimento();
        this.delayNovaEntidade = dificuldade.getDelayNovaEntidade();
        this.pontosAcelerarJogo = dificuldade.getPontosAcelerarJogo();
        this.pontosIncrementarReciclaveis = dificuldade.getPontosIncrementarReciclaveis();
    }
    
    public void iniciarPartida()
    {
        if (!estado.isIniciado())
        {
            estado.configurarInicioPartida();
            new Thread(this).start();
        }
    }

    @Override
    public void run()
    {
        while(!estado.isGameOver())
        {
            moverReciclaveis();
            
            boolean ocorreuReciclagem = ocorreuColisao && !estado.isGameOver();
            if (ocorreuReciclagem)
                incrementarPontuacao();
            
            boolean incluirNovosReciclaveis = msDesdeNovaEntidade >= delayNovaEntidade;
            if (incluirNovosReciclaveis)
                adicionarReciclaveis(calcularQuantidadeReciclaveis());
            
            esperarDelayParaProximoMovimento();
        }
    }
    
    private void moverReciclaveis()
    {
        List<Desenhavel> novosReciclados = new ArrayList<>();
        
        for (Desenhavel reciclavel : estado.getReciclaveis())
        {
            Entidade e = (Entidade) reciclavel;
            e.mover(0, qtdMovimento);
            
            if (checarReciclagem(e))
                ocorreuColisao = true;
            else
                novosReciclados.add(e);
        }
        
        estado.setReciclaveis(novosReciclados);
    }
   
    private boolean checarReciclagem(Entidade lixo)
    {
        boolean nenhumaColisao = lixo.getY() < TAMANHO_JANELA;
        if(nenhumaColisao)
            return false;
        
        int indexColisao = lixo.getX() / TAMANHO_LIXEIRAS;
        TipoEntidade lixeiraColidida = ((Entidade) estado.getLixeira(indexColisao)).getTipo();
        
        boolean reciclagemIncorreta = lixeiraColidida.getTipoCorrespondente() != lixo.getTipo();
        if (reciclagemIncorreta && !estado.isGameOver() )
            estado.setGameOver(true);
        
        return true;
    }
    
    private void incrementarPontuacao()
    {
        estado.incrementarPontos();
        ocorreuColisao = false;
        
        boolean acelerarJogo = estado.getPontos() >= pontosAcelerarJogo;
        if (acelerarJogo)
        {
            delayMovimento -= 5;
            delayNovaEntidade -= 15;
        }
    }
    
    private int calcularQuantidadeReciclaveis()
    {
        int pontuacaoAtual = estado.getPontos();
        int pontosDificuldadeMax = pontosIncrementarReciclaveis * 4;
        
        if (pontuacaoAtual < pontosDificuldadeMax)
            return (pontuacaoAtual / pontosIncrementarReciclaveis) + 1;
        return 4;
    }
    
    private void adicionarReciclaveis(int qtd)
    {
        // Recria a lista com os novos reciclaveis para evitar concorrência
        // durante a alteração da lista.
        List<Desenhavel> novosReciclados = new ArrayList<>(estado.getReciclaveis());
        List<Desenhavel> reciclavelAleatorio = Entidade.getReciclaveisAleatorios(qtd);
        
        for (Desenhavel reciclavel : reciclavelAleatorio)
        {
            novosReciclados.add(reciclavel);
        }
        
        msDesdeNovaEntidade = 0;
        estado.setReciclaveis(novosReciclados);
    }
    
    private void esperarDelayParaProximoMovimento()
    {
        try
        {
            Thread.sleep(delayMovimento);
        } catch (InterruptedException ex)
        {
            System.out.println(ex);
        }
        
        msDesdeNovaEntidade += delayMovimento;
        
    }
    
    public void registrarEstadoObserver(EstadoObserver observador)
    {
        estado.registrarObserver(observador);
    }
    
    public List<Desenhavel> getLixeiras()
    {
        return estado.getLixeiras();
    }
    
    public List<Desenhavel> selecionarLixeira(int idLixeira)
    {
        Optional<Integer> selecionada = estado.getIdLixeiraSelecionada();
        
        if (selecionada.isPresent())
            return moverLixeira(selecionada.get(), idLixeira);
        
        estado.setIdLixeiraSelecionada(Optional.of(idLixeira));
        return null;
    }
    
    private List<Desenhavel> moverLixeira(int origem, int destino)
    {
        List<Desenhavel> lixeiras = estado.getLixeiras();
        
        Desenhavel temp = lixeiras.get(origem);
        lixeiras.set(origem, lixeiras.get(destino));
        lixeiras.set(destino, temp);
        
        estado.setIdLixeiraSelecionada(Optional.empty());
        
        return lixeiras;
    }
    
}