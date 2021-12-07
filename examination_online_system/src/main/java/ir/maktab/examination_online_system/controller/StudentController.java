package ir.maktab.examination_online_system.controller;


import ir.maktab.examination_online_system.models.Course;
import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.services.*;
import ir.maktab.examination_online_system.util.JsonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    private final UserService userService;
    private final CourseService courseService;
    private final ExamService examService;
    private final QuestionsService questionsService;
    private final StudentResultExamService studentResultExamService;

    @Autowired
    public StudentController(UserService userService,
                             CourseService courseService,
                             ExamService examService,
                             QuestionsService questionsService,
                             StudentResultExamService studentResultExamService) {
        this.userService = userService;
        this.courseService = courseService;
        this.examService = examService;
        this.questionsService = questionsService;
        this.studentResultExamService = studentResultExamService;
    }

    // Get Type Of User; if Type is Professor We Redirect to the Professor Controller
    @RequestMapping(value = "/studentWorkBench")
    public String studentWorkBench() {
        return "studentWorkbench";
    }

    @RequestMapping(value = "/studentCourses")
    public String studentCourses(HttpServletRequest request, Model model, HttpSession session) {
        String username = userService.getUsername();
        Long id = userService.getUserByUsername(username).get().getId();
        session.setAttribute("studentId", id);
        List<Course> courses = (List<Course>) courseService.findCoursesByStudentId(id);
        PagedListHolder pagedListHolder = new PagedListHolder(courses);
        LOGGER.info("Into Student Courses");
        int page = ServletRequestUtils.getIntParameter(request, "p", 0);
        pagedListHolder.setPage(page);
        pagedListHolder.setPageSize(5);
        model.addAttribute("pagedListHolder", pagedListHolder);
        model.addAttribute("courses", courses);
        model.addAttribute("msg", "");
        return "listOfCoursesStudent";
    }

    // get Exam of Student By courseId
    @RequestMapping(value = "/studentExams")
    public String studentExams(@RequestParam(value = "courseId") Long courseId, Model model) {
        List<Exam> allowForStudent = examService.findExamsByCourseId(courseId);
        model.addAttribute("allowExamForStudent", allowForStudent);
        return "listAllowExamForStudent";
    }

    @RequestMapping(value = "/onlineExam")
    public String onlineExam(HttpSession session, HttpServletRequest request, @RequestParam(value = "examId") Long examId, @RequestParam(value = "page") int page) {

        if (session.getAttribute("exam") == null) {
            Set<Questions> questions = questionsService.findAllByExamId(examId);
            session.setAttribute("examId", examId);
            session.setAttribute("questions", questions);
            session.setAttribute("page", page);
        } else {
            session.setAttribute("page", request.getParameter("page"));
            session.setAttribute("questionId", request.getParameter("questionId"));
            System.out.println(request.getParameter("questionId"));
        }


        return "onlineExamScreen";
    }


    @RequestMapping(value = "jsonConverter")
    private void convertQuestionToJson(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        List<Questions> questions = (List<Questions>) session.getAttribute("questions");

        JsonConverter jsonConverter = new JsonConverter();
//        List strings = new ArrayList<>();
//        for (Questions question : questions) {
//            strings.add(question.getQuestionTitle());
//            strings.add(question.getQuestionText());
//            strings.add(question.getQuestionType().name());
//            strings.add(question.getQuestionAnswer());
//            for (QuestionScore<Long> questionScore : question.getQuestionScores()) {
//                strings.add(questionScore);
//            }
//            for (QuestionOption questionOption : question.getQuestionOptions()) {
//                strings.add(questionOption);
//            }
//        }
        String output = jsonConverter.convertToJson(questions);
        PrintWriter out = response.getWriter();
        out.print(output);

    }

    @RequestMapping(value = "/startExam")
    public String startExam(@RequestParam(value = "examId") Long examId, Model model, HttpSession session) {
//        List<Questions> questions = questionsService.findAllByExamId(examId);
//        List<QuestionDTOList> questionDTOLists = questionsService.getQuestionDTOList(questions);
//        model.addAttribute("start",questionDTOLists.get(0));
//        model.addAttribute("end",questionDTOLists.get(questionDTOLists.size()-1));
//        questionDTOLists.remove(0);
//        questionDTOLists.remove(questionDTOLists.size() -1);
//        model.addAttribute("list",questionDTOLists);

        Long studentId = (Long) session.getAttribute("studentId");
        String studentAllow = studentResultExamService.checkIsAllowStudentForExam(studentId);
        if (studentAllow == null) {
            Exam exam = examService.findByIdNotSecure(examId).get();
            model.addAttribute("exam", exam);
            return "startExam";
        }
        model.addAttribute("msg", studentAllow);
        return "examWarningPage";
    }

    @RequestMapping(value = "/endExam", method = RequestMethod.POST)
    public String endExam(@RequestParam(value = "answer") List<String> answers) {
        System.out.println(answers.size());
        return null;
    }
}
