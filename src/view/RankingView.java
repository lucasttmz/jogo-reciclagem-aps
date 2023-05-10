package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import presenter.RankingPresenter;
import reciclagem.Reciclagem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class RankingView extends JFrame implements IRankingView {
    
    private JPanel pnlPrincipal;
    private JTable tabela;
    private RankingPresenter presenter;
    
    public RankingView(){
        
        setTitle("Ranking de Pontuações");
        setSize(400, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
    }
    
    @Override
    public void iniciarComponentes(){

        //Define o icon
        try {
            this.setIconImage(ImageIO.read(Reciclagem.class.getResourceAsStream("../resources/icon.png")));
        } catch (IOException e) {
            System.out.println(e);
        }

        //pnlPrincipal
        pnlPrincipal = new JPanel();
        pnlPrincipal.setSize(400,700);
        pnlPrincipal.setLayout(new BorderLayout());
        
        //pnlHeader
        JPanel pnlHeader = new JPanel();
        pnlHeader.setPreferredSize(new Dimension(400,40));
        pnlHeader.setBackground(Color.DARK_GRAY);
        
        JLabel lblTitulo = new JLabel("Pontuações");
        //pnlHeader.setBackground(Color.WHITE);
        lblTitulo.setBackground(Color.DARK_GRAY);
        lblTitulo.setForeground(Color.white);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        pnlHeader.add(lblTitulo);
        pnlPrincipal.add(pnlHeader, BorderLayout.NORTH);
        
        //pnlPontos
        tabela = new JTable();
        tabela.setEnabled(false);
    
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getTableHeader().setBackground(Color.DARK_GRAY);
        tabela.getTableHeader().setForeground(Color.WHITE);
        tabela.getTableHeader().setFont(new Font("Arial",Font.BOLD ,18));
        
        tabela.setBackground(Color.DARK_GRAY);
        //tabela.setBorder(BorderFactory.createLineBorder(Color.blue));
        tabela.setForeground(Color.WHITE);
        tabela.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12));

        tabela.getColumnModel().setColumnMargin(20);
        //setBorder(BorderFactory.createLineBorder(Color.red));

        JScrollPane pnlPontos = new JScrollPane(tabela);
        //pnlPontos.setBorder(BorderFactory.createLineBorder(Color.red));
        pnlPontos.getViewport().setBackground(Color.DARK_GRAY);
        pnlPontos.setPreferredSize(new Dimension(400, 200));
        pnlPrincipal.add(pnlPontos, BorderLayout.CENTER);
        
        //pnlBotoes
        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setBackground(Color.WHITE);
        
        JButton btnResetar = new JButton("Resetar Ranking");
        btnResetar.addActionListener((e) -> {
            String mensagem = "Você tem certeza?";
            String titulo = "Resetar a pontuação";
            int escolha = JOptionPane.showConfirmDialog(this, mensagem, titulo, JOptionPane.YES_NO_OPTION);
            if (escolha == JOptionPane.YES_OPTION)
            {
                presenter.resetarRanking();
                
            }
        });

        JButton btnVoltar = new JButton("<- Voltar");
        btnVoltar.addActionListener((e) -> {
            this.setVisible(false);
        });
        
        pnlBotoes.add(btnVoltar);
        pnlBotoes.add(btnResetar);
        
        pnlPrincipal.add(pnlBotoes, BorderLayout.SOUTH);
        
        this.add(pnlPrincipal);
        
        setVisible(true);

    }
    
    @Override
    public void setPresenter(RankingPresenter presenter) {
        
        this.presenter = presenter;
        
    }
    
    @Override
    public void atualizarRanking(Object[][] pontuacoes)
    {
        Object[] campos = {"Nome","Pontuação"};
        tabela.setModel(new DefaultTableModel(pontuacoes, campos));
        
    }
}
