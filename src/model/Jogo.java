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
    private final Dificuldade dificuldade;
    private int delayMovimento;
    private int delayNovaEntidade;
    private int qtdMovimento;
    private int msDesdeNovaEntidade;
    private int pontosAcelerarJogo;
    private boolean ocorreuColisao;
    
    private static final int TAMANHO_JANELA = 450;
    
    public Jogo(Dificuldade dificuldade)
    {
        this.estado = new Estado();
        this.dificuldade = dificuldade;
        this.ocorreuColisao = false;
        
        configurarDificuldade();
    }
    
    private void configurarDificuldade()
    {
        this.qtdMovimento = 50;
        this.msDesdeNovaEntidade = 0;
        
        switch (this.dificuldade)
        {
            case FACIL ->
            {
                this.delayMovimento = 1250;
                this.delayNovaEntidade = 4750;
                this.pontosAcelerarJogo = 50;
            }
            case MEDIO ->
            {
                this.delayMovimento = 1000;
                this.delayNovaEntidade = 4000;
                this.pontosAcelerarJogo = 30;
            }
            case DIFICIL ->
            {
                this.delayMovimento = 750;
                this.delayNovaEntidade = 3250;
                this.pontosAcelerarJogo = 20;
            }
        }
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
        
        // Seleciona lixeira em caso de nenhuma já estar selecionado ou
        // troca a lixeira com a lixeira já selecionada.
        if (selecionada.isEmpty())
        {
            estado.setIdLixeiraSelecionada(Optional.of(idLixeira));
            return null;
        }
        return moverLixeira(selecionada.get(), idLixeira);
    }
    
    private List<Desenhavel> moverLixeira(int origem, int destino)
    {
        List<Desenhavel> lixeiras = estado.getLixeiras();
        
        // Troca a posição das lixeiras.
        Desenhavel temp = lixeiras.get(origem);
        lixeiras.set(origem, lixeiras.get(destino));
        lixeiras.set(destino, temp);
        
        estado.setIdLixeiraSelecionada(Optional.empty());
        
        return lixeiras;
    }
    
    private void adicionarReciclaveis(int qtd)
    {
        // Recria a lista com os novos reciclaveis para evitar concorrência
        // durante a alteração da lista.
        List<Desenhavel> novosReciclados = new ArrayList<>(estado.getReciclaveis());
        List<Entidade> reciclavelAleatorio = Entidade.getReciclaveisAleatorios(qtd);
        
        for (Entidade entidade : reciclavelAleatorio)
        {
            novosReciclados.add(entidade);
        }
        
        estado.setReciclaveis(novosReciclados);
    }
    
    private void moverReciclaveis()
    {
        List<Desenhavel> novosReciclados = new ArrayList<>();
        
        // Move cada um dos lixos.
        for (Desenhavel reciclavel : estado.getReciclaveis())
        {
            Entidade e = (Entidade) reciclavel;
            e.mover(0, qtdMovimento);
            
            if (checarColisao(e)){
                ocorreuColisao = true;
            }
            else
            {
                novosReciclados.add(e);
            }
        }
        
        estado.setReciclaveis(novosReciclados);
    }
    
    private boolean checarColisao(Entidade lixo)
    {
        if (lixo.getY() < TAMANHO_JANELA)
            return false;
        
        // TODO Logica da colisao
        
        return true;
    }
    
    private void incrementarPontuacao()
    {
        estado.incrementarPontuacao();
        if (estado.getPontuacao() >= pontosAcelerarJogo)
        {
            delayMovimento -= 5;
            delayNovaEntidade -= 15;
        }
    }
    
    public void iniciarPartida()
    {
        if (!estado.isIniciado())
        {
            estado.setIniciado(true);
            estado.setPontuacao(0);
            estado.setRecordAtual(10);
            
            // Quando a classe record estiver pronta.
            // estado.setRecordAtual(new Record().getRecord());
            
            new Thread(this).start();
        }
    }

    @Override
    public void run()
    {
        // Enquanto não der gameover
        while(!estado.isGameOver())
        {
            // Checa se deve criar novas entidades
            if (msDesdeNovaEntidade >= delayNovaEntidade)
            {
                if (estado.getPontuacao() < 40)
                    adicionarReciclaveis((estado.getPontuacao() / 10) + 1);
                else
                    adicionarReciclaveis(4);
                msDesdeNovaEntidade = 0;
            }
            
            moverReciclaveis();
            
            // Checa se os lixos colidiram com as lixeiras
            if (ocorreuColisao && !estado.isGameOver())
            {
                incrementarPontuacao();
                ocorreuColisao = false;
            }
            
            // Dorme o thread pelo tempo apropriado
            try
            {
                Thread.sleep(delayMovimento);
            } catch (InterruptedException ex)
            {
                System.out.println(ex);
            }
            
            msDesdeNovaEntidade += delayMovimento;
        }
    }
}