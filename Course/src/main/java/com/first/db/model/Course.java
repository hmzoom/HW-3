package com.first.db.model;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
	private String name;
	
    @OneToMany(mappedBy = "course",fetch = FetchType.LAZY,
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
	public List < Sid > getSids() {
        return sids;
    }

    public void setSids(List < Sid > sids) {
        this.sids = sids;
    }

}
