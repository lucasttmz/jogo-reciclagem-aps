package view;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import model.Desenhavel;
import presenter.*;

public class JogoView extends JFrame implements IJogoView {
  private JLabel lblPontos;
  private JLabel lblRecord;
  private IJogoPresenter presenter;
  private JButton[] lixeiras = new JButton[4];
  private Canvas canvas;

  public JogoView() {
    this.setTitle("Recycle Hero");
    this.setSize(400, 700);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public void iniciarComponentes() {
    JPanel jpnlPrincipal = new JPanel();

    jpnlPrincipal.setSize(400, 700);
    jpnlPrincipal.setLayout(new BorderLayout());

    JPanel jpnlHeader = new JPanel();
    jpnlHeader.setSize(400, 30);
    jpnlHeader.setLayout(new GridLayout(1, 2));

    lblPontos = new JLabel("Pontos:");
    lblRecord = new JLabel("Record:");
    lblRecord.setBorder(new EmptyBorder(0, 100, 0, 0));

    jpnlHeader.add(lblPontos);
    jpnlHeader.add(lblRecord);

    jpnlPrincipal.add(jpnlHeader, BorderLayout.NORTH);

    canvas = new Canvas();

    canvas.setPreferredSize(new Dimension(400, 450));
    canvas.setBackground(Color.BLUE);

    jpnlPrincipal.add(canvas, BorderLayout.CENTER);

    JPanel jpnlLixeiras = new JPanel();
    jpnlLixeiras.setLayout(new GridLayout(1, 4));
    jpnlLixeiras.setPreferredSize(new Dimension(400, 150));

    for (int id : List.of(0, 1, 2, 3)) {
      JButton lixeira = new JButton();
      lixeira.addActionListener((e) -> presenter.selecionarLixeira(id));
      lixeira.setBackground(Color.WHITE);
      lixeiras[id] = lixeira;
      jpnlLixeiras.add(lixeira);
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

    jpnlPrincipal.add(jpnlLixeiras, BorderLayout.SOUTH);

    this.add(jpnlPrincipal);
    presenter.desenharLixeiras();
    this.setVisible(true);

  }

  public void setPresenter(IJogoPresenter presenter) {
    this.presenter = presenter;
  }

  public void desenharLixeiras(List<Desenhavel> lixeiras) {
    for (int i = 0; i < lixeiras.size(); i++) {
      this.lixeiras[i].setIcon(lixeiras.get(i).getImagem());
    }
  }

  public void desenharReciclaveis(List<Desenhavel> reciclaveis) {
    canvas.setDesenhaveis(reciclaveis);
    canvas.repaint();
  }

  public void selecionarLixeira(int idLixeira) {
    this.lixeiras[idLixeira].setBorder(BorderFactory.createLineBorder(
        Color.BLACK, 3));
  }

  public void deselecionarLixeira() {
    for (JButton lixeira : lixeiras) {
      lixeira.setBorder(null);
    }
  }

  public void mudarPontuacao(int pontuacao, boolean record) {
    lblPontos.setText("Pontos:" + pontuacao);

    if (record) {
      this.lblPontos.setForeground(Color.blue);
    } else {
      this.lblPontos.setForeground(Color.black);
    }
  }

  public void mudarRecord(int record) {
    lblRecord.setText("Record:" + record);
  }

  public void mostrarGameOver() {
  }
}