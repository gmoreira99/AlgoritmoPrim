// Guilherme Moreira de Carvalho, 31/07/2021 - Para Laboratório de Algoritmos e Estruturas de Dados II, 2021/1
// Programa Java para testar as classes XGrafo e XAGM

import java.util.stream.IntStream;
import java.io.FileWriter;
import java.io.IOException;

public class Teste {
    public static void main (String[] args) {

        // grafo não-orientado
        XGrafo G = new XGrafo(9);
        G.InsereAresta(0, 1, 5); G.InsereAresta(1, 0, 5);
        G.InsereAresta(0, 3, 10); G.InsereAresta(3, 0, 10);
        G.InsereAresta(0, 4, 5); G.InsereAresta(4, 0, 5);
        G.InsereAresta(0, 6, 10); G.InsereAresta(6, 0, 10);
        G.InsereAresta(0, 7, 10); G.InsereAresta(7, 0, 10);
        G.InsereAresta(1, 5, 5); G.InsereAresta(5, 1, 5);
        G.InsereAresta(1, 7, 5); G.InsereAresta(7, 1, 5);
        G.InsereAresta(1, 8, 10); G.InsereAresta(8, 1, 10);
        G.InsereAresta(2, 3, 5); G.InsereAresta(3, 2, 5);
        G.InsereAresta(2, 4, 10); G.InsereAresta(4, 2, 10);
        G.InsereAresta(2, 6, 5); G.InsereAresta(6, 2, 5);
        G.InsereAresta(3, 4, 5); G.InsereAresta(4, 3, 5);
        G.InsereAresta(3, 6, 10); G.InsereAresta(6, 3, 10);
        G.InsereAresta(4, 8, 10); G.InsereAresta(8, 4, 10);
        G.InsereAresta(5, 6, 15); G.InsereAresta(6, 5, 15);
        G.InsereAresta(7, 8, 20); G.InsereAresta(8, 7, 20);

        XAGM A = new XAGM(G);
        A.AGM();
        String out = "EXEMPLO 1\n" + A.print();
        out += "Total: " + IntStream.of(A.getChave()).sum() + "\n";
        
        G = new XGrafo(8);
        G.InsereAresta(0, 1, 8); G.InsereAresta(1, 0, 8);
        G.InsereAresta(0, 2, 2); G.InsereAresta(2, 0, 2);
        G.InsereAresta(0, 6, 9); G.InsereAresta(6, 0, 9);
        G.InsereAresta(1, 2, 3); G.InsereAresta(2, 1, 3);
        G.InsereAresta(1, 3, 2); G.InsereAresta(3, 1, 2);
        G.InsereAresta(1, 4, 7); G.InsereAresta(4, 1, 7);
        G.InsereAresta(1, 5, 5); G.InsereAresta(5, 1, 5);
        G.InsereAresta(1, 7, 6); G.InsereAresta(7, 1, 6);
        G.InsereAresta(2, 3, 9); G.InsereAresta(3, 2, 9);
        G.InsereAresta(2, 6, 6); G.InsereAresta(6, 2, 6);
        G.InsereAresta(3, 4, 6); G.InsereAresta(4, 3, 6);
        G.InsereAresta(3, 6, 2); G.InsereAresta(6, 3, 2);
        G.InsereAresta(4, 5, 5); G.InsereAresta(5, 4, 5);
        G.InsereAresta(4, 6, 4); G.InsereAresta(6, 4, 4);
        G.InsereAresta(5, 7, 4); G.InsereAresta(7, 5, 4);
        G.InsereAresta(5, 6, 6); G.InsereAresta(6, 5, 6);
        G.InsereAresta(6, 7, 3); G.InsereAresta(7, 6, 3);
        
        A = new XAGM(G);
        A.AGM();
        out += "\nEXEMPLO 2\n" + A.print();
        out += "Total: " + IntStream.of(A.getChave()).sum() + "\n";

        try {
            FileWriter fp = new FileWriter("AGM_Saida.txt");
            fp.write(out);
            fp.close();
        } catch (IOException e) {
            System.out.println("ERRO: NAO FOI POSSIVEL CRIAR O ARQUIVO");
        }
    }
}
