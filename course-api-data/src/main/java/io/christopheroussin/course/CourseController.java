package io.christopheroussin.course;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.christopheroussin.topic.Topic;

/*
 * Un contrôleur (Controller) 
 * contient la logique concernant les actions 
 * effectuées par l'utilisateur.
 */

/*
 * Au cœur de Spring Boot se trouvent les annotations qui servent à simplifier la tâche au développeur. 
 * Pour créer un contrôleur, il suffit de créer une classe et de l’annoter @RestController et de lui affected un point d’accès. 
 * Chacune des méthodes aura l’annotation @RequestMapping qui indique quel chemin de l’API la méthode couvre et quelle méthode HTTP lui correspond.
 * Ces annotations permettent à simplifier le code et à le rendre plus lisible. 
 * Le framework s’occupe de démarrer le serveur web et de rediriger les requêtes aux méthodes concernées.
 */

@RestController
public class CourseController {

	/*
	 * Le principe d’autowiring est un autre concept important dans Spring Boot. 
	 * Simplement en ajoutant l’annotation @Autowired au constructeur, 
	 * Spring s’occupera d’instancier la classe directement en injectant les dépendances décrites dans les paramètres du constructeur, 
	 * par exemple des services, repositories ou encore des objets de contexte. Pour chacun des objets injectés, il s’agira d’un c, 
	 * c’est-à-dire que chacune des classes qui ont le même service comme dépendance recevront la même instance du service.
	 */
	@Autowired
	private CourseService courseService;
	
	/**
	 * La méthode getAllCourses concerne la route /topics/{id}/courses (Read).
	 * @param id est de type String
	 * @return tous les courses d'un topic à l'id demandé
	 */
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	} 
	
	/**
	 * La méthode getCourse concerne la route /topics/{id}/courses/{id} (Read).
	 * @param id est de type String
	 * @return le contenu de courses à l'id demandé et d'un topics à l'id demandé
	 */
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	
	/**
	 * La méthode addCourse concerne la création (Create) d'un nouveau courses à l'id d'un topics demandé.
	 * @param course fait rérérence à l'objet Course
	 * @param topicId fait référence à l'id de l'objet Topic
	 * @return ne retourne aucune donnée
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	/**
	 * La méthode updateCourse concerne la modification (Update) d'un courses à l'id et à l'id d'un topics demandé.
	 * @param course fait rérérence à l'objet Course
	 * @param topicId fait référence à l'id de l'objet Topic
	 * @param id fait référence à l'id de l'objet Course
	 * @return ne retourne aucune donnée
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	/**
	 * La méthode deleteCourse concerne la modification (Update) d'un courses à l'id et à l'id d'un topics demandé.
	 * @param topicId fait référence à l'id de l'objet Topic
	 * @param id fait référence à l'id de l'objet Course
	 * @return ne retourne aucune donnée
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
}
