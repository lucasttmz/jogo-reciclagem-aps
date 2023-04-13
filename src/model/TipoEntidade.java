package model;

/**
 * Enumeração dos tipos de entidades.
 */
public enum TipoEntidade
{
    LIXO_METAL(0), 
    LIXO_PAPEL(1), 
    LIXO_PLASTICO(2), 
    LIXO_VIDRO(3),
    LIXEIRA_METAL(4), 
    LIXEIRA_PAPEL(5), 
    LIXEIRA_PLASTICO(6), 
    LIXEIRA_VIDRO(7);
        
    public int id;

    TipoEntidade(int id)
    {
        this.id = id;
    }
}