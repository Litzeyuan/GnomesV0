package gnomes.helper.bootstrap;

import gnomes.helper.model.Crop;
import gnomes.helper.model.SowingStage;
import gnomes.helper.repositories.CropRepository;
import gnomes.helper.repositories.StageRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CropRepository cropRepository;
    private StageRepository stageRepository;

    //dependency injection
    public DevBootstrap(CropRepository cropRepository, StageRepository stageRepository) {
        this.cropRepository = cropRepository;
        this.stageRepository = stageRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    //for initialize data
    private void initData(){

        //each stage manages its set of crops
        //each crop also has a set of sowing stage because
        // it might have different sowing date and in different bed/location

        SowingStage sowingStage = new SowingStage();
        Set<Crop> crops = sowingStage.getCrops();
        stageRepository.save(sowingStage);



        SowingStage crop1Sowing1 = new SowingStage();
        crop1Sowing1.setSowingDate(LocalDate.of(2019,2,2));
        crop1Sowing1.setLocationId(1);
        stageRepository.save(crop1Sowing1);

        SowingStage crop1Sowing2 = new SowingStage();
        crop1Sowing2.setSowingDate(LocalDate.of(2019,2,3));
        crop1Sowing2.setLocationId(2);
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



        crops.add(crop1);
        crops.add(crop2);




    }
}
