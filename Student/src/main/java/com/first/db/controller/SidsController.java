package com.first.db.controller;
import java.util.ArrayList;
import java.util.List;
import com.first.db.model.Student;
import com.first.db.model.Sid;
import com.first.db.repository.SidsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
 
@RestController
@RequestMapping(value = "/sid")
public class SidsController {

    private List<Sid> sids = new ArrayList<>();
    @Autowired
    SidsRepository sidsRepository;
	
	@GetMapping
	public List<Sid> findAll() {
        return sidsRepository.findAll();
        }
        @GetMapping("/{id}")
	public Sid findById(@PathVariable Integer id) {
        return sidsRepository.findById(id).get();
	}
	
	@PostMapping
	public Sid add(@RequestBody Sid c) {
        sidsRepository.save(c);
        return c;
        }
/*
        @DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
        sidsRepository.deleteById(id);
        }
       */ 
      
}
