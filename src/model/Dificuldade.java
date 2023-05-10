package model;

/**
 * Enumeração das dificuldades.
 */
public enum Dificuldade
{
    FACIL(1250, 4750, 40, 10), 
    MEDIO(1000, 4000, 30, 7), 
    DIFICIL(750, 3250, 20, 5);
    
    private final int delayMovimento;
    private final int delayNovaEntidade;
    private final int pontosAcelerarJogo;
    private final int pontosIncrementarReciclaveis;

    private Dificuldade(int delayMovimento, int delayEntidade, int pontosAcelerar, int pontosIncrementar)
    {
        this.delayMovimento = delayMovimento;
        this.delayNovaEntidade = delayEntidade;
        this.pontosAcelerarJogo = pontosAcelerar;
        this.pontosIncrementarReciclaveis = pontosIncrementar;
    }
    public int getDelayMovimento()
    {
        return delayMovimento;
    }

    public int getDelayNovaEntidade()
    {
        return delayNovaEntidade;
    }

    public int getPontosAcelerarJogo()
    {
        return pontosAcelerarJogo;
    }
    
    public int getPontosIncrementarReciclaveis()
    {
        return pontosIncrementarReciclaveis;
    }

}
