package demo.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import demo.model.KKunde;

public interface KundeRepository extends CrudRepository<KKunde, Integer> {
	@Query("select a from KKunde a where a.kName like :name")
	List<KKunde> findByNameLike(@Param("name") String name);
}

