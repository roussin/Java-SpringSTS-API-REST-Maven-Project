package io.christopheroussin.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	/*
	 * Le principe d’autowiring est un autre concept important dans Spring Boot. 
	 * Simplement en ajoutant l’annotation @Autowired au constructeur, 
	 * Spring s’occupera d’instancier la classe directement en injectant les dépendances décrites dans les paramètres du constructeur, 
	 * par exemple des services, repositories ou encore des objets de contexte. Pour chacun des objets injectés, il s’agira d’un c, 
	 * c’est-à-dire que chacune des classes qui ont le même service comme dépendance recevront la même instance du service.
	 */
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>(); 
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Optional<Topic> getTopic(String id) {
		return topicRepository.findById(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}	
}
