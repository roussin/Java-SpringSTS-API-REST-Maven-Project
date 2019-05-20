package io.christopheroussin.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.christopheroussin.topic.Topic;

/*
 * L'annotation @Entity 
 * nous indique que cette classe est une classe persistante. 
 * Elle peut prendre un attribut name, qui fixe le nom de cette entité. 
 * Par défaut, le nom d'une entité est le nom complet de sa classe. 
 * On peut fixer le nom d'une entité par une constante, 
 * en utilisant un import statique.
 */

@Entity
public class Course {

	// Les Attributs 
	
	@Id
	private String id;
	private String name;
	private String description;
	// Mise en relation de relation entre entités JPA bidirectionnel 
	// une Course est liée à un seul (One) Topic
	// Un Topic peut avoir plusieurs (Many) Course
	@ManyToOne
	private Topic topic;
	
	// ================================================================
	
	// Constructeur par défaut
	public Course() {}
	
	// Constructeur d'initialisation de la classe Course
	public Course(String id, String name, String description, String topicId) {
		
		// Le mot clef "super" appelle le constructeur de la class mère
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		// instanciation de la classe Topic
		this.topic = new Topic(topicId, "", "");
	}
	
	// ================================================================
	
	/* Les Getters & Setters 
	 * afficher et modifier les attributs en prenant compte 
	 * du principe d'encapsulation du model MVC
	 */
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
}
