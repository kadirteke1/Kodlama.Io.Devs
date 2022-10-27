package Kodlama.io.Devs.dataAccess.concretes;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepesitory;
import Kodlama.io.Devs.entities.concrete.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepesitory {

	List<ProgrammingLanguage> languages;

	public InMemoryProgrammingLanguageRepository() {
		languages = new ArrayList<ProgrammingLanguage>();
		languages.add(new ProgrammingLanguage(1, "C#"));
		languages.add(new ProgrammingLanguage(2, "PHP"));
		languages.add(new ProgrammingLanguage(3, "Java"));
		languages.add(new ProgrammingLanguage(4, "Phyton"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return languages;
	}

	@Override
	public ProgrammingLanguage getById(int id) {

		for (ProgrammingLanguage programmingLanguage : languages) {
			if (programmingLanguage.getId() == id) {
				return programmingLanguage;

			}
		}
		return null;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {

		languages.add(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage language = getById(id);
		languages.remove(language);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		for (ProgrammingLanguage programmingLanguage_ : languages) {
			if (programmingLanguage_.getId() == programmingLanguage.getId()) {
				programmingLanguage_.setName(programmingLanguage.getName());
			}
		}
	}
}
