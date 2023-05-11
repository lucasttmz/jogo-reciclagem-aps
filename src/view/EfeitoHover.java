package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EfeitoHover extends MouseAdapter
{
    public void mouseEntered(MouseEvent e) {
        Component botao = e.getComponent();
        botao.setBackground(new Color(45, 140, 13));
        botao.setForeground(Color.WHITE);
    }

    public void mouseExited(MouseEvent e) {
        Component botao = e.getComponent();
        botao.setBackground(new Color(228, 245, 223));
        botao.setForeground(new Color(0, 77, 0));
    }
}
