package ir.maktab.examination_online_system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    // Get Type Of User; if Type is Professor We Redirect to the Professor Controller
    @RequestMapping(value = "studentWorkBench")
    public String adminWorkBench() {
        return "studentWorkbench";
    }
}
