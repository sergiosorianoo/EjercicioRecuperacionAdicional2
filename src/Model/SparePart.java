package Model;

import java.util.Objects;

public class SparePart {

    protected int code;
    protected String text;
    protected double price;
    private Object Objects;


    public SparePart(int code, String text, double price) {
        this.code = code;
        this.text = text;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "Codigo = " + code + ", Texto = '" + text + '\'' + ", Precio = " + price + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SparePart sparePart = (SparePart) o;
        return code == sparePart.code;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode();
    }

}
