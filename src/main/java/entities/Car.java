package entities;

import javax.persistence.*;

@Entity
@Table(name = "new_car")

public class Car {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "year")
    private int year;

    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(int id, int year, String model) {
        this.id = id;
        this.year = year;
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
