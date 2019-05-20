package io.christopheroussin.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * L'annotation @Entity 
 * nous indique que cette classe est une classe persistante. 
 * Elle peut prendre un attribut name, qui fixe le nom de cette entité. 
 * Par défaut, le nom d'une entité est le nom complet de sa classe. 
 * On peut fixer le nom d'une entité par une constante, 
 * en utilisant un import statique.
 */

@Entity
public class Topic {

	// Les Attributs
	
	@Id
	private String id;
	private String name;
	private String description;
	
	// ================================================================
	
	// Constructeur par défaut
	public Topic() {

	}
	
	// Constructeur d'initialisation de la classe Topic
	public Topic(String id, String name, String description) {
		
		// Le mot clef "super" appelle le constructeur de la class mère
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
}
