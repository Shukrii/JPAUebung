package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.model.AAuto;


@Component("autoService")
@Transactional	// Spring provides a transaction manager specifically for JPA.
public class AutoServiceImpl implements AutoService {
	private final AutoRepository aRepository;
	@Autowired
	public AutoServiceImpl(AutoRepository aRepository) {
		this.aRepository = aRepository;
	}
	
	@Override
	public List<AAuto> findAll() {
		return (List<AAuto>) aRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public List<AAuto> findByNameLike(String name) {
		//return null;
		
		return ((AutoServiceImpl) aRepository).findByNameLike(name);
	}
	@Override
	@Transactional(readOnly=true)
	public AAuto findOne(int id) {
		return aRepository.findOne(id);
	}
	@Override
	public AAuto save(AAuto a) {
		return aRepository.save(a);
	}
	@Override
	public void delete(int id) {
		aRepository.delete(id);
	}
	@Override
	@Transactional(readOnly=true)
	public long length() {
		return aRepository.count();
	}

	

}
