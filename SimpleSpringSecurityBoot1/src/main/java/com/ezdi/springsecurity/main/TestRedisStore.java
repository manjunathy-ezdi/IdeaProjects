package com.ezdi.springsecurity.main;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.MapSession;
import org.springframework.session.Session;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;

import redis.clients.jedis.JedisShardInfo;

import java.util.Map;
import java.util.Set;

/**
 * Created by EZDI\manjunath.y on 4/3/16.
 */
public class TestRedisStore {
	
	//static String id="d038cc6b-122a-4a2d-81b9-265921aeb157";
	//static String idFull="spring:session:sessions:d038cc6b-122a-4a2d-81b9-265921aeb157";
		//64cf35b2-baf8-459f-ae40-4815b1cc9e1f
		
	static String id="6ffa684e-908e-4ea1-a480-8c3c5e1b2066";
	static String idFull="spring:session:sessions:6ffa684e-908e-4ea1-a480-8c3c5e1b2066";
	public static void main(String[] args){
		test();
	}
	
	public static void displayMapSessionAttributes(MapSession mapSession){
		if(mapSession == null){
			System.out.println("displayMapSessionAttributes :: MapSession is null");
			return;
		}
		Set<String> atts = mapSession.getAttributeNames();
		for(String each: atts){
			System.out.println("displayMapSessionAttributes KEY: VALUE's CLASS ::"+each+" : "+mapSession.getAttribute(each).getClass().getName());
		}
	}
	
	public static void displayMapSession(MapSession mapSession){
		if(mapSession == null){
			System.out.println("displayMapSession:: MapSession is null");
			return;
		}
		System.out.println("displayMapSession:: MapSession Class Namae: "+mapSession.getClass().getName());
		System.out.println("displayMapSession:: ID: "+mapSession.getId());
		System.out.println("displayMapSession:: Last Accessed time: "+mapSession.getLastAccessedTime());
		System.out.println("displayMapSession:: Creation time: "+mapSession.getCreationTime());
		System.out.println("displayMapSession:: Max Inactive Interval: "+mapSession.getMaxInactiveIntervalInSeconds());
		displayMapSessionAttributes(mapSession);
	}
	
	public static Map<Object,Object> getSessionBoundHashOperationsEntries(){
		String key=idFull;
		RedisOperations<Object, Object> redisOperations = new RedisTemplate<Object,Object>();
		return null;
	}
	
	public static void test(){
		//Map<Object, Object> entries = getSessionBoundHashOperations(id).entries();
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		jedisConnectionFactory.setShardInfo(new JedisShardInfo("localhost", 6379));
		RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(jedisConnectionFactory);
		Session session = sessionRepository.getSession(id);
		System.out.println("SESSION CLASS: "+session.getClass().getName());
		Set<String> attrs = session.getAttributeNames();
		for(String each: attrs){
			System.out.print(each+"= ");
			if(session.getAttribute(each)!=null){
				System.out.print(session.getAttribute(each).getClass().getName()+" ||| "+session.getAttribute(each).toString());
			}
			else{
				System.out.print("NULL");
			}
			System.out.println();
		}
		
		/*
		 * OUTPUT::
		 * 16:19:45.898 [main] DEBUG o.s.d.r.core.RedisConnectionUtils - Opening RedisConnection
		 * 16:19:45.949 [main] DEBUG o.s.d.r.core.RedisConnectionUtils - Closing Redis Connection
		 * SESSION CLASS: org.springframework.session.data.redis.RedisOperationsSessionRepository$RedisSession
		 * SPRING_SECURITY_CONTEXT= org.springframework.security.core.context.SecurityContextImpl ||| org.springframework.security.core.context.SecurityContextImpl@fb707c63: Authentication: org.springframework.security.authentication.UsernamePasswordAuthenticationToken@fb707c63: Principal: org.springframework.security.core.userdetails.User@31dd0b: Username: john; Password: [PROTECTED]; Enabled: true; AccountNonExpired: true; credentialsNonExpired: true; AccountNonLocked: true; Granted Authorities: ROLE_ADMIN,ROLE_USER; Credentials: [PROTECTED]; Authenticated: true; Details: org.springframework.security.web.authentication.WebAuthenticationDetails@957e: RemoteIpAddress: 127.0.0.1; SessionId: null; Granted Authorities: ROLE_ADMIN, ROLE_USER
		 */
		
		
		/*
		Map<Object, Object> entries = getSessionBoundHashOperationsEntries();
		if(entries.isEmpty()) {
			System.out.println("Map named 'entries' is null");
			return;
		}
		MapSession loaded = loadSession(id, entries);
		if(loaded == null){
			System.out.println("MapSession is null");
			return;
		}
		if(loaded.isExpired()) {
			System.out.println("MapSession is expired");
			return;
		}
		displayMapSession(loaded);
		*/
		
	}
}
