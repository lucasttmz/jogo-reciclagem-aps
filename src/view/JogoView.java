package view;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import model.Desenhavel;
import presenter.*;

/**
 * Formulário do Jogo.
 */
public class JogoView extends JFrame implements IJogoView {

    private JLabel lblPontos;
    private JLabel lblRecord;
    private IJogoPresenter presenter;
    private JButton[] lixeiras = new JButton[4];
    private Canvas canvas;

    public JogoView() {

        this.setTitle("Eco Hero");
        this.setSize(400, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void iniciarComponentes() {
        //Define o icon
        setIconImage(new ImageIcon(getClass().getResource("/resources/icon.png")).getImage());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                presenter.voltarAoMenuInicial();
            }
        });
        JPanel pnlPrincipal = new JPanel();

        pnlPrincipal.setSize(400, 700);
        pnlPrincipal.setLayout(new BorderLayout());

        JPanel pnlHeader = new JPanel();
        pnlHeader.setSize(400, 30);
        pnlHeader.setLayout(new GridLayout(1, 2));
        pnlHeader.setBackground(Color.WHITE);

        lblPontos = new JLabel("Pontos:");
        lblPontos.setHorizontalAlignment(SwingConstants.CENTER);
        lblRecord = new JLabel("Record:");
        lblRecord.setHorizontalAlignment(SwingConstants.CENTER);

        pnlHeader.add(lblPontos);
        pnlHeader.add(lblRecord);

        pnlPrincipal.add(pnlHeader, BorderLayout.NORTH);

        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(400, 450));
        canvas.setBackground(Color.BLUE);

        pnlPrincipal.add(canvas, BorderLayout.CENTER);

        JPanel pnlLixeiras = new JPanel();
        pnlLixeiras.setLayout(new GridLayout(1, 4));
        pnlLixeiras.setPreferredSize(new Dimension(400, 150));

        for (int id : List.of(0, 1, 2, 3)) {
            JButton lixeira = new JButton();
            lixeira.addActionListener((e) -> presenter.selecionarLixeira(id));
            lixeira.setBackground(Color.WHITE);
            lixeiras[id] = lixeira;
            pnlLixeiras.add(lixeira);
        }

        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode() - 49;
                if (keyCode >= 0 && keyCode < 4) {
                    presenter.selecionarLixeira(keyCode);
                }
            }
        });

        pnlPrincipal.add(pnlLixeiras, BorderLayout.SOUTH);

        this.add(pnlPrincipal);
        presenter.desenharLixeiras();
        this.setVisible(true);

    }

    @Override
    public void setPresenter(IJogoPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void desenharLixeiras(List<Desenhavel> lixeiras) {
        for (int i = 0; i < lixeiras.size(); i++) {
            this.lixeiras[i].setIcon(lixeiras.get(i).getImagem());
        }
    }

    @Override
    public void desenharReciclaveis(List<Desenhavel> reciclaveis) {
        canvas.setDesenhaveis(reciclaveis);
        canvas.repaint();
    }

    @Override
    public void selecionarLixeira(int idLixeira) {
        this.lixeiras[idLixeira].setBorder(BorderFactory.createLineBorder(
                Color.GREEN, 3));
    }

    @Override
    public void deselecionarLixeira() {
        for (JButton lixeira : lixeiras) {
            lixeira.setBorder(UIManager.getBorder("Button.border"));
        }
    }

    @Override
    public void mudarPontuacao(int pontuacao, boolean record) {
        lblPontos.setText("Pontos: " + pontuacao);

        if (record) {
            this.lblPontos.setForeground(Color.blue);
        } else {
            this.lblPontos.setForeground(Color.black);
        }
    }

    @Override
    public void mudarRecord(int record) {
        lblRecord.setText("Record: " + record);
    }

    @Override
    public void fechar() {
        this.presenter = null;
        this.dispose();
    }
}
