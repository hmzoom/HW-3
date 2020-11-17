package com.first.db.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.persistence.Id;
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
	private Integer age;
	@Column(name = "gender")
	private String gender;
	@JsonIgnore @OneToMany(mappedBy = "student",fetch = FetchType.LAZY,
	cascade = CascadeType.ALL)
    private List<Sid> sids;
		public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	public List < Sid > getSids() {
        return sids;
    }

    public void setSids(List < Sid > sids) {
        this.sids = sids;
    }

}
