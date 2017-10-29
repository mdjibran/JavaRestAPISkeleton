package com.demoapi.first.topics;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicsController {

	@Autowired
	private TopicsService topicsServices;
	
	@RequestMapping("/topics")
	public List<TopicList> getAllTopics()
	{
		return topicsServices.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	public TopicList getTopic(@PathVariable String id)
	{
		return topicsServices.getTopic(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody TopicList topic)	{
		topicsServices.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="topics/{id}")
	public void updateTopic(@RequestBody TopicList topic, @PathVariable String id) {
		topicsServices.updateTopic(id, topic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="topics/{id}")
	public void deleteTopic(@RequestBody TopicList topic, @PathVariable String id)
	{
		topicsServices.deleteTopic(id);
	}
}