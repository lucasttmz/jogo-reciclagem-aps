package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Lógica do efeito de hover do mouse para ser aplicado aos botões dos menus.
 */
public class EfeitoHover extends MouseAdapter {

    @Override
    public void mouseEntered(MouseEvent e) {
        Component botao = e.getComponent();
        botao.setBackground(new Color(45, 140, 13));
        botao.setForeground(Color.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component botao = e.getComponent();
        botao.setBackground(new Color(228, 245, 223));
        botao.setForeground(new Color(0, 77, 0));
    }
}
