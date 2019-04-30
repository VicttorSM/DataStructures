/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import pack.No;

/**
 *
 * @author will
 */
public class LDE<T extends Comparable<T>> {

    private int n;
    private No<T> primeiro;
    private No<T> ultimo;

    public LDE() {

        this.n = 0;
        this.primeiro = null;
        this.ultimo = null;

    }

    public boolean insere(T x) {

        No<T> novo = new No<T>();
        novo.setConteudo(x);

        No<T> anterior = null;
        No<T> proximo = primeiro;

        while (proximo != null && x.compareTo(proximo.getConteudo()) < 0) {

            anterior = proximo;
            proximo = proximo.getProximo();

        }

        if (anterior != null) {

            anterior.setProximo(novo);
        } else {
            primeiro = novo;
        }

        novo.setProximo(proximo);
        n++;

        return true;

    }

    public No<T> busca(T x) {

        No<T> atual = primeiro;

        while (atual != null) {

            if (0 == atual.getConteudo().compareTo(x)) {

                break;

            }

        }

        return atual;

    }

    public boolean excluir(T x) {

        No<T> no = busca(x);
        No<T> anterior = null;
        
        while (no != null) {
            
            if (0 == no.getConteudo().compareTo(x)) {

                break;

            }
            anterior = no;

        }
        if(no == null){
            return false;
        }
        if (anterior != null){
            anterior.setProximo(no.getProximo());
        }
        else {
            primeiro = no.getProximo();
        }
        n--;
        return true;
    }

    /**
     * @return the primeiro
     */
    public No<T> getPrimeiro() {
        return primeiro;
    }

    /**
     * @param primeiro the primeiro to set
     */
    public void setPrimeiro(No<T> primeiro) {
        this.primeiro = primeiro;
    }

    /**
     * @return the ultimo
     */
    public No<T> getUltimo() {
        return ultimo;
    }

    /**
     * @param ultimo the ultimo to set
     */
    public void setUltimo(No<T> ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }

}
