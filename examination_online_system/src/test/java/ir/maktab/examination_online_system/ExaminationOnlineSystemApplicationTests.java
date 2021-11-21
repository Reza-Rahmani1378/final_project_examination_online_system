package ir.maktab.examination_online_system;

import ir.maktab.examination_online_system.models.*;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import ir.maktab.examination_online_system.repositories.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;
import java.sql.Time;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
class ExaminationOnlineSystemApplicationTests {


    StudentRepository studentRepository;

    UserRepository userRepository;


    CourseRepository courseRepository;

    ExamRepository examRepository;

    QuestionBankRepository questionBankRepository;

    QuestionsRepository questionsRepository;

    @Autowired
    public ExaminationOnlineSystemApplicationTests(
            StudentRepository studentRepository,
            UserRepository userRepository,
            CourseRepository courseRepository,
            ExamRepository examRepository,
            QuestionBankRepository questionBankRepository,
            QuestionsRepository questionsRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.examRepository = examRepository;
        this.questionBankRepository = questionBankRepository;
        this.questionsRepository = questionsRepository;

    }

	@Test
	public void testCreateUser() {

		Student student = new Student();
		student.setConfirmed(false);
		student.setEmail("A@gmail.com");
		student.setFirstName("Ali");
		student.setLastName("Noori");
		student.setNationalCode("0371943247");
		student.setUserType(UserType.STUDENT);
		studentRepository.save(student);
	}

	@Test
	public void testReadUser() {
		Optional<User> student = userRepository.findById(1L);
		System.out.println(student);
	}

	@Test
	public void testUpdateUser() {
		Student student = studentRepository.findById(1L).get();
        student.setConfirmed(true);
        studentRepository.save(student);
    }

    @Test
    public void testDeleteUser() {
        Student student = studentRepository.findById(1L).get();
        studentRepository.delete(student);
    }

    @Test
    public void testFindAll() {
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void testFindCoursesWithProfessorId() {
        courseRepository.findCoursesByProfessorId(8L);
    }


    @Test
    public void testSaveExam() {
        Course course = courseRepository.findById(7L).get();
        Exam exam = new Exam();
        exam.setCourse(course);
        exam.setTimeExam(120);
        exam.setDescription("Are");
        exam.setTitle("Java");
        examRepository.save(exam);
    }


    // Test add QuestionBank to The Course When Admin Added Professor To The Course
    @Test
    public void testAddToBankQuestionToTheCourse() {
        List<Exam> exams = examRepository.getExamsByCourseId(1L);
        QuestionBank questionBank = questionBankRepository.findById(1L).get();
        Questions questions = new Questions();
        questions.setQuestionType(QuestionType.DESCRIPTIVE);
        questions.setQuestionTitle("JAVA AND SPRING");
//		Set<QuestionDescriptive> questionDescriptives = new HashSet<>();
//		QuestionDescriptive questionDescriptive = new QuestionDescriptive();
//		questionDescriptive.setQuestionDescriptive("Why we use dependency injection in spring and java");
//		questionDescriptives.add(questionDescriptive);
//		questions.setQuestionDescriptives(questionDescriptives);
        List<QuestionScore<Long>> questionScores = new ArrayList<>();
        QuestionScore<Long> questionScore = new QuestionScore<>();
        questionScore.setQuestionScore(23L);
        questionScores.add(
                questionScore
        );
        QuestionScore<Long> questionScore1 = new QuestionScore<>();
        questionScore1.setQuestionScore(50L);
        questionScores.add(questionScore1
        );
//		questions.setQuestionScores(questionScores);
//		questions.setExams(exams);
        questions.setQuestionBank(questionBank);
        questionsRepository.save(questions);


    }

    // find All Questions By exam
    @Test
    public void findAllQuestionsByExamId() {
        List<Questions> questions = questionsRepository.findAllByExamId(4L);
        System.out.println(questions.size());

    }

    @Test
    public void testGetQuestionsIsNull() {
        Questions questions = new Questions();
        Exam exam = examRepository.findById(4L).get();
        questions.getExams().add(exam);
        System.out.println("Ok");
    }


}
