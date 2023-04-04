package model;

/**
 * Enumeração das dificuldades.
 */
public enum Dificuldade
{
    FACIL(0), 
    MEDIO(1), 
    DIFICIL(2);
        
    public int id;

    Dificuldade(int id)
    {
        this.id = id;
    }
}
