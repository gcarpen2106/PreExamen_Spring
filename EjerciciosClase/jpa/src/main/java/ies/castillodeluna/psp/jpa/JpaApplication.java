package ies.castillodeluna.psp.jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ies.castillodeluna.psp.jpa.entities.Person;
import ies.castillodeluna.psp.jpa.repositories.PersonRepository;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner{

	@Autowired PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//list();
		// findOne();
		// create();
		// update();
		delete();
		
	}

	public void list(){

		List<Person> people = (List<Person>) repository.findAll();

		people.stream().forEach(p -> System.out.println(p));

		repository.findByProgrammingLanguage("Java").forEach(System.out::println);

		List<Person> personPepe = repository.buscarPorProgramacionNombre("Java", "Jose");

		personPepe.stream().forEach(person -> System.out.println(person));

		List<Person> personPepe2 = repository.findByProgrammingLanguageAndName("Java", "Jose");

		personPepe2.stream().forEach(person -> System.out.println(person));

		List <Object []> personValues = repository.obtenerPersonData();

		personValues.stream().forEach(p -> {
			System.out.println(p[0] + " es experto en " + p[1]);
		});

		List <Object []> personValues2 = repository.obtenerPersonData("Java", "Jose");

		personValues2.stream().forEach(p -> {
			System.out.println(p[0] + " es experto en " + p[1]);
		});

	}

	public void findOne(){

		// Person person = repository.findById(1L).orElseThrow();
		// System.out.println(person);

		Person person = null;
		Optional<Person> optionalPerson = repository.findById(1L);

		if (optionalPerson.isPresent()) {
			person = optionalPerson.get();
		}

		System.out.println(person);

		// repository.findById(3L).ifPresent(person1 -> System.out.println(person1));
		repository.findById(3L).ifPresent(System.out::println);

		Optional<Person> one = repository.findOne(2L);

		System.out.println(one.get());

		//TODO findOneName

		repository.findOneLikeName("ose").ifPresent(System.out::println);

		repository.findOneByNameContaining("ose").ifPresent(System.out::println);

	}

	public void create(){

		// Scanner sc = new Scanner(System.in);
		// System.out.println("Por favor , Introduce el nombre");
		// String name = sc.next();
		// System.out.println("Por favor , Introduce el apellido");
		// String lastname = sc.next();
		// System.out.println("Por favor , Introduce el lenguaje de programacion");
		// String programmingLanguaje = sc.next();
		// sc.close();

		// Person p = new Person();
		// p.setName(name);
		// p.setLastname(lastname);
		// p.setProgrammingLanguage(programmingLanguaje);

		// repository.save(p);

		Person person = new Person(null, "Rosas", "Castillo", "Python");
		repository.save(person);

		repository.findById(person.getId()).ifPresent(p -> System.out.println(person));

	}

	public void update(){

		Scanner sc = new Scanner(System.in);

		System.out.println("Por favor, ingrese el id de la persona");
		Long id = sc.nextLong();

		Optional<Person> person = repository.findById(id);

		person.ifPresent(p ->{

			System.out.println("Introduzca el lenguaje de programacion");
			String programmingLanguage = sc.next();
			p.setProgrammingLanguage(programmingLanguage);
			System.out.println(p);
			repository.save(p);
			sc.close();

		});
		
	}

	public void delete(){

		repository.findAll().forEach(System.out::println);
		System.out.println("Introduce el id a borrar");
		Scanner sc = new Scanner(System.in);

		Long id = sc.nextLong();

		repository.deleteById(id);
		repository.findAll().forEach(System.out::println);

		sc.close();

	}

}
