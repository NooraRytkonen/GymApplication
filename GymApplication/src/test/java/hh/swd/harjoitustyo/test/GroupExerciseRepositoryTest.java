package hh.swd.harjoitustyo.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd.harjoitustyo.domain.GroupExercise;
import hh.swd.harjoitustyo.domain.GroupExerciseRepository;

//@RunWith(SpringRunner.class)  
@ExtendWith(SpringExtension.class)  
@DataJpaTest
public class GroupExerciseRepositoryTest {

    @Autowired
    private GroupExerciseRepository repository;

    
    @Test // testing GroupExerciseRepository's save()-method
    public void createNewGroupExercise() {

    	GroupExercise exercise = new GroupExercise("Example", "Example", "30min", "15:00", "15:30", "20.10.2090", null);
    	repository.save(exercise);
    	assertThat(exercise.getId()).isNotNull();
    }   
    
    @Test // testing GroupExerciseRepository's delete()-method
    public void deleteGroupExercise() {

      List<GroupExercise> exercise = repository.findByName("Yoga");
		
		if(exercise != null) {
			repository.deleteById(exercise.get(0).getId());
		}
    }
    
    @Test // testing GroupExerciseRepository's search()-method
    public void searchGroupExercise() {
    	List<GroupExercise> exercises = repository.findByName("Yoga");
    	//assertThat(exercises).hasSize(1);
        assertThat(exercises.get(0).getName()).isEqualTo("Yoga");
    }


}