package gnomes.helper.repositories;

import gnomes.helper.interfaces.Stage;
import gnomes.helper.model.SowingStage;
import org.springframework.data.repository.CrudRepository;

public interface StageRepository extends CrudRepository<SowingStage, Long> {
}
