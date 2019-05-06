/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.Serializable;

/**
 *
 * @author william
 */
public class LES implements Serializable {

    public LES(int MAX) {
        arr = new Hospede[MAX];
        this.n = 0;
    }
    
    public int size() {
        return n;
    }
    
    public Hospede get(int i) {
        if (i < 0 || i >= n)
            return null;
        return arr[i];
    }

    public boolean insere(Hospede x) {
        if (n >= arr.length) {
            return false;
        }
        int i;
        for (i = 0; i < n && arr[i].getCPF().compareTo(x.getCPF()) < 0; i++);

        for (int j = n; j > i; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = x;
        n++;
        return true;
    }

    public int busca(Hospede x) {
        int i = 0;
        int f = n;
        int p = ((f - i) / 2) + i;
        int last = -1;

        while (f - i > 0 && last != p) {
            int comp = x.getCPF().compareTo(arr[p].getCPF());
            if (comp < 0) {
                f = p;
            } else if (comp > 0) {
                i = p;
            } else {
                return p;
            }
            last = p;
            p = ((f - i) / 2) + i;
        }
        return -1;
    }

    public boolean remove(Hospede x) {
        return remove(busca(x));
    }

    public boolean remove(int i) {
        if (i == -1) {
            return false;
        }
        for (int j = i; j < n - 1; j++) {
            arr[j] = arr[j - 1];
        }
        n--;
        return true;
    }

    private int n;
    private Hospede[] arr;
}
