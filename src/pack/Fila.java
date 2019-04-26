package pack;

import pack.No;

public class Fila<T> {

    private int n;
    private No<T> primeiro;
    private No<T> ultimo;

    public Fila() {
        this.n = 0;
        this.primeiro = null;

    }

    T primeiroDaFila() {
        return primeiro.getConteudo();
    }

    boolean enfileira(T x) {
        No<T> novo = new No<T>();
        novo.setConteudo(x);
        if (primeiro == null) {
            primeiro = novo;
        }
        ultimo.setProximo(novo);
        ultimo = novo;
        n++;
        return true;
    }

    boolean desenfileira(T x) {
        if (n == 0) {
            return false;
        }

        primeiro = primeiro.getProximo();
        n--;
        return true;

    }

}
