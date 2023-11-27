import java.util.Scanner;

public class Campeonato{
    private Jogador jogadores[];
    private String cpf, conta, agencia;
    private int numeroBanco;
    private double saldo;
    Scanner teclado = new Scanner(System.in);

    public Campeonato(){
        this.jogadores = new Jogador[10];
        this.saldo = 100;
        this.cpf = ""; 
    }

    // verifica se o nome do jogador está presente na lista
    public boolean checarNome(String nome){
        for(int i = 0;i <10;i++){
            if(jogadores[i] != null && jogadores[i].getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    // verifica se o tipo de jogador informado é válido
    public boolean checarTipo(char hm){
        if(hm == 'H' || hm == 'h' || hm == 'm' || hm == 'M'){
            return true;
        }
        return false;
    }

    // adiciona um jogador à lista de jogadores 
    public void incluirJogador(){

        // escaneia o nome para o jogador fornecido pelo usuário 
        System.out.println("Digite o nome do jogador:");
        String nome = teclado.next();

        // verifica se o nome do jogador já foi inserido anteriormente. Não podem haver jogadores com nomes iguais
        while(checarNome(nome)==true){
            System.out.println("Nome já inserido, insira outro nome");
            nome = teclado.next();
        }

        //System.out.println("Digite seu cpf:");

        // solicita ao usuário o tipo de jogador que está sendo adicionado
        System.out.println("Digite o Tipo do Jogador (H/M)");
        char tipo = teclado.next().charAt(0);

        if(checarTipo(tipo) == false){
            System.out.println("Tipo invalido");
        }
        // verifica se o tipo do jogador informado é válido, ou seja, humano (h ou H) ou máquina (m ou M)

        // verifica a situação do vetor de jogadores 
        for(int i=0;i<10;i++){
            // se a posição for nula, inicializa uma instância da classe Jogador 
            if(jogadores[i] == null){
                if(tipo == 'H' || tipo == 'h'){
                    jogadores[i] = new Humano(nome, saldo);
                }
                else if(tipo == 'M' || tipo == 'm'){
                    jogadores[i] = new Maquina(nome, saldo);
                }
                System.out.println("Jogador inserido com sucesso");
                return;
            }

            // caso o vetor esteja completo (número limite de 10 jogadores atingido), é emitido um aviso ao usuário de que não é
            // possível adicionar mais jogadores
            if(i == 9 && jogadores[i]!=null){
                System.out.println("número maximo de jogadores já atingido");
                return;
            }
        }

    }

    // utilizada para remover um jogador quando assim for solicitado pelo usuário
    public void removerJogador(){

        // pede ao usuário o nome do jogador que deseja remover
        System.out.println("Digite o nome do jogador que você quer remover");
        String nome = teclado.next();

        // verifica se o nome do jogador informado pelo usuário está, de fato, listado. Caso não esteja, emite um aviso
        if(checarNome(nome) == false){
            System.out.println("Não há jogadores com esse nome");
        }

        // ... porém, se estiver, remove o jogador da lista
        else{
            for(int i=0;i<10;i++){
                // verifica se o jogador existe antes de removê-lo e comunicar sucesso da operação
                if(jogadores[i] != null && jogadores[i].getNome().equals(nome)){ 
                    jogadores[i] = null;
                    System.out.println("Jogador " + nome + " Removido\n");
                }
            }
        }

        //teclado.close();
    }

    public void iniciarCampeonato(){
        // antes de in
        if(jogadores[0] == null){//verifica se tem algum jogador
            System.out.println("Adicione um jogador");
        }
        double maiorSaldo = 100;
        int n=0;//n é o numero de jogadas
        double aposta;
        while(maiorSaldo > 0 && n<10){
            for(int i=0;i<10;i++){
                if(jogadores[i] != null && jogadores[i].getSaldo() != 0){
                    System.out.println("Digite o valor que deseja apostar");
                    aposta = teclado.nextDouble();

                    while(aposta <= 0 || aposta > jogadores[i].getSaldo()){
                        System.out.println("Aposta invalida digite outra aposta");
                        aposta = teclado.nextDouble();
                    }
                                        
                    jogadores[i].jogarDados(aposta);

                    jogadores[i].setSaldo(jogadores[i].getSaldo());
                    if(jogadores[i].getSaldo() < maiorSaldo){
                        maiorSaldo = jogadores[i].getSaldo();
                    }
                }
            }
            n++;
        }
    }

    public void mostrarCartela(){

    }

    public void gravarEmArquivo(){

    }

    public void lerDoArquivo(){
        
    }
}
