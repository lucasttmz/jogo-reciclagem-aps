package view;


import presenter.IMenuPresenter;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class MenuView extends JFrame implements IMenuView{

    private IMenuPresenter presenter;

    public MenuView() {
        this.setTitle("Eco Hero Menu");
        this.setSize(400, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        iniciarComponentes();
    }

    public void iniciarComponentes() {
        JPanel jpnlPrincipal = new JPanel();

        jpnlPrincipal.setLayout(new BorderLayout());
        jpnlPrincipal.setBackground(Color.WHITE);
        jpnlPrincipal.setPreferredSize(new Dimension(400, 700));

        JPanel jpnlTitulo = new JPanel();
        jpnlTitulo.setLayout(new FlowLayout());
        jpnlTitulo.setBackground(Color.WHITE);
        jpnlTitulo.setPreferredSize(new Dimension(400, 100));

        JLabel jlblTitulo = new JLabel("Eco Hero");
        jlblTitulo.setFont(new Font("Arial", Font.BOLD, 50));
        jlblTitulo.setForeground(Color.BLACK);

        jpnlTitulo.add(jlblTitulo);

        JPanel jpnlBotoes = new JPanel();
        jpnlBotoes.setLayout(new FlowLayout());
        jpnlBotoes.setBackground(Color.WHITE);
        jpnlBotoes.setPreferredSize(new Dimension(400, 600));

        JButton jbtnIniciarJogo = new JButton("Iniciar Jogo");
        jbtnIniciarJogo.setPreferredSize(new Dimension(300, 50));
        jbtnIniciarJogo.setFont(new Font("Arial", Font.BOLD, 20));
        jbtnIniciarJogo.setForeground(Color.BLACK);
        jbtnIniciarJogo.setBackground(Color.WHITE);
        jbtnIniciarJogo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jbtnIniciarJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        JButton jbtnSelecionarDificuldade = new JButton("Selecionar Dificuldade");
        jbtnSelecionarDificuldade.setPreferredSize(new Dimension(300, 50));
        jbtnSelecionarDificuldade.setFont(new Font("Arial", Font.BOLD, 20));
        jbtnSelecionarDificuldade.setForeground(Color.BLACK);
        jbtnSelecionarDificuldade.setBackground(Color.WHITE);
        jbtnSelecionarDificuldade.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        jbtnSelecionarDificuldade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
            }
        });

        jpnlBotoes.add(jbtnIniciarJogo);
        jpnlBotoes.add(jbtnSelecionarDificuldade);

        this.setVisible(true);
    }

    public void setPresenter(IMenuPresenter presenter) {
        this.presenter = presenter;
    }
}
