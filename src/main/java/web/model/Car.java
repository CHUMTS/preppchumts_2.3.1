package web.model;


public class Car {

    private int series;

    private String model;

    private int price;

    public Car(int series, String model, int price) {
        this.series = series;
        this.model = model;
        this.price = price;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "series=" + series +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
