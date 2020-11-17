package com.first.db.controller;
import java.util.ArrayList;
import java.util.List;
//import org.springframework.web.client;
import com.first.db.model.Student;
import com.first.db.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;


@RestController
@RequestMapping(value = "/student")
public class StudentsController {

    private List<Student> students = new ArrayList<>();
    @Autowired
    RestTemplate restTemplate;
    
    @Autowired
    StudentsRepository studentsRepository;
	
	@GetMapping
	public List<Student> findAll() {
        return studentsRepository.findAll();
        }
        @GetMapping("/{id}")
	public Student findById(@PathVariable Integer id) {
        return studentsRepository.findById(id).get();
        }
        @GetMapping("/byname/{name}")
	public Student findFirstByName(@PathVariable String name) {
        return studentsRepository.findFirstByName(name);
        }
        @GetMapping("/studentsbycoursename/{name}")
	public List<Student> findStudentsByCoursename(@PathVariable String name) {
               //restTemplate=new RestTemplate();
               Integer[] s=restTemplate.getForObject("http://course-service/course/studentsids/"+name,Integer[].class);
               List<Student> sts=new ArrayList<Student>();
               for(Integer i : s)
               {
                       sts.add(studentsRepository.findById(i).get());
               }
                return sts;
        }
        
        @GetMapping("/coursebystudentname/{name}")
	public String findCourseByStudentename(@PathVariable String name) {
                Integer id=studentsRepository.findFirstByName(name).getId();
               String s=restTemplate.getForObject("http://course-service/course/coursebystudentid/"+id,String.class);
               return s;
	}
	
	@PostMapping
	public Student add(@RequestBody Student s) {
        studentsRepository.save(s);
        return s;
        }
        
        
        
      
}
