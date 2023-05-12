package com.springDemo.SpringJdbc.Dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springDemo.SpringJdbc.Student;

public class studentDaoImpl implements studentDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		String query = "insert into student(id,name,city)values(?,?,?)";
		int r = jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
		return r;
	}

	public int change(Student student) {

		String query = "update student set name=?, city=? where id=?";
		int r = jdbcTemplate.update(query,student.getName(), student.getCity(), student.getId());
		return r;
	}

	public int delete(int studentId) {
        String query="delete from student where id=?";
        int r = jdbcTemplate.update(query, studentId);

        return r;
	}
	
	public Student getStudent(int studentId) {
		String query="select*from student where id=?";
		RowMapper<Student> rowmapper=new RowMapperImpl();
		 Student r = jdbcTemplate.queryForObject(query, rowmapper,studentId);

		return r;
	}
	

	public List<Student> getAllStudents() {
         String query="select*from student";
         List<Student> list = jdbcTemplate.query(query,new RowMapperImpl());
		
		return list;
	}

	

}
