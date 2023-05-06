package view;

import javax.swing.*;

import presenter.RankingPresenter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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

        //pnlPrincipal
        pnlPrincipal = new JPanel();
        pnlPrincipal.setSize(400,700);
        pnlPrincipal.setLayout(new BorderLayout());
        
        //pnlHeader
        JPanel pnlHeader = new JPanel();
        pnlHeader.setPreferredSize(new Dimension(400,30));
        JLabel lblTitulo = new JLabel("Pontuações");
        pnlHeader.setBackground(Color.WHITE);
        pnlHeader.add(lblTitulo);
        pnlPrincipal.add(pnlHeader, BorderLayout.NORTH);
        
        //pnlPontos
        tabela = new JTable();
        JScrollPane pnlPontos = new JScrollPane(tabela);
        pnlPontos.setPreferredSize(new Dimension(400, 200));
        pnlPontos.setBackground(Color.red);
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
        tabela.setModel(new DefaultTableModel(pontuacoes, campos));;
    }
}
