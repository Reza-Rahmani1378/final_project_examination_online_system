package ir.maktab.examination_online_system;

import ir.maktab.examination_online_system.models.Student;
import ir.maktab.examination_online_system.models.User;
import ir.maktab.examination_online_system.models.enumeration.UserType;
import ir.maktab.examination_online_system.repository.StudentRepository;
import ir.maktab.examination_online_system.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
class ExaminationOnlineSystemApplicationTests {


	StudentRepository studentRepository;

	UserRepository userRepository;

	@Autowired
	public ExaminationOnlineSystemApplicationTests(StudentRepository studentRepository, UserRepository userRepository) {
		this.studentRepository = studentRepository;
		this.userRepository = userRepository;

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
		Student student = studentRepository.findById(2L).get();
		studentRepository.delete(student);
	}


}
