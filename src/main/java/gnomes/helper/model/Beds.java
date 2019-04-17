package gnomes.helper.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class Beds {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    private long    bedId;
    private String  location;
    private String  width;
    private	String  lenght;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beds beds = (Beds) o;
        return bedId == beds.bedId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bedId);
    }

    @Override
    public String toString() {
        return "Beds{" +
                "bedId=" + bedId +
                ", location='" + location + '\'' +
                ", width='" + width + '\'' +
                ", lenght='" + lenght + '\'' +
                '}';
    }

    public long getBedId() {
        return bedId;
    }

    public void setBedId(long bedId) {
        this.bedId = bedId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }
}
