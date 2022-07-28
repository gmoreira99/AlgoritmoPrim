// Guilherme Moreira de Carvalho, 31/07/2021 - Para Laboratório de Algoritmos e Estruturas de Dados II, 2021/1
// Programa Java que implementa o algoritmo de Prim (AGM)

public class XAGM {
    private XGrafo G;
    private int[] chave;    // Os menores pesos de ligação utilizados
    private int[] pai;  // Nós da AGM

    public XAGM (XGrafo G) {
        this.G = G;
        chave = new int[this.G.getNVertice()];
        pai = new int[this.G.getNVertice()];
    }

    public int[] getChave () { return this.chave; }

    // Retorna o vértice não incluso na AGM com a menor chave
    private int chaveMin(int[] chave, boolean[] set) {
        int min = Integer.MAX_VALUE;    // inicializa min muito grande para comparar
        int min_index = -1;
 
        for (int v = 0; v < this.G.getNVertice(); v++)
            if (set[v] == false && chave[v] < min) {
                min = chave[v];
                min_index = v;
            }

        return min_index;
    }
 
    // Constroi a saída
    public String print () {
        String out = "Aresta \tPeso\n";
        for (int i = 1; i < this.G.getNVertice(); i++)
            out += this.pai[i] + " - " + i + "\t" + this.chave[i] + "\n";
        
        return out;
    }

    // Constroi a AGM a partir de um grafo representado
    // por uma matriz de adjacência
    public void AGM () {
        // Verifica quais vértices estão inclusos na AGM
        boolean[] set = new boolean[this.G.getNVertice()];

        // Inclui o primeiro vérice na AGM - chave[0] é a menor (0)
        this.pai[0] = -1;
        for (int i = 1; i < this.G.getNVertice(); i++) {
            this.chave[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < this.G.getNVertice() - 1; i++) {
            // Escolhe o vértice de menor peso e o inclui na AGM
            int u = chaveMin(this.chave, set);
            set[u] = true;

            // Atualiza o peso e o pai dos vértices adjacentes ao escolhido
            // que ainda não estão inclusos na AGM
            XGrafo.Aresta a = this.G.primeiroAdj(u);
            while (a != null) {
                if (set[a.getV2()] == false && a.getPeso() < this.chave[a.getV2()]) {
                    this.pai[a.getV2()] = u;
                    this.chave[a.getV2()] = a.getPeso();
                }

                a = this.G.proxAresta(u);
            }
        }
    }
}
