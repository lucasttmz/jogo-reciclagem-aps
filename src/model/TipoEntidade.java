package model;

import javax.swing.ImageIcon;

/**
 * Enumeração dos tipos de entidades.
 */
public enum TipoEntidade
{
    LIXO_METAL(0, new ImageIcon(TipoEntidade.class.getResource("/resources/lixo-metal.png"))), 
    LIXO_PAPEL(1, new ImageIcon(TipoEntidade.class.getResource("/resources/lixo-papel.png"))), 
    LIXO_PLASTICO(2, new ImageIcon(TipoEntidade.class.getResource("/resources/lixo-plastico.png"))), 
    LIXO_VIDRO(3, new ImageIcon(TipoEntidade.class.getResource("/resources/lixo-vidro.png"))),
    LIXEIRA_METAL(4, new ImageIcon(TipoEntidade.class.getResource("/resources/lixeira-metal.png"))), 
    LIXEIRA_PAPEL(5, new ImageIcon(TipoEntidade.class.getResource("/resources/lixeira-papel.png"))), 
    LIXEIRA_PLASTICO(6, new ImageIcon(TipoEntidade.class.getResource("/resources/lixeira-plastico.png"))), 
    LIXEIRA_VIDRO(7, new ImageIcon(TipoEntidade.class.getResource("/resources/lixeira-vidro.png")));
        
    private final int id;
    private final ImageIcon imagem;

    private TipoEntidade(int id, ImageIcon imagem)
    {
        this.id = id;
        this.imagem = imagem;
    }
    
    public TipoEntidade getEntidadeCorrespondente()
    {
        if(this.id < 4)
            return TipoEntidade.values()[id+4];
        
        return TipoEntidade.values()[id-4];
    }
    
    public ImageIcon getImagem()
    {
        return imagem;
    }
}