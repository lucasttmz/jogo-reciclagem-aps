package view;

import javax.swing.*;

import presenter.IRankingPresenter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.table.DefaultTableModel;

public class RankingView extends JDialog implements IRankingView {
    
    private JPanel pnlPrincipal;
    private JTable tabela;
    private IRankingPresenter presenter;
    
    public RankingView(){
        setModal(true);
        setTitle("Ranking de Pontuações");
        setSize(400, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
 
    }
    
    @Override
    public void iniciarComponentes(){

        //Define o icon
        setIconImage(new ImageIcon(getClass().getResource("/resources/icon.png")).getImage());

        //pnlPrincipal
        pnlPrincipal = new JPanel();
        pnlPrincipal.setSize(400,700);
        pnlPrincipal.setLayout(new BorderLayout());
        
        //pnlHeader
        JPanel pnlHeader = new JPanel();
        pnlHeader.setPreferredSize(new Dimension(400,40));
        pnlHeader.setBackground(new Color(246, 250, 242));
        
        JLabel lblTitulo = new JLabel("Pontuações");
        //pnlHeader.setBackground(Color.WHITE);
        lblTitulo.setForeground(new Color(0, 77, 0));
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        pnlHeader.add(lblTitulo);
        pnlPrincipal.add(pnlHeader, BorderLayout.NORTH);
        
        //pnlPontos
        tabela = new JTable();
        tabela.setEnabled(false);
    
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.getTableHeader().setBackground(new Color(228, 245, 223));
        tabela.getTableHeader().setForeground(new Color(0, 77, 0));
        tabela.getTableHeader().setFont(new Font("Arial",Font.BOLD ,18));
        
        tabela.setBackground(Color.WHITE);
        //tabela.setBorder(BorderFactory.createLineBorder(Color.blue));
        tabela.setForeground(Color.BLACK);
        tabela.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 12));

        tabela.getColumnModel().setColumnMargin(20);
        //setBorder(BorderFactory.createLineBorder(Color.red));

        JScrollPane pnlPontos = new JScrollPane(tabela);
        //pnlPontos.setBorder(BorderFactory.createLineBorder(Color.red));
        pnlPontos.getViewport().setBackground(new Color(244, 250, 242));
        pnlPontos.setPreferredSize(new Dimension(400, 200));
        pnlPrincipal.add(pnlPontos, BorderLayout.CENTER);
        
        //pnlBotoes
        JPanel pnlBotoes = new JPanel();
        pnlBotoes.setBackground(new Color(246, 250, 242));
        
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
        btnResetar.setBackground(new Color(228, 245, 223));
        btnResetar.setForeground(new Color(0, 77, 0));
        btnResetar.addMouseListener(new EfeitoHover());

        JButton btnVoltar = new JButton("<- Voltar");
        btnVoltar.addActionListener((e) -> {
            this.dispose();
        });
        btnVoltar.addMouseListener(new EfeitoHover());
        btnVoltar.setBackground(new Color(228, 245, 223));
        btnVoltar.setForeground(new Color(0, 77, 0));
        
        pnlBotoes.add(btnVoltar);
        pnlBotoes.add(btnResetar);
        
        pnlPrincipal.add(pnlBotoes, BorderLayout.SOUTH);
        
        this.add(pnlPrincipal);
    }
    
    @Override
    public void setPresenter(IRankingPresenter presenter) {
        
        this.presenter = presenter;
        
    }
    
    @Override
    public void atualizarRanking(Object[][] pontuacoes)
    {
        Object[] campos = {"Nome","Pontuação"};
        tabela.setModel(new DefaultTableModel(pontuacoes, campos));
        
    }

}
