# Diagrama de Classes (UML):

```mermaid
classDiagram 
MenuView *-- IMenuPresenter : has
MenuView --|> IMenuView : implements
MenuPresenter *-- Configuracao : has
MenuPresenter --|> IMenuPresenter : implements
MenuPresenter *-- IMenuView : has

class Configuracao{
    - musicaHabilitada : boolean
    - dificuldade : Dificuldade
    + Configuracao()
    + setMusicaHabilitada(boolean habilitada) : void
    + isMusicaHabilitada() : boolean
    + setDificuldade(Dificuldade dificuldade) : void
    + getDificuldade() : Dificuldade
}
class MenuView{ 
    <<extends JFrame>>
    -presenter : IMenuPresenter
    -btnIniciarPartida : JButton
    -lstDificuldade : JList
    -cbHabilitarMusica : JCheckBox
    +MenuView()
    +iniciarComponentes() void
    +setPresenter(IMenuPresenter presenter) void
} 
class IMenuView{ 
    <<interface>>
    +iniciarComponentes() void
    +setPresenter(IMenuPresenter presenter) void
}
class MenuPresenter{
    -IMenuView : view
    -Configuracao : config
    +MenuPresenter(IMenuView view, Configuracao config) void
    +iniciarPartida() void
    +atualizarDificuldade(int index) void
    +habilitarMusica(boolean habilitar) void
}
class IMenuPresenter{
    <<interface>>
    +iniciarPartida() void
    +atualizarDificuldade(int index) void
    +habilitarMusica(boolean habilitar) void
}

```

# Diagrama Sequencial:

```mermaid
sequenceDiagram
    actor User
    User->>+MenuView: Habilita Música
    MenuView->>MenuPresenter: presenter.habilitarMusica()
    MenuPresenter->>+Configuracao: config.setMusicaHabilitada()
    Configuracao-->>-User: 
    Note over User,Configuracao: Modifica o valor da variavel musicaHabilitada

    User->>+MenuView: Muda Dificuldade
    MenuView->>MenuPresenter: presenter.atualizarDificuldade()
    MenuPresenter->>+Configuracao: config.setDificuldade()
    Configuracao-->>-User: 
    Note over User,Configuracao: Modifica o valor da variavel dificuldade

    
    User-)MenuView: Inicia a partida
    MenuView-)MenuPresenter: presenter.iniciarPartida()
    critical IMPLEMENTAÇÃO FUTURA
        MenuPresenter-)JogoPresenter: *IMPLEMENTAÇÃO FUTURA*
        Note over User,JogoPresenter: Cria o presenter e as depêndencias dele, e inicia a partida
    end
```
