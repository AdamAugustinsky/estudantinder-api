package org.estudantinder.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Preferences {

    @Id
    @GeneratedValue
    private Long id;

    private int school_year;
    private int shift;
    private String gender;

    @ManyToOne
    private Course course;

    @ManyToOne
    private School school;

    @ManyToMany
    private List<Subject> subjects;

    public int getSchool_year() {
        return school_year;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSchool_year(int school_year) {
        this.school_year = school_year;
    }


}
