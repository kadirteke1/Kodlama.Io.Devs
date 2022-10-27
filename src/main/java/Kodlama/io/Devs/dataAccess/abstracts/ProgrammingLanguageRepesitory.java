package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concrete.ProgrammingLanguage;

public interface ProgrammingLanguageRepesitory {
	List<ProgrammingLanguage> getAll();
	ProgrammingLanguage getById(int id);
	void add(ProgrammingLanguage programmingLanguage);
	void delete(int id);
	void update(ProgrammingLanguage programmingLanguage);
}
