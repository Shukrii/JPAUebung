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

	@Override
	 @Transactional(readOnly=true)
	 public KKunde findByNameLike(String kunde) {
	  return (KKunde) kundeRepository.findByNameLike(kunde);
	 }
	 @Override
	 @Transactional(readOnly=true)
	 public KKunde findOne(int id) {
	  return kundeRepository.findOne(id);
	 }
	 @Override
	 public KKunde save(KKunde k) {
	  return kundeRepository.save(k);
	 }
	 @Override
	 public void delete(int id) {
	  kundeRepository.delete(id);
	 }
	 @Override
	 @Transactional(readOnly=true)
	 public long length() {
	  return kundeRepository.count();
	 }
}