package reciclagem;
import java.io.IOException;

import Ranking.Ranking;
/**
 * Classe utilizada para iniciar a aplicação
 * Podem reescrever ela para testar as suas classes
 * Depois a gente reescreve ela quando tudo estiver pronto.
 */
public class Reciclagem
{

    public static void main(String[] args) throws IOException
    {
        //RankingView view = new RankingView();
        Ranking ranking = new Ranking();
        ranking.definirRecord();

    }
    
}
