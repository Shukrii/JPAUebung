package demo.services;

import java.util.List;

import demo.model.*;

public interface KundeService {
	List<KKunde> findAll();
	KKunde findByNameLike(String kunde);
	KKunde findOne(int id);
	KKunde save(KKunde k);
	void delete(int id);
	long length();
	
}

