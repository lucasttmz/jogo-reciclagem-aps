package Ranking;
import java.io.*;
import java.io.IOException;
import java.util.*;

public class Ranking {

    private String caminhoTxt = "https://github.com/lucasttmz/jogo-reciclagem-aps/blob/Ranking/src/resources/pontuacao.txt";

    private String pontuacaoFormat;
    private String record;

    public void salvarNovaPontuacao(String nome, int pontuacao) throws IOException {

        FileWriter FileW = new FileWriter(caminhoTxt, true);

        pontuacaoFormat = nome + "," + pontuacao + "\n";
        FileW.append(pontuacaoFormat);

        System.out.println("Salvo com sucesso");
        FileW.close();
    }

    public void definirRecord() throws IOException {

        int contadorLinha = 0;

        ArrayList<String> nome = new ArrayList<>();
        ArrayList<Integer> pontuacao = new ArrayList<>();

        ArrayList<Integer> pontuacaoOrdenada = new ArrayList<>();

        FileReader ler = new FileReader(caminhoTxt);
        BufferedReader ler2 = new BufferedReader(ler);

        // lê a primeira linha do txt
        String linha = ler2.readLine();

        while (linha != null) {

            String[] split = linha.split(",");

            nome.add(split[0]);
            pontuacao.add(Integer.valueOf(split[1]));

            System.out.printf("%d : Valor %d add no array\n", contadorLinha, pontuacao.get(contadorLinha));

            String salvo = "naosalvo";
            boolean jarealizouTroca = true;

            if (0 == contadorLinha) {
                pontuacaoOrdenada.add(pontuacao.get(contadorLinha));

                System.out.println("             Primeiro valor armazenado\n");
                System.out.printf("Tamanho da pontuacaoOrdenada = %d\n", pontuacaoOrdenada.size());
            } else {
                int tamanhoatual = pontuacaoOrdenada.size();


                for (int i = 0; i <  tamanhoatual; i++) {

                    if (jarealizouTroca) {

                        boolean teste = pontuacao.get(contadorLinha) > pontuacaoOrdenada.get(i);
                        System.out.printf("%d>%d: %b\n", pontuacao.get(contadorLinha), pontuacaoOrdenada.get(i), teste);

                        if (teste) {

                            ArrayList<Integer> tempAList = new ArrayList<>();

                            for(int j = i; j < tamanhoatual; j++){

                                System.out.printf("Adicionando o numero %d\n",pontuacaoOrdenada.get(i));
                                tempAList.add(pontuacaoOrdenada.get(i));
                                System.out.printf("Removendo o numero %d\n",pontuacaoOrdenada.get(i));
                                pontuacaoOrdenada.remove(i);
                                System.out.println(j);
                                System.out.println(i);
                            }
                            System.out.println(pontuacaoOrdenada);
                            System.out.println(tempAList);
                            pontuacaoOrdenada.add(pontuacao.get(contadorLinha));

                            for(int g = 0; g < tempAList.size(); g++){

                                pontuacaoOrdenada.add(tempAList.get(g));

                            }
                            tempAList.clear();

                            System.out.println("Troca realizada");
                            salvo = "jasalvo";
                            jarealizouTroca = false;
                        }
                    } else {

                            System.out.println("Não salvou");
                    }

                }

                if (salvo.equals("jasalvo")) {
                    
                } else {
                    pontuacaoOrdenada.add(pontuacao.get(contadorLinha));
                }
            }

            System.out.printf("Tamnho da pontuacaoOrdenada = %d\n", pontuacaoOrdenada.size());
            System.out.println(pontuacaoOrdenada);

            linha = ler2.readLine();
            contadorLinha++;
        }
        ler2.close();

        System.out.println(pontuacaoOrdenada);

    }

    public String getRecord() {

        return record;
    }

}

// Files.lines(path).forEach(System.out::println);
// Path path = Paths.get(caminhoTxt);
// long count = Files.lines(path).count();
