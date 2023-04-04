package model;

import javax.swing.ImageIcon;

/**
 * Interface para as entidades, 
 * de forma que o View não precisa conhecer o Modelo.
 */
public interface Desenhavel
{
    ImageIcon getImagem();
    int getX();
    int getY();
}
