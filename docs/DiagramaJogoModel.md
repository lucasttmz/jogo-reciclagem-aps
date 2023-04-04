# Diagrama de Classes (UML):

```mermaid
classDiagram
	Entidade ..|> Desenhavel : implements
	Entidade ..> TipoEntidade : depends
	Estado --* Desenhavel : has
	Jogo --* Estado : has
	Jogo ..> Dificuldade : depends
    Jogo ..> Musica : depends
	class Desenhavel{
		<<interface>>
		+getImagem() ImageIcon
		+getX() int
		+getY() int
	}
	class TipoEntidade{
		<<enumeration>>
		LIXEIRA_PAPEL
		LIXEIRA_PLASTICO
		LIXEIRA_METAL
		LIXEIRA_VIDRO
		LIXO_PAPEL
		LIXO_PLASTICO
		LIXO_METAL
		LIXO_VIDRO
	}
	class Entidade{
		-Map~TipoEntidade~ImageIcon~ : imgsEntidade
		-image : ImageIcon
		-x : int
		-y : int
		-Entidade(ImageIcon imagem, int x, int y)
		+getReciclavelAleatorio() Entidade
		+getReciclaveisAleatorios(int qtd) List~Entidade~
		+getLixeiras() List~Entidade~
		+mover(int x, int y) void
		+getImagem() ImageIcon
		+getX() int
		+getY() int
	}
	class Estado{
		- jogoIniciado : boolean
		- fimDeJogo : boolean
		- record : int
		- pontuacao : int
		- reciclaveis : List~Desenhavel~
		- lixeiras : List~Desenhavel~
		- idLixeiraSelecionada : Optional~Integer~
		- observadores : List~EstadoObserver~
		+ Estado()
		+ setiniciado(boolean iniciado) void
		+ isIniciado() boolean
		+ setFimDeJogo(boolean fimDeJogo) void
		+ isFimDeJogo() boolean
		+ setRecord(int record) void
		+ getRecord() int
		+ setPontuacao(int pontuacao) void
		+ getPontuacao() int
		+ incrementarPontuacao() void
		+ getReciclaveis() List~Desenhavel~
		+ setReciclaveis(List~Desenhavel~ reciclaveis) void
		+ getLixeiras() List~Desenhavel~
		+ setLixeiras(List~Desenhavel~ lixeiras) void
		+ setIdLixeiraSelecionada(Optional~Integer~)
		+ getIdLixeiraSelecionada() Optional~Integer~
		+ setObservador(Observador observador) void
	}
	class Jogo{
		<<implements Runnable>>
		- estado : Estado
		- delayMovimento : int
		- delayNovaEntidade : int
		- qtdMovimento : int
		- msDesdeNovaEntidade : int
		+ Jogo(Dificuldade dificuldade, bool musica)
		+ reiniciarJogo(Dificuldade dificuldade, bool musica) void
		+ iniciarPartida() void
		+ run() void
        + iniciarMusica() void
		+ setEstadoObserver(Observador observador) void
		+ selecionarLixeira(id idLixeira) List~Desenhavel~
		+ getLixeiras() List~Desenhavel~
		- incrementarPontuacao() void
		- adicionarReciclaveis(int qtd) void
		- moverReciclaveis() boolean
		- moverLixeira(int origem, int destino) List~Desenhavel~
		- calcularColisao() boolean
	}
    class Musica{
        - caminhoArquivo : String
        + tocarMusica() void
    }
	class Dificuldade{
		<<enumeration>>
		FACIL
		MEDIO
		DIFICIL
	}
```


# Diagrama Sequencial:
