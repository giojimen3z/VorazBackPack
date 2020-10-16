import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BackPack {
    private int MaxWeight;
    private Element[] Elements;

    private int Weight;
    private int Benefit;

    public BackPack(int MaxWeight, int QuantityElements) {
        this.MaxWeight = MaxWeight;
        this.Elements = new Element[QuantityElements];
        this.Benefit = 0;
        this.Weight = 0;
    }

    public void AddElement(Element e) {

        for (int i = 0; i < this.Elements.length; i++) {
            if (this.Elements[i] == null) {
                this.Elements[i] = e; //lo añade
                this.Benefit += e.getBenefit(); // aumenta el beneficio
                this.Weight += e.getWeight(); // Aumenta el piso
                break;
            }
        }

    }

    public void clear() {
        this.Weight = 0;
        this.Benefit = 0;
        for (int i = 0; i < this.Elements.length; i++) {
            this.Elements[i] = null;
        }
    }

    public void DeleteElement(Element e) {

        for (int i = 0; i < this.Elements.length; i++) {
            if (this.Elements[i].equals(e)) {
                this.Elements[i] = null; //el elemento fuera
                this.Weight -= e.getWeight(); //Reduce el peso
                this.Benefit -= e.getBenefit(); // reduce el beneficio
                break;
            }
        }

    }

    public boolean ElementExist(Element e) {
        for (int i = 0; i < this.Elements.length; i++) {
            if (this.Elements[i] != null && this.Elements[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String chain = "";
        for (int i = 0; i < this.Elements.length; i++) {
            if (this.Elements[i] != null) {
                chain += Elements[i] + "\n";
            }
        }
        chain += "Peso: " + getWeight() + "\n";
        chain += "Beneficio: " + getBenefit() + "\n";
        return chain;
    }
}
