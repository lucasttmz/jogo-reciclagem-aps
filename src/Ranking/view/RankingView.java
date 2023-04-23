package Ranking.view;

import javax.swing.*;

public class RankingView extends JFrame {
    
    private JPanel jPanel;
    
    public RankingView(){
        super("Teste");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
        iniciarComponentes();
        
        
    }
    public void iniciarComponentes(){

        jPanel = new JPanel();
        this.add(jPanel);
        JLabel lblTitulo = new JLabel("Ranking");

        jPanel.add(lblTitulo);

    }
}
