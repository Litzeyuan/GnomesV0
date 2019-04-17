package gnomes.helper.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.*;

@Entity
public class SowingStage {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @NotNull
    private long    sowingStageId;
    private Date    sowingDate;
    private String  sowingPhotoRef;
    @Null
    private	int     sowingAirTemp;
    @Null
    private int     sowingHumidity; //%
    @Null
    private int     sowingSoilTemp;
    @Null
    private int     sowingSoilMoisture; //%
    @Null
    private int     sowingLightLevel;

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name="sowingStage_id"), inverseJoinColumns = @JoinColumn(name = "crop_id"))
    private Set<CropDetails> crops = new HashSet<CropDetails>();

    public SowingStage(){

    }

    public SowingStage(Set<CropDetails> crops){
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


    //for statics
    @Override
    public String toString() {
        return "SowingStage{" +
                "sowingStageId=" + sowingStageId +
                ", sowingDate=" + sowingDate +
                ", sowingPhotoRef='" + sowingPhotoRef + '\'' +
                ", sowingAirTemp=" + sowingAirTemp +
                ", sowingHumidity=" + sowingHumidity +
                ", sowingSoilTemp=" + sowingSoilTemp +
                ", sowingSoilMoisture=" + sowingSoilMoisture +
                ", sowingLightLevel=" + sowingLightLevel +
                ", crops=" + crops +
                '}';
    }

    public long getSowingStageId() {
        return sowingStageId;
    }

    public void setSowingStageId(long sowingStageId) {
        sowingStageId = sowingStageId;
    }

    public Date getSowingDate() {
        return sowingDate;
    }

    public void setSowingDate(Date sowingDate) {
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

    public Set<CropDetails> getCrops() {
        return crops;
    }

    public void setCrops(Set<CropDetails> crops) {
        this.crops = crops;
    }
}
