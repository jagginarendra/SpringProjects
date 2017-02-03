package com.service.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;



@RestController

public class MyController {

	/*@Autowired
	private DiscoveryClient discoveryClient;*/
	
	/*@Autowired
	private LoadBalancerClient loadBalancerClient;
	*/
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping("/greetuser/{username}")
	public String greetUser(@PathVariable String username){
		
		// Doing manually with ribbon and taking 1st instance always
		//List<ServiceInstance> instances =   discoveryClient.getInstances("myGreetingService");
		/*URI uri = instances.get(0).getUri();
		
		System.out.println(uri);
		String message = new RestTemplate().getForObject(uri+"/greeting/"+username, String.class);
		
		System.out.println(message);
		*/
		
		// Doing with ribbon loadbalancer using loadbalancer client // it will not work if
		// one instance is dead so we should use the resttemplateobject directly with @loadbalancing
		
		//2 using the loadBalancer CLient
		/*ServiceInstance instance =  loadBalancerClient.choose("myGreetingService");
		
		URI uri = instance.getUri();
		
		System.out.println(uri);
		String message = new RestTemplate().getForObject(uri+"/greeting/"+username, String.class);
		
		System.out.println(message);
		*/
		
		// this will help in redirecting to other instances in case of any dead instance is queried
		
		String message = restTemplate.getForObject("http://myGreetingService/greeting/jaggi", String.class);
		
		System.out.println(message);
		
		return "hello";
	}
	
}
