package com.purcell;

import com.purcell.domain.Address;
import com.purcell.domain.Person;
import com.purcell.repo.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataRedisCrudRepoApplicationTests {

	@Autowired
	private PersonRepository personRepo;

	@Test
	public void save() {
		Person person = new Person();
		person.setId("1");
		person.setFirstname("John");
		person.setLastname("Doe");
		person.setAddress(new Address("one", "two"));
		personRepo.save(person);

		Person xperson = new Person();
		xperson.setId("2");
		xperson.setFirstname("John2");
		xperson.setLastname("Doe2");
		xperson.setAddress(new Address("one2", "two2"));
		personRepo.save(xperson);

		Person xerson = new Person();
		xerson.setId("22");
		xerson.setFirstname("Johnxx");
		xerson.setLastname("Doexx");
		xerson.setAddress(new Address("onexx", "twoxx"));
		personRepo.save(xerson);


		Person retrievedPerson = personRepo.findOne("22");
		System.out.println("retrieve person = " + retrievedPerson.getLastname());


	}

}
