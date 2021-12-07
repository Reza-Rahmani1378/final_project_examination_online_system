package ir.maktab.examination_online_system.controller;


import ir.maktab.examination_online_system.models.Course;
import ir.maktab.examination_online_system.models.Professor;
import ir.maktab.examination_online_system.models.Student;
import ir.maktab.examination_online_system.models.User;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import ir.maktab.examination_online_system.resource.mapper.CourseMapper;
import ir.maktab.examination_online_system.resource.mapper.UserMapper;
import ir.maktab.examination_online_system.resource.mapper.extra.ChangeStatusUserMapper;
import ir.maktab.examination_online_system.services.CourseService;
import ir.maktab.examination_online_system.services.UserService;
import ir.maktab.examination_online_system.services.dto.CourseDTO;
import ir.maktab.examination_online_system.services.dto.UserDTO;
import ir.maktab.examination_online_system.services.dto.extra.ChangeStatusUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    private static final String MESSAGE = "Your Course Added Successfully";
    private static final String MESSAGE_ADD_USER_TO_COURSE = "Your User Added Successfully";
    private final UserService userService;
    private final UserMapper userMapper;
    private final ChangeStatusUserMapper changeStatusUserMapper;
    private final CourseMapper courseMapper;
    private final CourseService courseService;

    @Autowired
    public AdminController(UserService userService, UserMapper userMapper,
                           CourseMapper courseMapper,
                           CourseService courseService,
                           ChangeStatusUserMapper changeStatusUserMapper) {

        this.userService = userService;
        this.userMapper = userMapper;
        this.courseMapper = courseMapper;
        this.courseService = courseService;
        this.changeStatusUserMapper = changeStatusUserMapper;
    }

    // Get Type Of User; if Type is Admin We Redirect to the Admin Controller
    @RequestMapping(value = "adminWorkBench")
    public String adminWorkBench() {
        return "adminWorkbench";
    }

    @RequestMapping(value = "/listOfUsers")
    public String getUsers(@RequestParam(value = "keyword", required = false) String keyword, Model model, HttpSession session) {
        List<User> users = userService.getUsers(keyword);
        List<UserDTO> userPage = userMapper.convertListEntityToDTO(users);

        Optional<User> user = getUser(session);
        model.addAttribute("listOfUsers", userPage);
        model.addAttribute("logedUser", user);
        model.addAttribute("keyword", keyword);
        return "listOfUsers";
    }

    // We Can Add User To The Course That Admin Wants to Add Course
    @RequestMapping(value = "/listOfCourses")
    public String getCourses(@RequestParam(
            value = "keyword", required = false) String keyword,
                             Model model,
                             @RequestParam(value = "courseId", required = false) Long courseId,
                             HttpSession session) {
        List<CourseDTO> courses = courseMapper.convertListEntityToDTO(
                courseService.getCourses(keyword)
        );
        Long userId = (Long) session.getAttribute("userId");
        if (userId != null && courseId != null) {
            User user = userService.findByIdNotSecure(userId).get();
            Course course = courseService.findByIdNotSecure(courseId).get();
            if (user.getUserType().name().equals(UserType.STUDENT.name())) {

                Student student = (Student) user;
                course.getStudents().add(student);
                courseService.saveNotSecure(course);
                model.addAttribute("msg", "User Added Successfully");
                return "successAddedUser";
            } else {
                Professor professor = (Professor) user;
                course.setProfessor(professor);
                courseService.saveNotSecure(course);
                model.addAttribute("msg", "User Added Successfully");
                return "successAddedUser";
            }

        }
//        else if (Objects.isNull(userId)) {
//
//        }
        model.addAttribute("listOfCourses", courses);
        model.addAttribute("keyword", keyword);
        return "listOfCourses";
    }

    @RequestMapping(value = "/addCourse")
    public String addCourse() {
        return "addCourse";
    }

    @RequestMapping(value = "/success", method = RequestMethod.POST)
    public String confirmAddedCourse(@ModelAttribute("courseDTO") CourseDTO courseDTO, Model model) {
        LOGGER.info("inside addCourse() in AdminController");
        LocalDate now = LocalDate.now();
        LocalDate startCourse = courseDTO.getStartCourse();
        LocalDate endCourse = courseDTO.getEndCourse();
        if (startCourse.compareTo(now) < 0 || endCourse.compareTo(now) < 0 || endCourse.compareTo(startCourse) < 0) {
            model.addAttribute("msg", "Dates for start or end course is not valid please try again..");
            return "addCourse";
        }
        Course course = courseMapper.convertDTOToEntity(courseDTO);
        courseService.saveNotSecure(course);
        model.addAttribute("msg", MESSAGE);
        return "successAddedCourse";
    }


    // Get Id from Admin for Added To the Course...
    @RequestMapping(value = "/addUser")
    public String addUserToCourse(@RequestParam("userId") Long userId, HttpSession session) {
        session.setAttribute("userId", userId);
        return "redirect:/admin/listOfCourses";
    }


    @RequestMapping(value = "/confirmAddedUser")
    public String confirmAddedUser(Model model) {

        Long id = (Long) model.getAttribute("userId");
        return null;
    }

    @RequestMapping(value = "/viewUsersOfCourse")
    public String viewUsersOfCourse(@RequestParam(value = "courseId") Long courseId, Model model) {
        Course course = courseService.findByIdNotSecure(courseId).get();
        Professor professor = course.getProfessor();
        Set<Student> students = course.getStudents();
        model.addAttribute("professor", professor);
        model.addAttribute("students", students);
        model.addAttribute("course", course);

        return "viewUsersOfCourse";
    }

    // Edit User
    @RequestMapping(value = "/editUser")
    public String editUser(@RequestParam(value = "userId") Long userId, Model model) {
        model.addAttribute("userId", userId);
        return "editUser";
    }

    @RequestMapping(value = "/confirmEditUser")
    public String confirmEditUser(Model model, @ModelAttribute(value = "changeStatusUserDTO") ChangeStatusUserDTO changeStatusUserDTO
            , @RequestParam(value = "userId") Long userId) {
        User editUser = userService.findByIdNotSecure(userId).get();
        if (changeStatusUserDTO.getIsConfirmed().equals("YES"))
            editUser.setConfirmed(true);
        else
            editUser.setConfirmed(false);
        editUser.setUserType(changeStatusUserDTO.getUserType());
        model.addAttribute("msg", "User Edited Successfully");
        userService.saveNotSecure(editUser);
        return "successEditedUser";

    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUserById(Model model, @RequestParam(value = "userId") Long userId) {
        userService.deleteByIdNotSecure(userId);
        model.addAttribute("msg", "User Deleted Successfully");
        return "successDeleteUser";
    }


    // get user for add user to header.jsp
    public Optional<User> getUser(HttpSession session) {
        return (Optional<User>) session.getAttribute("logedUser");
    }


}
