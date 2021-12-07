package ir.maktab.examination_online_system;

import ir.maktab.examination_online_system.models.*;
import ir.maktab.examination_online_system.models.embeddable.QuestionScore;
import ir.maktab.examination_online_system.models.enumeration.QuestionType;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import ir.maktab.examination_online_system.repositories.*;
import ir.maktab.examination_online_system.services.QuestionsService;
import ir.maktab.examination_online_system.services.dto.extra.QuestionDTOList;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
//@NoArgsConstructor
class ExaminationOnlineSystemApplicationTests {


    StudentRepository studentRepository;

    UserRepository userRepository;


    CourseRepository courseRepository;

    ExamRepository examRepository;

    QuestionBankRepository questionBankRepository;

    QuestionsRepository questionsRepository;

    QuestionsService questionsService;

    private long parsedSeconds = 0L;

    @Autowired
    public ExaminationOnlineSystemApplicationTests(
            StudentRepository studentRepository,
            UserRepository userRepository,
            CourseRepository courseRepository,
            ExamRepository examRepository,
            QuestionBankRepository questionBankRepository,
            QuestionsRepository questionsRepository,
            QuestionsService questionsService) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
        this.examRepository = examRepository;
        this.questionBankRepository = questionBankRepository;
        this.questionsRepository = questionsRepository;
        this.questionsService = questionsService;

    }
//    public ExaminationOnlineSystemApplicationTests() {
//
//    }

    @Test
    public void testCreateUser() {

        Student student = new Student();
        student.setConfirmed(false);
        student.setEmail("muhammadaliazarnosh25@gami.com");
        student.setFirstName("Muhammad");
        student.setLastName("Azarnoosh");
        student.setNationalCode("0372188915");
        student.setUserType(UserType.STUDENT);
        studentRepository.save(student);
    }

	@Test
	public void testReadUser() {
        Optional<User> student = userRepository.findById(14L);
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
        Student student = studentRepository.findById(14L).get();
        studentRepository.delete(student);
    }

    @Test
    public void testEditUser() {
        Student student = (Student) userRepository.findById(14L).get();
        student.setPassword("8585");
        studentRepository.save(student);
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
        Set<Questions> questions = questionsRepository.findAllByExamId(4L);
        System.out.println(questions.size());

    }

    @Test
    public void testGetQuestionsIsNull() {
        Questions questions = new Questions();
        Exam exam = examRepository.findById(4L).get();
        questions.getExams().add(exam);
        System.out.println("Ok");
    }

    @Test
    public void testFindExamsByIsForExam() {
        System.out.println(examRepository.findExamsByCourseId(1L).size());
    }


    // implement timer demo for online exam when student start the exam.,..
//    @Test
//    public static void main(String[] args) {
//
//        SwingUtilities.invokeLater(() -> new ExaminationOnlineSystemApplicationTests().buildGui());
//        Date date = new Date();
//        date.setTime(1L);
//        System.out.println(date);
//    }
//
//
//    private void buildGui() {
//        // Set up components
//        JFrame frame = new JFrame("Timer Demo");
//        JPanel inputPanel = new JPanel();
//        JLabel countDownLabel = new JLabel();
//        JLabel inputLabel = new JLabel("Countdown time in hours:");
//        JPanel outputPanel = new JPanel();
//        JButton startButton = new JButton("Start");
//        JTextField inputTextField = new JTextField(10);
//        inputPanel.add(inputLabel);
//        inputPanel.add(inputTextField);
//        outputPanel.add(startButton);
//        outputPanel.add(countDownLabel);
//        frame.add(inputPanel, BorderLayout.NORTH);
//        frame.add(outputPanel, BorderLayout.SOUTH);
//        countDownLabel.setText("hh:mm:ss");
//        frame.pack();
//        frame.setVisible(true);
//        // Set up timer and button
//        // swing timer that updates every second
//        Timer timer = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                parsedSeconds--;
//                if (parsedSeconds == 0) {
//                    ((Timer) e.getSource()).stop(); // stop the timer if 0
//                    // also do some stuff here
//                }
//                long hours = TimeUnit.SECONDS.toHours(parsedSeconds);
//                long minutes = TimeUnit.SECONDS.toMinutes(parsedSeconds) - (TimeUnit.SECONDS.toHours(parsedSeconds) * 60);
//                long seconds = TimeUnit.SECONDS.toSeconds(parsedSeconds) - (TimeUnit.SECONDS.toMinutes(parsedSeconds) * 60);
//                countDownLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
//            }
//        });
//        startButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Here, parse the input (hours) to use for the timer
//                String input = inputTextField.getText();
//                if (!input.isEmpty()) {
//                    int hours = Integer.parseInt(input); // possible exceptions in case of faulty input to be handled
//                    parsedSeconds = hours * 3600;
//                    timer.start();
//                } else { // show warning if input is empty
//                    JOptionPane.showMessageDialog(frame, "Please input valid hours", "Warning", JOptionPane.WARNING_MESSAGE);
//                }
//            }
//        });
//    }

    @Test
    public void testQuestionDTOList() {
        Set<Questions> questions = questionsRepository.findAllByExamId(4L);
        Set<QuestionDTOList> questionDTOLists = questionsService.getQuestionDTOList(questions);
        System.out.println(questionDTOLists.size());

    }

    @Test
    public void getQuestionWithQuestionIdAndExamId() {
        Questions questions = questionsRepository.findByQuestionsIdAndExamId(8L, 4L);
        System.out.println(questions.getQuestionScores().get(0));
    }


}
