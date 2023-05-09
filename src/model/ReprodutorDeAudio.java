package model;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ReprodutorDeAudio 
{
    private Map<Audio, Clip> audios;
    private Clip audioAtual;
    
    public ReprodutorDeAudio()
    {
        audios = new HashMap<>();
        audioAtual = null;
        
        carregarArquivosDeAudio();
    }
    
    public void reproduzirMusica(Audio audio, boolean loop)
    {
        audioAtual = audios.get(audio);
        audioAtual.setFramePosition(0);
        
        if (loop)
            audioAtual.loop(Clip.LOOP_CONTINUOUSLY);
        
        audioAtual.start();
    }
    
    public void pararReproducaoAudio()
    {
        if (audioAtual != null)
        {
            audioAtual.stop();
            audioAtual = null;
        }
    }
    
    private void carregarArquivosDeAudio()
    {
        URL caminhoGameover = getClass().getResource("/resources/gameover.wav");
        URL caminhoMusica = getClass().getResource("/resources/musicadefundo.wav");
        
        carregarAudio(Audio.GAMEOVER, caminhoGameover);
        carregarAudio(Audio.MUSICA, caminhoMusica);
    }
    
    private void carregarAudio(Audio audio, URL caminho)
    {
        AudioInputStream inputStream = null;
        try {
            Clip clip = AudioSystem.getClip();
            inputStream = AudioSystem.getAudioInputStream(caminho);
            clip.open(inputStream);
            audios.put(audio, clip);
        }  catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            System.out.println("Erro ao carregar arquivo de audio: "+ ex);
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                System.out.println("Erro ao fechar inputStream: " + ex);
            }
        }
    }
    
    public enum Audio {GAMEOVER, MUSICA}
    
}