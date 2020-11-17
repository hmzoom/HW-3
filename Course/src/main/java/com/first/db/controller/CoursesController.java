package com.first.db.controller;
import java.util.ArrayList;
import java.util.List;
import com.first.db.model.Course;
import com.first.db.model.Sid;
import com.first.db.repository.CoursesRepository;
import com.first.db.repository.SidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
 
@RestController
@RequestMapping(value = "/course")
public class CoursesController {

    private List<Course> courses = new ArrayList<>();
    @Autowired
    CoursesRepository coursesRepository;
    @Autowired
    SidsRepository sidsRepository;
	
	@GetMapping
	public List<Course> findAll() {
        return coursesRepository.findAll();
        }
        @GetMapping("/{id}")
	public Course findById(@PathVariable Integer id) {
        return coursesRepository.findById(id).get();
	}
        @GetMapping("/studentsids/{name}")
	public List<Integer> findByName(@PathVariable String name) {
        Course c= coursesRepository.findFirstByName(name);
        List<Sid> sids=c.getSids();
        List<Integer> ids=new ArrayList<Integer>();
        for(Sid s:sids)
        {
                ids.add(s.getStudentId());
        }
        return ids;
        }
        @GetMapping("/coursebystudentid/{id}")
	public String findByStudentId(@PathVariable Integer id) {
        Sid s= sidsRepository.findFirstByStudentId(id);
        return s.getCourse().getName();
        }
        @PostMapping
	public Course add(@RequestBody Course c) {
        coursesRepository.save(c);
        return c;
        }

      
}
