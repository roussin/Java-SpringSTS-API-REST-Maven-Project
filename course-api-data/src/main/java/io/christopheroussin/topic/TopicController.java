package io.christopheroussin.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class TopicController {

	/*
	 * Le principe d’autowiring est un autre concept important dans Spring Boot. 
	 * Simplement en ajoutant l’annotation @Autowired au constructeur, 
	 * Spring s’occupera d’instancier la classe directement en injectant les dépendances décrites dans les paramètres du constructeur, 
	 * par exemple des services, repositories ou encore des objets de contexte. Pour chacun des objets injectés, il s’agira d’un c, 
	 * c’est-à-dire que chacune des classes qui ont le même service comme dépendance recevront la même instance du service.
	 */
	@Autowired
	private TopicService topicService;
	
	/**
	 * La requête concerne la route /topics et lt l'ensemble des topics (Read). 
	 * On peut donc démarrer l’application et se diriger sur http://localhost:9080/topics pour recevoir l’objet Topic sous forme de json:
	 * @return les topic de l'id demandé
	 */
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	/**
	 * La méthode getTopic concerne la route /topics/{id}/courses (Read).
	 * @param id est de type String
	 * @return les topic de l'id demandé
	 */
	@RequestMapping("/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	/**
	 * La méthode concerne la création (Create) d'un nouveau topics au travers de la méthode POST. 
	 * @param topic fait rérérence à l'objet Topic
	 * @return ne retourne aucune donnée
	 */
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	/**
	 * La requête concerne la modification (Update) d'un topics existant au travers de la méthode PUT. 
	 * @param topic fait rérérence à l'objet Topic
	 * @param id fait référence à l'id de l'objet Topic
	 * @return ne retourne aucune donnée
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id,topic);
	}
	
	/**
	 * La requête concèrne la suppression (Delete) d'un topics existant au travers de la méthode DELETE. 
	 * @param topic fait rérérence à l'objet Topic
	 * @param id fait référence à l'id de l'objet Topic
	 * @return ne retourne aucune donnée
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}
	
}
