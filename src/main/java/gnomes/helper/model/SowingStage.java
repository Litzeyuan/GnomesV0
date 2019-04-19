package gnomes.helper.model;

import gnomes.helper.interfaces.Stage;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;

//Each stage manages its set of crops

@Entity
public class SowingStage implements Stage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    private long    sowingStageId;
    private LocalDate sowingDate;
    private String  sowingPhotoRef;
    private	int     sowingAirTemp;
    private int     sowingHumidity; //%
    private int     sowingSoilTemp;
    private int     sowingSoilMoisture; //%
    private int     sowingLightLevel;
    private long    locationId;

    @ManyToMany
    @JoinTable(name = "sowingStage_crop",
            joinColumns = @JoinColumn(name="sowingStage_id"),
            inverseJoinColumns = @JoinColumn(name = "crop_id"))
    private Set<Crop> crops = new HashSet<Crop>();

    public SowingStage(){

    }

    public SowingStage(Set<Crop> crops){
        this.crops = crops;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SowingStage that = (SowingStage) o;
        return sowingStageId == that.sowingStageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sowingStageId);
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }


    public long getSowingStageId() {
        return sowingStageId;
    }

    public void setSowingStageId(long sowingStageId) {
        sowingStageId = sowingStageId;
    }

    public LocalDate getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(LocalDate sowingDate) {
        this.sowingDate = sowingDate;
    }

    public String getSowingPhotoRef() {
        return sowingPhotoRef;
    }

    public void setSowingPhotoRef(String sowingPhotoRef) {
        this.sowingPhotoRef = sowingPhotoRef;
    }

    public int getSowingAirTemp() {
        return sowingAirTemp;
    }

    public void setSowingAirTemp(int sowingAirTemp) {
        this.sowingAirTemp = sowingAirTemp;
    }

    public int getSowingHumidity() {
        return sowingHumidity;
    }

    public void setSowingHumidity(int sowingHumidity) {
        this.sowingHumidity = sowingHumidity;
    }

    public int getSowingSoilTemp() {
        return sowingSoilTemp;
    }

    public void setSowingSoilTemp(int sowingSoilTemp) {
        this.sowingSoilTemp = sowingSoilTemp;
    }

    public int getSowingSoilMoisture() {
        return sowingSoilMoisture;
    }

    public void setSowingSoilMoisture(int sowingSoilMoisture) {
        this.sowingSoilMoisture = sowingSoilMoisture;
    }

    public int getSowingLightLevel() {
        return sowingLightLevel;
    }

    public void setSowingLightLevel(int sowingLightLevel) {
        this.sowingLightLevel = sowingLightLevel;
    }

    public Set<Crop> getCrops() {
        return crops;
    }

    public void setCrops(Set<Crop> crops) {
        this.crops = crops;
    }
}
