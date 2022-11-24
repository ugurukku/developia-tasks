package com.ugur.developia.dataAccessLayer;

import com.ugur.developia.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {


}
