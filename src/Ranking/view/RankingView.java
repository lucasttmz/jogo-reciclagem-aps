package Ranking.view;

import java.util.List;
import java.util.Map;
import javax.swing.*;

import Ranking.presenter.RankingPresenter;
import view.*;

public class RankingView extends JFrame implements IRankingView {
    
    private JPanel jPanel;
    private RankingPresenter presenter;
    
    public RankingView(){
        
        super("Teste");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        iniciarComponentes();
        setPresenter(presenter);

        presenter.mostrarRanking();
        
        
    }
    
    @Override
    public void iniciarComponentes(){

        jPanel = new JPanel();
        //jPanel.setBackground(getForeground().darker());
        this.add(jPanel);

        JLabel lblTitulo = new JLabel("Ranking");
        jPanel.add(lblTitulo);

        System.out.println("Componentes Iniciados");

    }
    
    @Override
    public void setPresenter(RankingPresenter presenter) {
        
        this.presenter = new RankingPresenter();
        
    }

    @Override
    public void atualizarRanking(List<Map<String, Integer>> pontuacoes){

        
        for(int i = 0; i < pontuacoes.size(); i++){

            JLabel lblRanking = new JLabel(pontuacoes.get(i).toString());
            jPanel.add(lblRanking);
        }

    }

}
