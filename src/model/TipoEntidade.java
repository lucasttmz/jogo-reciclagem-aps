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
        
    private final int id;

    private TipoEntidade(int id)
    {
        this.id = id;
    }
    
    public TipoEntidade getEntidadeCorrespondente()
    {
        if(this.id < 4)
            return TipoEntidade.values()[id+4];
        
        return TipoEntidade.values()[id-4];
    }
}