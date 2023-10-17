package beltourProjectWithSpz.repository;

import beltourProjectWithSpz.model.ClienteModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteModel,Integer> {
}
