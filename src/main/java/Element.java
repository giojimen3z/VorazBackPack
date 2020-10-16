import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Element {


    private int Weight;
    private int Benefit;

    public Element(int Weight, int Benefit) {
        this.Weight = Weight;
        this.Benefit = Benefit;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Element other = (Element) obj;
        if (this.Weight != other.Weight) {
            return false;
        }
        if (this.Benefit != other.Benefit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Peso:" + Weight + "," + " beneficio:" + Benefit;
    }


}