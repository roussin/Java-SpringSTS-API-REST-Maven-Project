package io.christopheroussin.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	/*
	 * Le principe d’autowiring est un autre concept important dans Spring Boot. 
	 * Simplement en ajoutant l’annotation @Autowired au constructeur, 
	 * Spring s’occupera d’instancier la classe directement en injectant les dépendances décrites dans les paramètres du constructeur, 
	 * par exemple des services, repositories ou encore des objets de contexte. Pour chacun des objets injectés, il s’agira d’un c, 
	 * c’est-à-dire que chacune des classes qui ont le même service comme dépendance recevront la même instance du service.
	 */
	
	@Autowired
	private CourseRepository courseRepository;
	
	/**
	 * getAllCourses est une méthode qui permet d'acceder à toutes les données de l'objet Course par apport à l'id de l'objet Topic
	 * @param topicId
	 * @return courses
	 */
	public List<Course> getAllCourses(String topicId ){
		List<Course> courses = new ArrayList<>(); 
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	/**
	 * getCourse est une méthode qui permet de chercher un élément donné contenu dans l'instance de l'objet Course
	 * @param id
	 * @return resultat de la recherche
	 */
	public Optional<Course> getCourse(String id) {
		return courseRepository.findById(id);
	}

	/**
	 * addCourse est une méthode qui permet de créer un objet Course
	 * @param course
	 * @return void
	 */
	public void addCourse(Course course) {
		courseRepository.save(course);
	}
	
	/**
	 * updateCourse est une méthode qui permet de modifier l'instance de l'objet Course
	 * @param course
	 * @return void
	 */
	public void updateCourse(Course course) {
		courseRepository.save(course);
	}
	
	/**
	 * deleteCourse est une méthode qui permet de supprimer un élément par son id
	 * @param id
	 * @return void
	 */
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}	
}
