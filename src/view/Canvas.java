package view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.Desenhavel;

/**
 * Canvas onde todas os lixos recicláveis (Entidades) do jogo são desenhados.
 */
class Canvas extends JPanel {

    private List<Desenhavel> desenhaveis;

    // Imagem de fundo do canvas
    private final Image background = new ImageIcon(
            this.getClass().getResource("/resources/background.png")).getImage();

    public void setDesenhaveis(List<Desenhavel> desenhaveis) {
        this.desenhaveis = desenhaveis;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha a imagem de fundo
        g.drawImage(background, 0, 0, null);

        // Desenha cada um dos desenhaveis
        if (desenhaveis != null) {
            for (Desenhavel d : List.copyOf(desenhaveis)) {
                g.drawImage(d.getImagem().getImage(), d.getX(), d.getY(), null);
            }
        }
    }
}
