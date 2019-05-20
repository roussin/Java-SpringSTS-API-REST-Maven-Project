package io.christopheroussin.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/*
 * https://docs.microsoft.com/en-us/previous-versions/msp-n-p/ff649690(v=pandp.10)
 * l'interface CoursesRepository etend CrudRepository qui a les méthodes CRUD pour la source
 * de données sous-jacente(save, findOne, findAll, etc.)
 * Cette interface correspond à la manipulation de l'objet Course par son topicId
 */

public interface CourseRepository extends CrudRepository<Course, String> {

	public List<Course> findByTopicId(String topicId );
}