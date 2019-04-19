package gnomes.helper.bootstrap;

import gnomes.helper.model.Bed;
import gnomes.helper.model.Crop;
import gnomes.helper.model.Location;
import gnomes.helper.model.SowingStage;
import gnomes.helper.repositories.BedRepository;
import gnomes.helper.repositories.CropRepository;
import gnomes.helper.repositories.LocationRepository;
import gnomes.helper.repositories.StageRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CropRepository cropRepository;
    private StageRepository stageRepository;
    private BedRepository bedRepository;
    private LocationRepository locationRepository;

    //dependency injection
    public DevBootstrap(CropRepository cropRepository,
                        StageRepository stageRepository,
                        BedRepository bedRepository,
                        LocationRepository locationRepository) {
        this.cropRepository = cropRepository;
        this.stageRepository = stageRepository;
        this.bedRepository = bedRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    //for initialize data
    private void initData(){

        //DCU - AreaA/Bed3
        //DCU - AreaC/Bed7
        //one location can have multiple areas
        //one bad has one location
        //need further discussion
        Location location1 = new Location();
        location1.setName("DCU");
        Location location2 = new Location();
        location2.setName("Orchard");
        locationRepository.save(location1);
        locationRepository.save(location2);

        Bed bed1 = new Bed(location1);
        bed1.setName("AreaA/Bed3");
        Bed bed2 = new Bed(location1);
        bed2.setName("AreaC/Bed7");
        bedRepository.save(bed1);
        bedRepository.save(bed2);

        location1.getBeds().add(bed1);
        location1.getBeds().add(bed2);


        //each stage manages its set of crops
        //each crop also has a set of sowing stage because
        // it might have different sowing date and in different bed/location




        SowingStage crop1Sowing1 = new SowingStage();
        crop1Sowing1.setSowingDate(LocalDate.of(2019,2,2));
        crop1Sowing1.setBedId(bed1.getBedId());
        stageRepository.save(crop1Sowing1);

        SowingStage crop1Sowing2 = new SowingStage();
        crop1Sowing2.setSowingDate(LocalDate.of(2019,2,3));
        crop1Sowing2.setBedId(bed2.getBedId());
        stageRepository.save(crop1Sowing2);

        Crop crop1 = new Crop();
        Set<SowingStage> crop1SowingStages = crop1.getSowingStage();
        crop1.setFamily("Beetroot");
        crop1.setVariety("Feur Kugal");
        crop1SowingStages.add(crop1Sowing1);
        crop1SowingStages.add(crop1Sowing2);
        cropRepository.save(crop1);


        Crop crop2 = new Crop();
        crop2.setFamily("Bok Choy");
        crop2.setVariety("Pak Choi");
        cropRepository.save(crop2);


        SowingStage sowingStage = new SowingStage();
        Set<Crop> crops = sowingStage.getCrops();
        stageRepository.save(sowingStage);
        crops.add(crop1);
        crops.add(crop2);




    }
}
