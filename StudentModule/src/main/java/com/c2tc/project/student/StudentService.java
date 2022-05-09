package com.c2tc.project.student;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	private StudentRepository repo;
	
	public List<StudentModule> listAll() 
	{
		return repo.findAll();
	}
	
	public void save(StudentModule student) {
		repo.save(student);
	}
	
	public StudentModule get(Integer id) 
	{
		return repo.findById(id).get();
	}

	public void delete(Integer id) 
	{
		 repo.deleteById(id);
	}
}
