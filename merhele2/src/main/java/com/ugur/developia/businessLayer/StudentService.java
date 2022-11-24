package com.ugur.developia.businessLayer;

import com.ugur.developia.dataAccessLayer.StudentRepository;
import com.ugur.developia.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements Operations<Student>{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Integer id) {
            return studentRepository.findById(id).get();
    }

    @Override
    public boolean removeById(Integer id) {
        studentRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean add(Student student) {
        studentRepository.save(student);
        return true;
    }

    @Override
    public boolean updateById(Student entity, Integer id) {

        Student student = studentRepository.findById(id).get();

        student.setStudentName(entity.getStudentName());
        student.setStudentSurname(entity.getStudentSurname());
        student.setStudentBirthdate(entity.getStudentBirthdate());
        student.setSector(entity.getSector());

        studentRepository.save(student);
        return true;
    }
}
