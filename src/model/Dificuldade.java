package model;

/**
 * Enumeração das dificuldades.
 */
public enum Dificuldade
{
    FACIL(1250, 4750, 40), 
    MEDIO(1000, 4000, 30), 
    DIFICIL(750, 3250, 20);
    
    private final int delayMovimento;
    private final int delayNovaEntidade;
    private final int pontosAcelerarJogo;

    private Dificuldade(int delayMovimento, int delayEntidade, int pontosAcelerar)
    {
        this.delayMovimento = delayMovimento;
        this.delayNovaEntidade = delayEntidade;
        this.pontosAcelerarJogo = pontosAcelerar;
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

}
