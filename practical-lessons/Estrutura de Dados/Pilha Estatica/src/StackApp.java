
import java.util.*;

public class StackApp {

public static void main (String args[]) {

Stack pilha = new Stack(); // Classe Pilha

//IsEMPTY est� vazia?
System.out.println("Pilha est� vazia? " + pilha.isEmpty());

    //gera��o de n�meros randomicos
    Random random = new Random();       

    //Alimenta a pilha com n�meros inteiros

    for (int i=0;i<2;i++){

//PUSH () Insere na pilha n�meros aleat�rios de 0 a 100

        System.out.println("Inserindo na pilha: " + pilha.push(random.nextInt(100)));            

      //(PEEK) Verifica elemento topo da pilha
        System.out.println("Valor"+ pilha.peek());
    }

        // POP() Retira da pilha

        for (int i=0;i<2;i++){

            System.out.println("Retirando da pilha: " + pilha.pop());      
        }
        
    //(SIZE) tamanho?
    System.out.println("Tamanho: " + pilha.size());
        
    //IsEMPTY est� vazia?
    System.out.println("Pilha est� vazia? " + pilha.isEmpty());
         
    }
    }   
        
    
