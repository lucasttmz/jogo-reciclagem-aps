package Ranking.view;
import view.IRankingView;

import java.awt.Color;
import java.util.List;
import java.util.Map;
import javax.swing.*;

import Ranking.presenter.RankingPresenter;
import presenter.IRankingPresenter;

public class RankingView extends JFrame implements IRankingView {
    
    private JPanel jPanel;
    
    public RankingView(){
        super("Teste");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        iniciarComponentes();
        
        
    }
    
    @Override
    public void iniciarComponentes(){

        jPanel = new JPanel();
        jPanel.setBackground(getForeground().darker());

        this.add(jPanel);
        
        
        
        JLabel lblTitulo = new JLabel("Ranking");
        getForeground();
        lblTitulo.setBackground(getForeground().WHITE);
        jPanel.add(lblTitulo);

    }
    
    @Override
    public void setPresenter(IRankingPresenter presenter) {
        
        presenter = new RankingPresenter();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPresenter'");
    }

    @Override
    public void atualizarRanking(List<Map<String, Integer>> pontuacoes) {
        
        
        
        
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarRanking'");
    }

}
