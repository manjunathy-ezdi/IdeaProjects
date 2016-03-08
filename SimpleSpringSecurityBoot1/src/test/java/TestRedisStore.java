import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.MapSession;
import org.springframework.session.Session;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;

import java.util.Map;
import java.util.Set;

/**
 * Created by EZDI\manjunath.y on 4/3/16.
 */
public class TestRedisStore {
	
	static String id="4485c2bb-debc-4d47-912e-7e130cdd33ef";
	static String idFull="spring:session:sessions:4485c2bb-debc-4d47-912e-7e130cdd33ef";
	
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
		RedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		RedisOperationsSessionRepository sessionRepository = new RedisOperationsSessionRepository(jedisConnectionFactory);
		Session session = sessionRepository.getSession(id);
		System.out.println("SESSION CLASS: "+session.getClass().getName());
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
