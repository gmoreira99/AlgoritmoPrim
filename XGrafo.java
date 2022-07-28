// Guilherme Moreira de Carvalho, 31/07/2021 - Para Laboratório de Algoritmos e Estruturas de Dados II, 2021/1
// Programa Java que implementa a estruta de um Grafo

public class XGrafo {
    public static class Aresta {
        private int v1, v2, peso;

        public int getV1() { return this.v1; }
        public int getV2() { return this.v2; }
        public int getPeso() { return this.peso; }
    }

    private int nVertice;
    private boolean dir;
    private int mat[][];
    private int ultAdj[];

    public XGrafo(int nVertice) {
        this.nVertice = nVertice;
        dir = false;
        this.ultAdj = new int[nVertice];
        this.mat = new int[nVertice][nVertice];

        for (int i = 0; i < nVertice; i++)
            this.ultAdj[i] = -1;
    }

    public int getNVertice() { return this.nVertice; }

    public boolean getDir() {
        for (int i = 0; i < this.nVertice; i++)
            for (int j = 0; j < this.nVertice; j++)
                if (mat[i][j] > 0)
                    if (mat[i][j] != mat[j][i]) {
                        dir = true;
                        break;
                    }
        return dir;
    }

    public int[][] getMat () { return this.mat; }

    public void InsereAresta (int v1, int v2, int p) {
        this.mat[v1][v2] = p;
    }

    public boolean RetiraAresta (int v1, int v2) {
        if (this.mat[v1][v2] == 0) return false;
        else {
            this.mat[v1][v2] = 0;
            return true;
        }
    }

    public void reseta() {
        for (int i = 0; i < nVertice; i++)
            for (int j = 0; j < nVertice; j++)
                mat[i][j] = 0;
    }

    public Aresta proxAresta (int v) {
        if (v >= this.nVertice) return null;

        this.ultAdj[v] ++;
        while (this.ultAdj[v] < this.nVertice && this.mat[v][this.ultAdj[v]] == 0) {
            this.ultAdj[v] ++;
        }

        if (this.ultAdj[v] == this.nVertice) return null;
        else {
            Aresta proxA = new Aresta();
            proxA.v1 = v; proxA.v2 = this.ultAdj[v];
            proxA.peso = this.mat[v][this.ultAdj[v]];
            return proxA;
        }
    }

    public Aresta primeiroAdj (int v) {
        this.ultAdj[v] = -1;
        return this.proxAresta(v);
    }
}