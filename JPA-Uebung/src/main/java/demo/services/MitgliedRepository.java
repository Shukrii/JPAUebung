package demo.services;


import java.util.List;
import demo.model.*;
import org.springframework.data.repository.CrudRepository;

public interface MitgliedRepository extends CrudRepository<MMitglied, Integer>{
	List<MMitglied> findAll();
}
