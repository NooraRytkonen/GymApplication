package hh.swd.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GroupExerciseRepository extends CrudRepository<GroupExercise, Long>{
	
	 // List<GourpExercise> findById(Long id);
	
	List<GroupExercise> findByName (String string);
}

