package Ranking.view;

import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import javax.xml.crypto.Data;

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
        jPanel.setBackground(getForeground().BLUE);
        jPanel.setLayout(new GridLayout(3, 1));
        this.add(jPanel);

        JLabel lblTitulo = new JLabel("Ranking");
        jPanel.add(lblTitulo);

        System.out.println("Componentes Iniciados");

    }
    
    @Override
    public void setPresenter(RankingPresenter presenter) {
        
        this.presenter = new RankingPresenter(this);
        
    }
    private String nome;
    @Override
    public void atualizarRanking(List<Map<String, Integer>> pontuacoes){

        String column[] = {"Nome","Pontuação"};
        
        List<List<Object>> listData = new ArrayList<List<Object>>();

        for(int i = 0; i < pontuacoes.size(); i++){
            
            pontuacoes.get(i).forEach(((t, u) -> nome = t));
            listData.add(Arrays.asList(nome, pontuacoes.get(i).get(nome).toString()));
        }
        
        String data[][] = {{"samuel","10"}, {"matheus", "20"}};

        System.out.println(data);
        
        /*
        JTable jt = new JTable(data, column);    
        jt.setBounds(30,40,200,300);          
        JScrollPane sp = new JScrollPane(jt);
        jPanel.add(sp);    
         */
    }


}
