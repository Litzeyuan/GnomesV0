package gnomes.helper.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Bed {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    private long    bedId;
    private String  name;


    @ManyToOne
    private Location location;

    public Bed(Location location){
        this.location = location;
    }

    public long getBedId() {
        return bedId;
    }

    public void setBedId(long bedId) {
        this.bedId = bedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
