package hh.swd.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Category {
	
	@Id // primary key 
	@NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id; // new attribute id
	@Size(min=2, max=20)
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties ("category") 
	private List<GroupExercise> groupExercices;
	
	
	public Category () {
	}


	public Category(String name) {
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<GroupExercise> getGroupExercices() {
		return groupExercices;
	}


	public void setGroupExercices(List<GroupExercise> groupExercices) {
		this.groupExercices = groupExercices;
	}


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
	
	
}