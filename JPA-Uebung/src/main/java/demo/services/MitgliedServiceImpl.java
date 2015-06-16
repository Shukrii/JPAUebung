package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.model.MMitglied;
@Component("MitgliedService")
@Transactional
public class MitgliedServiceImpl implements MitgliedService {
	private MitgliedRepository mRepository;
	
	@Autowired
	public MitgliedServiceImpl(MitgliedRepository mRepository) {
		this.mRepository = mRepository;
	}
	
	@Override
	public List<MMitglied> findAll() {
		return mRepository.findAll();
	}

}