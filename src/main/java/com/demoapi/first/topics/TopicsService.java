package com.demoapi.first.topics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicsService {

	private List<TopicList> topics = new ArrayList<>(Arrays.asList(
			new TopicList( "1", "Topic 1", "Descritiotn of topi 1"),
			new TopicList("2", "Topic 2", "Description of topic 2"),
			new TopicList("3", "Topic 3", "Description of Topic 3")
			));
	
	public List<TopicList> getAllTopics()
	{
		return topics;
	}
	
	public TopicList getTopic(String id)
	{
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(TopicList topic)
	{
		topics.add(topic);
	}

	public void updateTopic(String id, TopicList topic) {
		for(int i=0; i< topics.size(); i++)
		{
			TopicList t = topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(x -> x.getId().equals(id));		
	}
}
