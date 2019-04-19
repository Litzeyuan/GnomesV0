package gnomes.helper.repositories;

import gnomes.helper.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Long> {
}
