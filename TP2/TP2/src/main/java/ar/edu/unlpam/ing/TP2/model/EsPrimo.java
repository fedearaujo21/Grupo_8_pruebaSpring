package ar.edu.unlpam.ing.TP2.model;

import lombok.Getter;

@Getter
public class EsPrimo {
    private final int num;
    private final boolean esPrimo;
    public EsPrimo(int num) {
        this.num=num;
        this.esPrimo=esPrimo();
    }
    
    private boolean esPrimo() {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
