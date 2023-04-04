# Diagrama de Classes (UML)

```mermaid
	classDiagram
	JogoView ..|> IJogoView : implements
	JogoView ..* Canvas : has
	JogoView ..* IJogoPresenter : has
	Canvas ..* Desenhavel : has
	class IJogoPresenter{
		<<interface>>
		+ iniciar() void
		+ selecionarLixeira(int idLixeira) void
		+ desenharLixeiras() void
		+ desenharReciclaveis(List<Desenhavel> reciclaveis) void
		+ mudarPontos(int pontos, boolean record) void
		+ mudarRecord(int record) void
	}
	class IJogoView{
		<<interface>>
		+ setPresenter(IJogoPresenter presenter) void
		+ iniciarComponentes() void
		+ desenharLixeiras(List~Desenhavel~ lixeiras) void
		+ desenharReciclaveis(List~Desenhavel~ reciclaveis) void
		+ selecionarLixeira(int idLixeira) void
		+ deselecionarLixeira() void
		+ mudarPontuacao(int pontuacao, boolean record) void
		+ mudarRecord(int record) void
	}
	class JogoView{
		<<extends JFrame>>
		- presenter : IJogoPresenter
		- lblPontos : JLabel
		- lblRecord : JLabel
		- pnlCanvas : Canvas
		- lixeiras : JButton[4]
		+ JogoView()
		+ setPresenter(IJogoPresenter presenter) void
		+ iniciarComponentes() void
		+ desenharLixeiras(List~Desenhavel~ lixeiras) void
		+ desenharReciclaveis(List~Desenhavel~ reciclaveis) void
		+ selecionarLixeira(int idLixeira) void
		+ deselecionarLixeira() void
		+ mudarPontuacao(int pontuacao, boolean record) void
		+ mudarRecord(int record) void
	}
	class Canvas{
		<<extends JPanel>>
		- desenhaveis : List~Desenhavel~
		- backgroundImg : Image
		+ setDesenhaveis(List~Desenhavel~ desenhaveis) void
		# paintComponent(Graphics g) void
	}
	class Desenhavel{
		<<interface>>
		+getImagem() ImageIcon
		+getX() int
		+getY() int
	}
```

# Diagrama Sequencial:

```mermaid
sequenceDiagram
    actor User
    participant Canvas
    critical INICIALIZAÇÃO DO VIEW
        JogoView->>+JogoPresenter: presenter.desenharLixeiras()
        JogoPresenter->>+Jogo: ...
        Jogo-->>-JogoPresenter: 
        JogoPresenter->>-JogoView: view.desenharLixeiras()
        Note over JogoView,Jogo: Carrega as lixeiras com suas posições iniciais
    end

    User->>JogoView: Seleciona Lixeira
    JogoView->>+JogoPresenter: presenter.selecionarLixeira()
    JogoPresenter->>+Jogo: ...
    Jogo-->>-JogoPresenter: 
    alt nenhuma<br/>lixeira selecionada
    JogoPresenter->>JogoView: view.selecionarLixeira()
    else lixeira já selecionada
    JogoPresenter->>JogoView: view.deselecionarLixeiras()
    JogoPresenter->>JogoView: view.desenharLixeiras()
    end
    JogoView-->>User: 
    Note over JogoView,Jogo: Seleciona a lixeira se nenhuma lixeira estiver selecionada ou<br/>se já tiver uma lixeira selecionada, troca a posição das lixeiras selecionadas

    par LOOP PRINCIPAL DO JOGO
        Estado->>+JogoPresenter: ...
        JogoPresenter->>-JogoView: view.mudarPontuacao()
        Estado->>+JogoPresenter: ...
        JogoPresenter->>-JogoView: view.mudarRecord()
        Note over JogoView,Estado: Toda vez que o Estado (Observado) alterar durante o loop principal do jogo,<br/>o Presenter (Observador) é notificado para atualizar o View
        Estado->>+JogoPresenter: ...
        JogoPresenter->>+JogoView: view.desenharReciclaveis()
        JogoView->>Canvas: canvas.setDesenhaveis()
        JogoView->>-Canvas: canvas.repaint()
        Note over Canvas,Estado: Quando notificado pelo objeto observado, atualiza os recicláveis repintando o canvas com os novos desenháveis
    end
    
```