package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer.UIResource;

import presenter.IMenuPresenter;

public class MenuView extends JFrame implements IMenuView {

    private IMenuPresenter presenter;
    
    private JPanel pnlPrincipal;
    private JCheckBox cbMusica;
    private JComboBox cmbDificuldade;
    private GridBagConstraints gbc;
    private GridBagLayout layout;

    public MenuView() {
        this.setTitle("Eco Hero");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        iniciarComponentes(); // por enquanto aqui
    }

    public void iniciarComponentes() {
        // Titulo
        JLabel lblTitulo = new JLabel("Eco Hero");
        lblTitulo.setForeground(new Color(0, 77, 0));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 30));
        
        // Botao Iniciar Jogo
        JButton btnIniciarJogo = new JButton("Iniciar Jogo");
        btnIniciarJogo.setPreferredSize(new Dimension(300, 50));
        btnIniciarJogo.setFocusable(false);
        btnIniciarJogo.setFont(new Font("Arial", Font.PLAIN, 20));
        btnIniciarJogo.setBackground(new Color(228, 245, 223));
        btnIniciarJogo.setForeground(new Color(0, 77, 0));
        btnIniciarJogo.addActionListener((e) -> {
            boolean musica = cbMusica.isSelected();
            int dificuldade = 0;
        });
        btnIniciarJogo.addMouseListener(new BotaoHover());
        
        // Botao Ranking de Pontuações
        JButton btnRanking = new JButton("Ranking de Pontuações");
        btnRanking.setPreferredSize(new Dimension(300, 50));
        btnRanking.setFocusable(false);
        btnRanking.setFont(new Font("Arial", Font.PLAIN, 20));
        btnRanking.setBackground(new Color(228, 245, 223));
        btnRanking.setForeground(new Color(0, 77, 0));
        btnRanking.addActionListener((e) -> {
            System.out.println("Ranking");
        });
        btnRanking.addMouseListener(new BotaoHover());
        
        // Label Dificuldades
        JLabel lblDificuldade = new JLabel("Selecione a dificuldade");
        lblDificuldade.setFont(new Font("Arial", Font.BOLD, 14));
        lblDificuldade.setForeground(new Color(0, 77, 0));
        lblDificuldade.setHorizontalAlignment(SwingConstants.CENTER);
        
        // ComboBox Dificuldades
        String[] dificuldades = {"Fácil", "Médio", "Difícil"};
        cmbDificuldade = new JComboBox(dificuldades);
        cmbDificuldade.setBackground(new Color(244, 250, 242));
        cmbDificuldade.setSelectedIndex(1);
        UIResource ui = new UIResource();
        ui.setBackground(Color.red);
        ui.setHorizontalAlignment(SwingConstants.CENTER);
        cmbDificuldade.setRenderer(ui);
        cmbDificuldade.setForeground(new Color(0, 77, 0));
        cmbDificuldade.setFocusable(false);
        
        // Checkbox Musica
        cbMusica = new JCheckBox("Habilitar Música");
        cbMusica.setHorizontalAlignment(SwingConstants.CENTER);
        cbMusica.setForeground(new Color(0, 77, 0));
        cbMusica.setBackground(new Color(244, 250, 242));
        cbMusica.setSelected(true);
        cbMusica.setFocusable(false);
        
        // Layout
        layout = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 15, 0);
        gbc.fill = GridBagConstraints.BOTH;
        
        pnlPrincipal = new JPanel();
        pnlPrincipal.setBackground(new Color(244, 250, 242));
        pnlPrincipal.setPreferredSize(new Dimension(400, 400));
        pnlPrincipal.setLayout(layout);
        
        posicionarComponente(lblTitulo, 0, 2, 5, 1);
        posicionarComponente(btnIniciarJogo, 1, 1, 6, 1);
        gbc.insets = new Insets(3, 0, 3, 0);
        posicionarComponente(lblDificuldade, 2, 2, 5, 1);
        posicionarComponente(cmbDificuldade, 3, 2, 5, 1);
        gbc.insets = new Insets(7, 0, 7, 0);
        posicionarComponente(cbMusica, 4, 1, 6, 1);
        gbc.insets = new Insets(15, 0, 15, 0);
        posicionarComponente(btnRanking, 5, 1, 6, 1);
        
        this.add(pnlPrincipal);
        this.setVisible(true);
    }

    public void setPresenter(IMenuPresenter presenter) {
        this.presenter = presenter;
    }
    
    private void posicionarComponente(Component c, int linha, int coluna, int largura, int altura)
    {
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridheight = altura;
        gbc.gridwidth = largura;
        layout.setConstraints(c, gbc);
        pnlPrincipal.add(c);
    }
    
    private class BotaoHover extends MouseAdapter{
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
}
