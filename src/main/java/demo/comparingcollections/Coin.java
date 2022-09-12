package demo.comparingcollections;

import java.util.Objects;

public class Coin implements Comparable<Coin> {
    private int nominalValue;    // valoarea nominala
    private int mintYear;        // anul in care a aparut moneda

    Coin(int nominalValue, int mintYear) {
        this.nominalValue = nominalValue;
        this.mintYear = mintYear;
    }

    public int getNominalValue() {
        return nominalValue;
    }

    public void setNominalValue(int nominalValue) {
        this.nominalValue = nominalValue;
    }

    public int getMintYear() {
        return mintYear;
    }

    public void setMintYear(int mintYear) {
        this.mintYear = mintYear;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominalValue, mintYear);
    }


    //metoda compareTo returneaza valori intregi, dupa caz
    @Override
    public int compareTo(Coin anotherCoin) {
        return Integer.compare(nominalValue, anotherCoin.getNominalValue());
    }

    // metoda equals compara monedele tot dupa valoarea nominala
    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Coin coin = (Coin) that;
        return nominalValue == coin.nominalValue;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "nominalValue=" + nominalValue +
                ", mintYear=" + mintYear +
                '}';
    }


}
