package Model;

import java.util.HashMap;
import java.util.Map;

public class Component extends SparePart {

    private Map<Integer, SparePart> parts;

    public Component(int code, String text, double price) {
        super(code, text, price);
        this.parts = new HashMap<>();
    }

    public void addPart(SparePart part) {
        parts.put(part.getCode(), part);
    }

    public SparePart getPart(int code) {
        return parts.get(code);
    }

    public Map<Integer, SparePart> getParts() {
        return parts;
    }

    @Override
    public String toString() {
        return "Component{" +
                "Codigo = " + getCode() +
                ", Texto = '" + getText() + '\'' +
                ", Precio = " + getPrice() +
                ", Partes = " + parts.values() +
                '}';
    }

}
