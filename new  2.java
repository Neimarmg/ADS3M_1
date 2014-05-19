public class ArvoreBinaria  {  
 public class NoArvore  
    {  
        NoArvore noEsquerdo;  
        NoArvore noDireito;  
        int dado;  
 
 public NoArvore( int dado )  {  
 noEsquerdo = noDireito = null;  
 this.dado = dado;  
   }  
               public void inserir( int valor )  
        {  
           if( valor < dado )  
           {  
               if( noEsquerdo == null )  
               {  
                   noEsquerdo = new NoArvore( valor );  
               }  
               else  
               {  
                   noEsquerdo.inserir( valor );  
               }  
           }  
           else if( valor > dado )  
           {  
               if( noDireito == null )  
               {  
                   noDireito = new NoArvore( valor );  
               }  
               else  
               {  
                   noDireito.inserir( valor );  
               }  
           }  
        }  
    }  
  
     NoArvore raiz ;  
  
     public ArvoreBinaria()  
     {  
        raiz = null;  
     }  
  
     public void inserirNo( int valor )  
     {  
          if( raiz == null )  
          {  
             raiz = new NoArvore( valor );  
          }  
          else  
          {  
              raiz.inserir( valor );  
          }  
     }  
  
  
     // Método pre - ordem  
     // Utilizado para percorrer a ávore na forma Prefixa  
  
     public void preOrdem()  
     {  
         preOrdemAjudante( raiz );  
     }  
  
     // Método para percorrer a árvore em pre - ordem  
     // utiliza a recursão para percorrer os nos da ávore  
  
     public void preOrdemAjudante( NoArvore no )  
     {  
          if( no == null )  
           return;  
  
          System.out.println( no.dado + "" );  
  
          preOrdemAjudante( no.noEsquerdo );  
  
          preOrdemAjudante( no.noDireito );  
      }  
  
      // Método ordem simetrica  
      // Utilizado para percorre a ávore na forma infixa  
  
      public void ordemSimetrica()  
      {  
           ordemSimetricaAjudante( raiz );  
      }  
  
     // Método para percorrer a árvore em Ordem Simetrica  
     // utiliza a recursão para percorrer os nos da ávore  
  
      public void ordemSimetricaAjudante( NoArvore no)  
      {  
          if( no == null )  
              return;  
  
          ordemSimetricaAjudante( no.noEsquerdo );  
  
          System.out.println( no.dado + "" );  
  
          ordemSimetricaAjudante ( no.noDireito );  
      }  
  
      // Método pós Ordem  
      // Utilizado para percorrer a ávore na forma pósfixa  
  
      public void posOrdem()  
      {  
          posOrdemAjudante( raiz );  
      }  
  
      // Método que percorre a árvore em Pós Ordem  
      // Uliliza a recursão para percorrer os nos da árvore  
  
      public void posOrdemAjudante( NoArvore no )  
      {  
          if( no == null )  
              return;  
  
          posOrdemAjudante( no.noEsquerdo );  
  
          posOrdemAjudante( no.noDireito );  
  
          System.out.println( no.dado + "" );  
      }  
  
      // Método para  para buscar o nivel do elemento  
      // na arvoré ( Exercício 14 da lista de Estrutura de Dados )  
  
      public void busca( int x  )  
      {  
          buscaAjudante( raiz , x  );  
      }  
  
      int contador = 0; // variavél para controlar o nivel da arvoré  
  
      // Método para percorrer a arvoré e achar o elemento  
  
      public void buscaAjudante ( NoArvore no , int x )  
      {  
  
          if ( no == null )  
          {  
              System.out.println( " Nivel -1 " );  
          }  
          else if ( no.dado == x )  
          {  
              System.out.println(" Nivel " + contador );  
          }  
          else if ( no.dado > x )  
          {  
             if ( no != null )  
             {  
                 contador ++;  
                 buscaAjudante( no.noEsquerdo , x );  
             }  
  
          }  
          else if ( no.dado < x )  
          {  
              if( no != null )  
              {  
                  contador ++;  
                  buscaAjudante(no.noDireito , x );  
              }  
  
          }  
      }  
  
      // Exercício 12  
  
      public void retorna( int x )  
      {  
          procuraAjudante( raiz, x );  
      }  
  
      // método para realizar sei la já não sei mais nada  
  
      public void procuraAjudante ( NoArvore no , int x )  
      {  
  
          if ( no.dado == x )  
          {  
              System.out.println( no.dado );  
          }  
          else if ( no.noDireito.dado == x )  
          {  
               System.out.println ( no.dado );  
          }  
          else if ( no.noEsquerdo.dado == x )  
          {  
              System.out.println( no.dado );  
          }  
          else if ( no.dado > x )  
          {  
               procuraAjudante( no.noEsquerdo , x );  
          }  
          else  
          {  
               procuraAjudante(no.noDireito , x );  
          }  
  
      }  
} 