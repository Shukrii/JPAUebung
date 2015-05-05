package demo.services;

import java.util.List;

import demo.model.AAuto;

public interface AutoService  {
	List<AAuto> findByNameLike(String name);
	AAuto findOne(int id);
	AAuto save(AAuto a);
	void delete(int id);
	long length();
}
