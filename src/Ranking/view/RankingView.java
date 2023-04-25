package Ranking.view;
import view.IRankingView;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.swing.*;

import Ranking.presenter.RankingPresenter;
import presenter.IRankingPresenter;

public class RankingView extends JFrame implements IRankingView {
    
    private JPanel jPanel;
    private RankingPresenter presenter;
    private List<Map<String, Integer>> pontuacoes;
    
    public RankingView() throws IOException{
        
        super("Teste");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        iniciarComponentes();
        setPresenter(presenter);
        atualizarRanking(pontuacoes);
        
        
    }
    
    @Override
    public void iniciarComponentes(){

        jPanel = new JPanel();
        //jPanel.setBackground(getForeground().darker());
        this.add(jPanel);

        JLabel lblTitulo = new JLabel("Ranking");

        jPanel.add(lblTitulo);

    }
    
    @Override
    public void setPresenter(IRankingPresenter presenter) {
        
        presenter = new RankingPresenter();
        
    }

    @Override
    public void atualizarRanking(List<Map<String, Integer>> pontuacoes) throws IOException {

        pontuacoes = presenter.mostrarRanking();
        
        for(int i = 0; i < pontuacoes.size(); i++){

            JLabel lblRanking = new JLabel(pontuacoes.get(i).toString());
            jPanel.add(lblRanking);
        }

    }

}
