package library.controller;

import library.model.Student;
import library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/students")
    public String listStudents(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listStudents", studentService.listStudents());
        return "student";
    }

    @PostMapping(value = "/student/add")
    public String addStudent(@ModelAttribute("student") Student student) {
        if (student.getId() == 0) {
            this.studentService.addStudent(student);
        } else {
            this.studentService.updateStudent(student);
        }
        return "redirect:/students";
    }

    @RequestMapping(value = "/student/remove/{id}")
    public String deleteStudent(@PathVariable("id") int id) {
        this.studentService.deleteStudent(id);
        return "redirect:/students";
    }

    @RequestMapping(value = "/student/{id}")
    public String editStudent(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", this.studentService.getStudentById(id));
        model.addAttribute("listStudents", this.studentService.listStudents());
        return "student";
    }
}
