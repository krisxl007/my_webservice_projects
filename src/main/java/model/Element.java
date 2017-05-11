package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Element entity class
 */
@Entity
@SequenceGenerator(name="Seq",sequenceName="Seq_DB")
public class Element {

    private int id;
    private int value;

    @Id
    @GeneratedValue()
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
