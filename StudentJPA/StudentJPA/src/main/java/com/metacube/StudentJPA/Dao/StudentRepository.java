package com.metacube.StudentJPA.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.StudentJPA.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
