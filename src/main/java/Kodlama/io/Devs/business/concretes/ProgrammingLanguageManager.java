package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepesitory;
import Kodlama.io.Devs.entities.concrete.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepesitory programingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepesitory programingLanguageRepository) {
		this.programingLanguageRepository = programingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programingLanguageRepository.getAll();
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		return programingLanguageRepository.getById(id);
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		if (programmingLanguage.getName() != null) {
			for (ProgrammingLanguage language : programingLanguageRepository.getAll()) {
				if (language.getName().equalsIgnoreCase(programmingLanguage.getName())) {
					throw new Exception("İsimler tekrar edemez.");
				}
				programingLanguageRepository.add(programmingLanguage);
			}
		} else {
			throw new Exception("İsimler boş bırakılamaz.");
		}
	}

	@Override
	public void delete(int id) {
		programingLanguageRepository.delete(id);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		programingLanguageRepository.update(programmingLanguage);
	}

}
