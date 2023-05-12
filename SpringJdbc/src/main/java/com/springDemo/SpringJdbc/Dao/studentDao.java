package com.springDemo.SpringJdbc.Dao;

	import java.util.List;

import com.springDemo.SpringJdbc.Student;

	public interface studentDao {

		public int insert(Student student);
		
		public int change(Student student);
		
		public int delete(int studentId);
	
        public List<Student> getAllStudents();
	
        public Student getStudent(int studentId);
	
	}

