package gnomes.helper.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    private long    locationId;
    private String  name;

    @OneToMany
    @JoinTable(name = "location_beds",
            joinColumns = @JoinColumn(name="location_id"),
            inverseJoinColumns = @JoinColumn(name = "bed_id"))
    private Set<Bed> beds = new HashSet<Bed>();


    public Set<Bed> getBeds() {
        return beds;
    }

    public void setBeds(Set<Bed> beds) {
        this.beds = beds;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
