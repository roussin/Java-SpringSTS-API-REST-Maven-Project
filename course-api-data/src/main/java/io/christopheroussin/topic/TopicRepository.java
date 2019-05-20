package io.christopheroussin.topic;

import org.springframework.data.repository.CrudRepository;

/*
 * https://docs.microsoft.com/en-us/previous-versions/msp-n-p/ff649690(v=pandp.10)
 * l'interface CoursesRepository etend CrudRepository qui a les méthodes CRUD pour la source
 * de données sous-jacente(save, findOne, findAll, etc.)
 */

public interface TopicRepository extends CrudRepository<Topic, String> {

}