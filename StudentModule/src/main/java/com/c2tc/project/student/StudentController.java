package com.c2tc.project.student;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;

	 // RESTful API methods for Retrieval operations 
	@GetMapping("/studentmodule")
	public List<StudentModule> list()
	{
		return service.listAll();
	}
	
	 
	@GetMapping("/studentmodule/{id}")
	public ResponseEntity<StudentModule> get(@PathVariable Integer id) {
		try {
			StudentModule student = service.get(id);
			return new ResponseEntity<StudentModule>(student, HttpStatus.OK);
		}
		catch (NoSuchElementException e) 
		{
			return new ResponseEntity<StudentModule>(HttpStatus.NOT_FOUND);
		}
	}
	
	// RESTful API methods for Create operations 
	@PostMapping("/studentmodule")
	public void add(@RequestBody StudentModule student)
	{
		service.save(student);
	}
	
	// RESTful API methods for Update operations 
	@PutMapping("/studentmodule/{id}")
	public ResponseEntity<?> update(@RequestBody StudentModule student , @PathVariable Integer id) {
	try {	
		StudentModule estudent = service.get(id);
		service.save(student);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	catch (NoSuchElementException e) 
	{
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	// RESTful API method for Delete operation 
/*		@DeleteMapping("/studentmodule/{id}")
		public void delete(@PathVariable Integer id)
		{
			service.delete(id);
		}
 */
  }
	
}
