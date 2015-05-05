package demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.model.KKunde;

@Component("playListService")
@Transactional
public class KundeServiceImpl implements KundeService {
	private KundeRepository kundeRepository;
	
	@Autowired
	public KundeServiceImpl(KundeRepository kundeRepository) {
		this.kundeRepository = kundeRepository;
	}
	
	@Override
	public List<KKunde> findAll() {
		return (List<KKunde>) kundeRepository.findAll();
	}

}