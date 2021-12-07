package ir.maktab.examination_online_system.controller;

import ir.maktab.examination_online_system.models.Professor;
import ir.maktab.examination_online_system.models.Student;
import ir.maktab.examination_online_system.models.User;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import ir.maktab.examination_online_system.resource.mapper.UserMapper;
import ir.maktab.examination_online_system.services.ProfessorService;
import ir.maktab.examination_online_system.services.StudentService;
import ir.maktab.examination_online_system.services.UserService;
import ir.maktab.examination_online_system.services.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private static final String SHOW_REGISTRATION_PAGE = "Inside showRegistrationPage()";
    private static final String INSIDE_HOME = "Inside home()";
    private static final String INSIDE_LOGIN = "Inside login()";
    private static final String INSIDE_REGISTER = "Inside register(@ModelAttribute(userDTO) UserDTO userDTO)";
    private static final String INSIDE_HEADER_ADMIN = "Inside header() Case ADMIN";
    private static final String INSIDE_HEADER_PROFESSOR = "Inside header() Case PROFESSOR";
    private static final String INSIDE_HEADER_STUDENT = "Inside header() Case STUDENT";

    private final UserService userService;

    private final StudentService studentService;

    private final ProfessorService professorService;

    private final UserMapper userMapper;


    @Autowired
    public UserController(
            UserService userService,
            StudentService studentService,
            ProfessorService professorService,
            UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.studentService = studentService;
        this.professorService = professorService;
    }

    // start the program with url in browser
    @RequestMapping(value = "/home")
    private String home(Model model) {
        LOGGER.info(INSIDE_HOME);
        model.addAttribute("msg", "sdafljadf");
        return "home/home";
    }

    // custom login page for security
    @RequestMapping("/login")
    public String login() {
        LOGGER.info(INSIDE_LOGIN);
        return "log-reg/login";
    }

    // custom registration page
    @RequestMapping("/showReg")
    public String showRegistrationPage() {
        LOGGER.info(SHOW_REGISTRATION_PAGE);
        return "log-reg/register";
    }

    // get the params from client for sign up
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("userDTO") UserDTO userDTO) {
        LOGGER.info(INSIDE_REGISTER);
        userDTO.setId(10L);

        User user = userMapper.convertDTOToEntity(userDTO);


        if (userDTO.getUserType().name().equals("STUDENT")) {
            Student student = new Student(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    user.getNationalCode(),
                    user.getEmail(),
                    user.getPassword()
            );
            studentService.saveNotSecure(student);
        } else {
            Professor professor = new Professor(
                    user.getFirstName(),
                    user.getLastName(),
                    user.getUsername(),
                    user.getNationalCode(),
                    user.getEmail(),
                    user.getPassword()
            );
            professorService.saveNotSecure(professor);
        }

        return "log-reg/login";

    }

    // get type of user after success login page
    @RequestMapping("/header")
    public String specifyUserType() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<User> user = userService.getUserByUsername(username);
        if (user.isPresent()) {
            UserType userType = user.get().getUserType();
            switch (userType) {
                case ADMIN -> {
                    // Get Type Of User; if Type is Admin We Redirect to the Admin Controller
                    LOGGER.info(INSIDE_HEADER_ADMIN);
                    return "redirect:/admin/adminWorkBench";
                }
                case PROFESSOR -> {
                    // Get Type Of User; if Type is Professor We Redirect to the Professor Controller
                    LOGGER.info(INSIDE_HEADER_PROFESSOR);
                    return "redirect:/professor/professorWorkBench";
                }
                case STUDENT -> {
                    // Get Type Of User; if Type is Student We Redirect to the Student Controller
                    LOGGER.info(INSIDE_HEADER_STUDENT);
                    return "redirect:/student/studentWorkBench";
                }
            }

        }
        return "home/home";
    }
}


