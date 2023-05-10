package model;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class Ranking {

    private File arquivo;
    private String caminhoTxt = "pontuacao.txt";
    private List<String[]> pontos = new ArrayList<>();
    
    private int valorTestado;
    private int valorAdicionado;
    
    public Ranking()
    {
        arquivo = new File(caminhoTxt);
        if (!arquivo.exists())
            criarArquivoPontuacoes();
    }
    
    public void salvarNovaPontuacao(String nome, int pontuacao) throws IOException {
        FileWriter fw = new FileWriter(arquivo, true);
        PrintWriter gravarArquivo = new PrintWriter(fw);
        gravarArquivo.printf("%s,%d%n",nome,pontuacao);

        fw.close();

        System.out.println("Pontuação salva com sucesso ");
    }

    public void resetarRanking(){
        
        try
        {
            FileWriter fw = new FileWriter(arquivo);
            PrintWriter writer = new PrintWriter(fw);
            writer.print("");
            writer.close(); 
        
            pontos.clear();
            System.out.println("Ranking deletado");
        } 
        catch (IOException e)
        {
            System.out.println("Resetar: " + e);
        }
    }
    
    public void definirRecord(){
        try 
        {
            FileReader Arquivo = new FileReader(arquivo);
            BufferedReader salvarValores = new BufferedReader(Arquivo);

            String linha = salvarValores.readLine();
            
            int contadorLinhas = 0;
            while(linha != null){

                boolean jarealizouTroca = true;
                boolean salvo = false; 
                String[] linhaStrings = linha.split(",");
                linhaStrings[0] = linhaStrings[0].toUpperCase();
                if (contadorLinhas == 0  ){

                    
                    pontos.add(linhaStrings);
                }
                else{

                    int tamanhoatual = pontos.size();
                    for (int i = 0; i < tamanhoatual; i++) {

                        if (jarealizouTroca) {

                            valorTestado = Integer.parseInt(pontos.get(i)[1]);
                            valorAdicionado = Integer.parseInt(linhaStrings[1]); 
                                
                            //pontos.get(i).forEach(((t, u) -> valorTestado = u));
                            //map.forEach((key, value) -> valorAdicionado = value);
                                
                            if (valorAdicionado > valorTestado) {

                                List<String[]> tempAList = new ArrayList<>();

                                //remove os valores menores e salva em uma lista temporaria
                                for (int j = i; j < tamanhoatual; j++) {

                                    tempAList.add(pontos.get(i));
                                    pontos.remove(i);
                                }
                                
                                //Adiciona o valor maior
                                pontos.add(linhaStrings);
            
                                //Adiciona os valores da lista temporaria na lista principal
                                for (int g = 0; g < tempAList.size(); g++) {
                                    pontos.add(tempAList.get(g));
                                }
                                tempAList.clear();

                                salvo = true;
                                jarealizouTroca = false;
                            }
                        } else {}
                    }

                    if (!salvo){
                        pontos.add(linhaStrings); // Caso o número for o menos ele é add ao final de tudo
                    } 
                }

                linha = salvarValores.readLine();
                contadorLinhas++;
            }
            
            Arquivo.close();          
        } 
        catch (IOException | NumberFormatException e) 
        {
            System.out.println(e);
        }
    }

    public int getRecord()
    {
        int pontuacaoMaxima = 0;
        try {
            definirRecord();
            pontuacaoMaxima = Integer.parseInt(pontos.get(0)[1]);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return pontuacaoMaxima;
    }
    
    public Object[][] getPontuacoes(){
        
        definirRecord();
        
        Object[][] tabelaPontos = new Object[pontos.size()][2];
        for(int i=0; i < tabelaPontos.length; i++)
        {
            tabelaPontos[i] = pontos.get(i);
        }
        
        return tabelaPontos;
    }
    
    private void criarArquivoPontuacoes()
    {
        try
        {
            PrintWriter pw = new PrintWriter(caminhoTxt, "UTF-8");
            pw.print("");
            pw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex)
        {
            System.out.println(ex);
        }
    }
}
