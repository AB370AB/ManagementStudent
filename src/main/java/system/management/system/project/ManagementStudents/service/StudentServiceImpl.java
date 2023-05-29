package system.management.system.project.ManagementStudents.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.management.system.project.ManagementStudents.entity.Student;
import system.management.system.project.ManagementStudents.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepository stRepo;

    public StudentServiceImpl(StudentRepository stRepo) {
        this.stRepo = stRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        return stRepo.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return stRepo.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return stRepo.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return stRepo.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        stRepo.deleteById(id);
    }

}
