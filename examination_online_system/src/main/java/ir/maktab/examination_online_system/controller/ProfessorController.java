package ir.maktab.examination_online_system.controller;


import ir.maktab.examination_online_system.models.Course;
import ir.maktab.examination_online_system.models.Exam;
import ir.maktab.examination_online_system.models.QuestionBank;
import ir.maktab.examination_online_system.models.Questions;
import ir.maktab.examination_online_system.models.embeddable.QuestionOption;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import ir.maktab.examination_online_system.resource.mapper.ExamMapper;
import ir.maktab.examination_online_system.resource.mapper.QuestionsMapper;
import ir.maktab.examination_online_system.services.*;
import ir.maktab.examination_online_system.services.dto.ExamDTO;
import ir.maktab.examination_online_system.services.dto.QuestionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping(value = "/professor")
public class ProfessorController {

    private final UserService userService;

    private final CourseService courseService;

    private final ExamService examService;

    private final QuestionBankService questionBankService;

    private final QuestionsService questionsService;

    private final ExamMapper examMapper;

    private final QuestionsMapper questionsMapper;

    @Autowired
    public ProfessorController(UserService userService,
                               CourseService courseService,
                               ExamService examService,
                               QuestionBankService questionBankService,
                               QuestionsService questionsService,
                               ExamMapper examMapper,
                               QuestionsMapper questionsMapper) {
        this.userService = userService;
        this.courseService = courseService;
        this.examService = examService;
        this.questionBankService = questionBankService;
        this.questionsService = questionsService;
        this.examMapper = examMapper;
        this.questionsMapper = questionsMapper;
    }

    // Get Type Of User; if Type is Professor We Redirect to the Professor Controller
    @RequestMapping(value = "professorWorkBench")
    public String adminWorkBench() {
        return "professorWorkbench";
    }

    //
    @RequestMapping(value = "/listOfCoursesProfessor")
    private String listOfCourses(Model model) {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = userService.getUserByUsername(username).get().getId();
        List<Course> courses = courseService.findCoursesByProfessorId(id);
        model.addAttribute("courses", courses);
        return "listOfCoursesProfessor";
    }

    @RequestMapping(value = "/viewExamsOfCourse")
    private String listOfExams(@RequestParam(value = "courseId") Long courseId, Model model) {
        List<Exam> exams = examService.getExamsByCourseId(courseId);
        model.addAttribute("courseId", courseId);
        model.addAttribute("exams", exams);
        return "listOfExamsOfCoursesProfessor";
    }


    @RequestMapping(value = "/addExam")
    private String addExam(@RequestParam(value = "courseId") Long courseId, Model model) {
//        Course course = courseService.findByIdNotSecure(courseId).get();
//        Exam exam = examMapper.convertDTOToEntity(examDTO);
        model.addAttribute("courseId", courseId);
        return "addExam";
    }

    // post parames for confirm exam form addExam.jsp
    @RequestMapping(value = "/confirmExam", method = RequestMethod.POST)
    private String confirmExam(@ModelAttribute("courseId") Long courseId,
                               @ModelAttribute("examDTO") ExamDTO examDTO,
                               Model model) {
        Course course = courseService.findByIdNotSecure(courseId).get();
        Exam exam = examMapper.convertDTOToEntity(examDTO);
        exam.setCourse(course);
        examService.saveNotSecure(exam);
        model.addAttribute("msg", "Your Exam Added Successfully");
        return "successAddedExam";
    }

    // get id for edit exam
    @RequestMapping(value = "/editExam")
    private String editExam(@RequestParam(value = "examId") Long examId,
                            @RequestParam(value = "courseId") Long courseId, Model model) {

        // pass the question bank to the edit exam and send to the another jsp file for add question to the exam.

        QuestionBank questionBank = questionBankService.getQuestionBankByCourseId(courseId);
        List<Questions> questions = questionsService.getQuestionsByQuestionBankId(questionBank.getId());
        model.addAttribute("examId", examId);
        model.addAttribute("courseId", courseId);
        model.addAttribute("questions", questions);
        return "editExam";
    }

    @RequestMapping(value = "/confirmEditExam", method = RequestMethod.POST)
    private String confirmEditExam(@ModelAttribute("examId") Long examId,
                                   @ModelAttribute("examDTO") ExamDTO examDTO, Model model) {

        // This Part is for edit title and description and time of exam

        Exam exam = examService.findByIdNotSecure(examId).get();
        exam.setTimeExam(examDTO.getTimeExam());
        exam.setDescription(examDTO.getDescription());
        exam.setTitle(examDTO.getTitle());
        examService.saveNotSecure(exam);
        model.addAttribute("msg", "Your Edit Of Exam Done Successfully");
        return "successEditedExam";
    }

    // Delete Exam By Id Of Exam That get from client
    @RequestMapping(value = "/deleteExam")
    private String deleteExam(@RequestParam(value = "examId") Long examId, Model model) {

        examService.deleteByIdNotSecure(examId);
        model.addAttribute("msg", "Your Exam Deleted Successfully");
        return "successDeleteExam";
    }

    // get examId from view exams of course and find all questions exam that we find it
    @RequestMapping(value = "/listOfQuestionsOfExam")
    private String getQuestionsByExamId(@RequestParam(value = "examId") Long examId, Model model) {
        List<Questions> questions = questionsService.findAllByExamId(examId);
        model.addAttribute("questions", questions);
        model.addAttribute("examId", examId);
        return "listOfQuestionsOfExamProfessor";
    }

    // Add Question By examId
    @RequestMapping(value = "/addQuestion")
    private String addQuestion(Model model, @RequestParam(value = "courseId") Long courseId,
                               @RequestParam(value = "examId") Long examId) {
        model.addAttribute("courseId", courseId);
        model.addAttribute("examId", examId);
        return "addQuestion";
    }

    // Add Question By Type id
    @RequestMapping(value = "/confirmAddQuestionDescriptive", method = RequestMethod.POST)
    private String confirmAddQuestionDescriptive(@ModelAttribute(value = "questionsDTO") QuestionsDTO questionsDTO,
                                                 @ModelAttribute("examId") Long examId,
                                                 @ModelAttribute("courseId") Long courseId,
                                                 @ModelAttribute("questionScore") QuestionScore<Long> questionScore,
                                                 Model model) {
        QuestionBank questionBank = questionBankService.getQuestionBankByCourseId(courseId);
        Exam exam = examService.findByIdNotSecure(examId).get();
        Questions questions = questionsMapper.convertDTOToEntity(questionsDTO);
        questions.setQuestionBank(questionBank);
        // set default score for any question that professor can change that
        questionsService.saveWithDefaultScore(questions, exam, questionScore);
        model.addAttribute("msg", "Question Added Successfully To The Exam");
        return "successAddedQuestion";
    }

    // Add Question Type By id
    @RequestMapping(value = "/confirmAddQuestionOptional", method = RequestMethod.POST)
    private String confirmAddQuestionOptional(@RequestParam("options") List<String> options,
                                              @ModelAttribute("examId") Long examId, @ModelAttribute(value = "questionsDTO") QuestionsDTO questionsDTO,
                                              @ModelAttribute("courseId") Long courseId,
                                              @ModelAttribute("questionScore") QuestionScore<Long> questionScore,
                                              Model model) {
        QuestionBank questionBank = questionBankService.getQuestionBankByCourseId(courseId);
        Exam exam = examService.findByIdNotSecure(examId).get();
        Questions questions = questionsMapper.convertDTOToEntity(questionsDTO);
//        QuestionOption questionOption = new QuestionOption();
        Set<QuestionOption> questionOptions = new HashSet<>();
        for (String option : options) {
            QuestionOption questionOption = QuestionOption.builder()
                    .optionText(option)
                    .build();
            questionOptions.add(questionOption);
        }
        questions.setQuestionOptions(questionOptions);
        questions.setQuestionBank(questionBank);
        questionsService.saveWithDefaultScore(questions, exam, questionScore);
        model.addAttribute("msg", "Question Added Successfully");
        return "successAddedQuestion";
    }


    // Add Question To The Exam
    @RequestMapping(value = "/addQuestionToExam")
    private String addQuestionToTheExam(Model model, @RequestParam(value = "questionId") Long questionId, @RequestParam(value = "examId") Long examId) {
        Exam exam = examService.findByIdNotSecure(examId).get();
        Questions questions = questionsService.findByIdNotSecure(questionId).get();
        questions.getExams().add(exam);
        questionsService.saveNotSecure(questions);
        model.addAttribute("msg", "Question Added To Exam Successfully");
        return "successAddedQuestion";
    }

    @RequestMapping(value = "/editQuestion")
    private String editQuestion(Model model, @RequestParam(value = "questionId") Long questionId,
                                @RequestParam(value = "examId") Long examId) {
        model.addAttribute("questionId", questionId);
        model.addAttribute("examId", examId);
        return "editQuestion";
    }


    @RequestMapping(value = "/confirmEditQuestionDescriptive", method = RequestMethod.POST)
    private String confirmEditQuestionDescriptive(@ModelAttribute("questionScore") Number questionScore,
                                                  @ModelAttribute("examId") Long examId,
                                                  @ModelAttribute("questionId") Long questionId,
                                                  @ModelAttribute(value = "questionsDTO") QuestionsDTO questionsDTO, Model model) {


        questionsService.editQuestions(questionId, questionsDTO, questionScore.longValue(), examId, QuestionType.DESCRIPTIVE, null);
        model.addAttribute("msg", "Question Edited Successfully");
        return "successEditedQuestion";
    }

    @RequestMapping(value = "/confirmEditQuestionOptional")
    private String confirmEditQuestionOptional(
            @RequestParam("options") List<String> options,
            @ModelAttribute("questionScore") Number questionScore,
            @ModelAttribute("examId") Long examId,
            @ModelAttribute("questionId") Long questionId,
            @ModelAttribute(value = "questionsDTO") QuestionsDTO questionsDTO, Model model
    ) {

        questionsService.editQuestions(questionId, questionsDTO, questionScore.longValue(), examId, QuestionType.OPTIONAL, options);
        model.addAttribute("msg", "Question Edited Successfully");
        return "successEditedQuestion";
    }


}
