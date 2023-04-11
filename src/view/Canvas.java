package view;

import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;
import model.Desenhavel;

class Canvas extends JPanel
{
    private List<Desenhavel> desenhaveis;

    // Imagem de fundo do canvas
    // private final Image background = new ImageIcon(
    //      this.getClass().getResource("/imagens/background.jpg")).getImage();
    
    public void setDesenhaveis(List<Desenhavel> desenhaveis)
    {
        this.desenhaveis = desenhaveis;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Desenha a imagem de fundo
        // g.drawImage(background, 0, 0, null);

        // Desenha cada um dos desenhaveis
        if (desenhaveis != null)
        {
            for (Desenhavel d : List.copyOf(desenhaveis))
            {
                g.drawImage(d.getImagem().getImage(), d.getX(), d.getY(), null);
            }
        }
    }
}
