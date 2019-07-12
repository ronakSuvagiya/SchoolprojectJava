package com.SchoolManagement.service;

import java.util.List;
import com.SchoolManagement.dto.StudentDto;
import com.SchoolManagement.enitiy.Student;

public interface StudentSerivce {
	public void addStudent(StudentDto studentDto);

	public void updateStudents(StudentDto student);

	public void deleteStudents(StudentDto student);

	public List<Student> selectStudent(Integer school);

	public Student findById(Integer id);

	public List<Student> findByStdAndDivId(Integer std, Integer div);
}
