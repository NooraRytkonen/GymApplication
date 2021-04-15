package hh.swd.harjoitustyo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GroupExercise {
	
	@Id // primary key 
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id; // new attribute id
	private String name;
	private String desc;
	private String duration;
	private String startingTime;
	private String endingTime;
	private String date;
	
    @ManyToOne // 
    @JoinColumn(name = "categoryid") // foreign key of table
    private Category category; // attribute from other table
  
    
    public GroupExercise () {
    }

	public GroupExercise(String name, String desc, String duration, String startingTime, String endingTime,
			String date, Category category) {
		super();
		this.name = name;
		this.desc = desc;
		this.duration = duration;
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.date = date;
		this.category = category;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(String startingTime) {
		this.startingTime = startingTime;
	}

	public String getEndingTime() {
		return endingTime;
	}

	public void setEndingTime(String endingTime) {
		this.endingTime = endingTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		if (this.category != null)
			return "GroupExercise [id=" + id + ", name=" + name + ", desc=" + desc + ", duration=" + duration + ", startingTime=" + startingTime + ", endingTime=" + endingTime + ", date=" + date +  " category =" + this.getCategory() + "]";		
		else
			return "GroupExercise [id=" + id + ", name=" + name + ", desc=" + desc + ", duration=" + duration + ", startingTime=" + startingTime + ", endingTime=" + endingTime + ", date=" + date + "]";
	}
    
}
