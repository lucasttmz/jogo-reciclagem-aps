package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.ImageIcon;

/**
 * Classe representante de todos as entidades do jogo como a lixeira e os lixos.
 */
public class Entidade implements Desenhavel {

    private final TipoEntidade tipo;
    private int x;
    private int y;

    public static List<Desenhavel> getReciclaveisAleatorios(int qtd) {
        List<Desenhavel> reciclaveis = new ArrayList<>();

        // Posições possiveis e tipos de entidade que irão ser escolhidos em
        // conjunto de forma aleatória depois de serem embaralhados. 
        List<Integer> posPossiveis = Arrays.asList(10, 110, 210, 310);
        List<TipoEntidade> tipos = Arrays.asList(
                TipoEntidade.LIXO_METAL, TipoEntidade.LIXO_PLASTICO,
                TipoEntidade.LIXO_PAPEL, TipoEntidade.LIXO_VIDRO);

        Collections.shuffle(posPossiveis);
        Collections.shuffle(tipos);

        // Cria os n reciclaveis e os adiciona a lista a ser retornada.
        for (int i = 0; i < qtd; i++) {
            Entidade entidade = new Entidade(tipos.get(i),
                    posPossiveis.get(i), 0);
            reciclaveis.add(entidade);
        }

        return reciclaveis;
    }

    public static List<Desenhavel> getLixeiras() {
        List<Desenhavel> lixeiras = new ArrayList<>();

        lixeiras.add(new Entidade(TipoEntidade.LIXEIRA_METAL, 1, 0));
        lixeiras.add(new Entidade(TipoEntidade.LIXEIRA_PLASTICO, 101, 0));
        lixeiras.add(new Entidade(TipoEntidade.LIXEIRA_PAPEL, 201, 0));
        lixeiras.add(new Entidade(TipoEntidade.LIXEIRA_VIDRO, 301, 0));

        return lixeiras;
    }

    private Entidade(TipoEntidade tipo, int x, int y) {
        this.tipo = tipo;
        this.x = x;
        this.y = y;
    }

    public void mover(int x, int y) {
        this.x += x;
        this.y += y;
    }

    public TipoEntidade getTipo() {
        return tipo;
    }

    @Override
    public ImageIcon getImagem() {
        return tipo.getImagem();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

}
