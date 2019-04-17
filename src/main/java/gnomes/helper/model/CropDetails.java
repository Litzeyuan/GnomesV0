package gnomes.helper.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Objects;

@Entity
public class CropDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    private long    cropId;
    private String  location;
    @Null
    private	int     bedId;
    private String  family;
    private	String  variety;
    @Null
    private	int     quantity;
    private	String  sowingType;     // seed or module or direct
    private	String  rowSpacing;     // cm - number or seed or module
    @Null
    private	int     plantSpacing;   // cm
    private	String  trayUsed;       // a number or direct
    private	String  sowingPerCell;	// a number or seed or direct
    private	String  composUsed;
    private	String  seedVender;
    private Date    seedBoughtDate;
    private Date    SeedExpiration;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CropDetails that = (CropDetails) o;
        return cropId == that.cropId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cropId);
    }

    //for statics
    @Override
    public String toString() {
        return "CropDetails{" +
                "cropId=" + cropId +
                ", location='" + location + '\'' +
                ", bedId=" + bedId +
                ", family='" + family + '\'' +
                ", variety='" + variety + '\'' +
                ", quantity=" + quantity +
                ", sowingType='" + sowingType + '\'' +
                ", rowSpacing='" + rowSpacing + '\'' +
                ", plantSpacing=" + plantSpacing +
                ", trayUsed='" + trayUsed + '\'' +
                ", sowingPerCell='" + sowingPerCell + '\'' +
                ", composUsed='" + composUsed + '\'' +
                ", seedVender='" + seedVender + '\'' +
                ", seedBoughtDate=" + seedBoughtDate +
                ", SeedExpiration=" + SeedExpiration +
                '}';
    }

    public long getCropId() {
        return cropId;
    }

    public void setCropId(long cropId) {
        this.cropId = cropId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSowingType() {
        return sowingType;
    }

    public void setSowingType(String sowingType) {
        this.sowingType = sowingType;
    }

    public String getRowSpacing() {
        return rowSpacing;
    }

    public void setRowSpacing(String rowSpacing) {
        this.rowSpacing = rowSpacing;
    }

    public int getPlantSpacing() {
        return plantSpacing;
    }

    public void setPlantSpacing(int plantSpacing) {
        this.plantSpacing = plantSpacing;
    }

    public String getTrayUsed() {
        return trayUsed;
    }

    public void setTrayUsed(String trayUsed) {
        this.trayUsed = trayUsed;
    }

    public String getSowingPerCell() {
        return sowingPerCell;
    }

    public void setSowingPerCell(String sowingPerCell) {
        this.sowingPerCell = sowingPerCell;
    }

    public String getComposUsed() {
        return composUsed;
    }

    public void setComposUsed(String composUsed) {
        this.composUsed = composUsed;
    }

    public String getSeedVender() {
        return seedVender;
    }

    public void setSeedVender(String seedVender) {
        this.seedVender = seedVender;
    }

    public Date getSeedBoughtDate() {
        return seedBoughtDate;
    }

    public void setSeedBoughtDate(Date seedBoughtDate) {
        this.seedBoughtDate = seedBoughtDate;
    }

    public Date getSeedExpiration() {
        return SeedExpiration;
    }

    public void setSeedExpiration(Date seedExpiration) {
        SeedExpiration = seedExpiration;
    }
}
