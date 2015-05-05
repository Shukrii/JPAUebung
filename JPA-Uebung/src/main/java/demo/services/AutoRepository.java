package demo.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import demo.model.AAuto;

public interface AutoRepository extends CrudRepository<AAuto, Integer> {
	List<AAuto> findAll();
}
