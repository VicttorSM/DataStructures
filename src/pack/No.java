package pack;

public class No<T> {

    private T conteudo;
    private No<T> proximo;

    public No() {
        this.conteudo = conteudo;
        this.proximo = null;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

}
