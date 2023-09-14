package Entity;

public class HasilAkhir {

    private String alternative;
    private double totalValue;

    public HasilAkhir(String alternative, double totalValue) {
        this.alternative = alternative;
        this.totalValue = totalValue;
    }

    public String getAlternative() {
        return alternative;
    }

    public double getTotalValue() {
        return totalValue;
    }
}
