package system.management.system.project.ManagementStudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.management.system.project.ManagementStudents.entity.Student;
import system.management.system.project.ManagementStudents.repository.StudentRepository;
import system.management.system.project.ManagementStudents.service.StudentService;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/students")
    public String getAllStudentName(Model model){
         List<Student> studentsList = service.getAllStudents();
         model.addAttribute("students", studentsList);
         return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        //create Student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        service.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model){
        model.addAttribute("student", service.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
        //get student from database by id
        Student existingStudent = service.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        service.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        service.deleteStudentById(id);
        return "redirect:/students";


    }

}
