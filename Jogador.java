import java.util.Scanner;

public abstract class Jogador {
    private String nome;
    private double saldo;
    private JogoDados[] jogos;
    private char tipo;
    private int rodadas;

    public Jogador(String nome, double saldo, char tipo){
        this.nome = nome;
        this.saldo = saldo;    
        this.tipo = tipo; 
        jogos = new JogoDados[10];
        rodadas = 0;
    }

    public static int escolherJogo(){
        int value=0;
        Scanner scanner = new Scanner(System.in);
            
        while(value != 1 && value != 2){   
            System.out.println("Informe o número correspondente a qual jogo você deseja apostar: \n1 - Jogo Azar; \n2 - Jogo General; \n3-Sair do campeonato.");
            value = scanner.nextInt();
            //scanner.close();

            if(value != 1 && value != 2){
                System.out.println("O valor informado eh invalido!");
            }
            
        }
        return value;  
            
    }

    public abstract void jogarDados(double aposta);

    public String toString(){
        String str = "";

        return str;
    }

    public void mostrarJogadasExecutadas(JogoGeneral jogoG){//mostra a pontuação de cada jogada dos jogadores
        System.out.println("\n 1 2 3 4 5 6 7(T) 8(Q) 9(F) 10(S+) 11(S-) 12(G) 13(X)");
        String string = "";
        int pontuacao;

        for(int i=1;i<=13;i++){
            if(jogoG.getRodadas(i) == -1){//se a jogada não foi iniciada
                string += " -";
            }
            else{
                pontuacao = jogoG.getRodadas(i);//se a jogada foi iniciada
                string += " " + pontuacao;
            }
        }
        System.out.println(string);
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public double getSaldo(){ 
        return this.saldo;
    }

    public String getNome(){//função para pegar o nome de um jogador
        return nome;
    }

    public char getTipo(){
        return tipo;
    }
    
    public int getRodadas(){
        return rodadas;
    }

    public void setRodadas(int rodadas){
        this.rodadas = rodadas;
    }

}
