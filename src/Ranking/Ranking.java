package Ranking;

import java.io.*;
import java.io.IOException;
import java.util.*;

public class Ranking {

    private String caminhoTxt = "C:/Users/Samuca/Documents/GitHub/jogo-reciclagem-aps/src/resources/pontuacao.txt";
    private List<Map<String, Integer>> pontos = new ArrayList<>();
    
    private int valorTestado;
    private int valorAdicionado;
    
    public void salvarNovaPontuacao(String nome, int pontuacao) throws IOException {

        FileWriter arquivo = new FileWriter(caminhoTxt, true);
        PrintWriter gravarArquivo = new PrintWriter(arquivo);
        gravarArquivo.printf("%s,%d%n",nome,pontuacao);

        arquivo.close();

        System.out.println("Pontuação salva com sucesso ");
    }

    public void resetarRanking(){
        
        try
        {
            FileWriter arquivo = new FileWriter(caminhoTxt);
            PrintWriter writer = new PrintWriter(arquivo);
            writer.print("");
            writer.close(); 
        
            pontos.clear();
            System.out.println("Ranking deletado");
        } 
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void definirRecord(){


        try 
        {
            FileReader Arquivo = new FileReader(caminhoTxt);
            BufferedReader salvarValores = new BufferedReader(Arquivo);

            String linha = salvarValores.readLine();


            int contadorLinhas = 0;
            while(linha != null){

                boolean jarealizouTroca = true;
                boolean salvo = false; 
                String[] linhaStrings = linha.split(",");
                
                Map<String, Integer> map = new HashMap<>();
                map.put(linhaStrings[0], Integer.valueOf(linhaStrings[1]));
                
                
                if (contadorLinhas == 0  ){

                    pontos.add(map);
                }
                else{

                    int tamanhoatual = pontos.size();
                    for (int i = 0; i < tamanhoatual; i++) {

                        if (jarealizouTroca) {
                                
                            pontos.get(i).forEach(((t, u) -> valorTestado = u));
                            map.forEach((key, value) -> valorAdicionado = value);
                                
                            if (valorAdicionado > valorTestado) {

                                List<Map<String, Integer>> tempAList = new ArrayList<>();

                                //remove os valores menores e salva em uma lista temporaria
                                for (int j = i; j < tamanhoatual; j++) {

                                    tempAList.add(pontos.get(i));
                                    pontos.remove(i);
                                }
                                
                                //Adiciona o valor maior
                                pontos.add(map);
            
                                //Adiciona os valores da lista temporaria na lista principal
                                for (int g = 0; g < tempAList.size(); g++) {
                                    pontos.add(tempAList.get(g));
                                }
                                tempAList.clear();

                                System.out.println("Troca realizada");
                                salvo = true;
                                jarealizouTroca = false;
                            }
                        } else {}
                    }

                    if (!salvo){
                        pontos.add(map); // Caso o número for o menos ele é add ao final de tudo
                    } 
                }

                linha = salvarValores.readLine();
                contadorLinhas++;
            }
                
            System.out.println(pontos);
            Arquivo.close();          
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }

    public List<Map<String, Integer>> getRecord(){
        
        try {
            definirRecord();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        return pontos;
    }

}
