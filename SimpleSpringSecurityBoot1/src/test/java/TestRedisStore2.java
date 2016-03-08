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



/*
 * Got this exception for this code::
 * 
 * /usr/local/jdk1.7.0_60/bin/java -Didea.launcher.port=7532 -Didea.launcher.bin.path=/home/local/EZDI/manjunath.y/Desktop/idea-IU-135.1230/bin -Dfile.encoding=UTF-8 -classpath /usr/local/jdk1.7.0_60/jre/lib/jsse.jar:/usr/local/jdk1.7.0_60/jre/lib/rt.jar:/usr/local/jdk1.7.0_60/jre/lib/jfr.jar:/usr/local/jdk1.7.0_60/jre/lib/javaws.jar:/usr/local/jdk1.7.0_60/jre/lib/jfxrt.jar:/usr/local/jdk1.7.0_60/jre/lib/resources.jar:/usr/local/jdk1.7.0_60/jre/lib/management-agent.jar:/usr/local/jdk1.7.0_60/jre/lib/charsets.jar:/usr/local/jdk1.7.0_60/jre/lib/jce.jar:/usr/local/jdk1.7.0_60/jre/lib/deploy.jar:/usr/local/jdk1.7.0_60/jre/lib/plugin.jar:/usr/local/jdk1.7.0_60/jre/lib/ext/dnsns.jar:/usr/local/jdk1.7.0_60/jre/lib/ext/sunec.jar:/usr/local/jdk1.7.0_60/jre/lib/ext/sunjce_provider.jar:/usr/local/jdk1.7.0_60/jre/lib/ext/sunpkcs11.jar:/usr/local/jdk1.7.0_60/jre/lib/ext/zipfs.jar:/usr/local/jdk1.7.0_60/jre/lib/ext/localedata.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/target/test-classes:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/target/classes:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-webmvc-portlet-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-websocket-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-web-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-webmvc-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-aspects-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-acl-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-cas-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-crypto-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-core-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-remoting-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-openid-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-config-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-ldap-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-taglibs-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-security-web-3.2.5.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/hibernate-jpa-2.0-api-1.0.1.Final.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/hibernate-commons-annotations-4.0.2.Final.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/javassist-3.15.0-GA.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/dom4j-1.6.1.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/jboss-logging-3.1.0.GA.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/antlr-2.7.7.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/jboss-transaction-api_1.1_spec-1.0.1.Final.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/hibernate-core-4.2.2.Final.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-aspects-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-aop-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-context-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-context-support-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-instrument-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-expression-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-core-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-beans-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-instrument-tomcat-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-jms-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-jdbc-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-oxm-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-tx-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/commons-logging-1.1.3.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-messaging-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-test-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/aopalliance-1.0.jar:/home/local/EZDI/manjunath.y/IdeaProjects/SimpleSpringSecurityBoot1/lib/spring-orm-4.2.4.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/apache/commons/commons-dbcp2/2.1.1/commons-dbcp2-2.1.1.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/apache/commons/commons-pool2/2.4.2/commons-pool2-2.4.2.jar:/home/local/EZDI/manjunath.y/.m2/repository/commons-logging/commons-logging/1.2/commons-logging-1.2.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/boot/spring-boot/1.3.2.RELEASE/spring-boot-1.3.2.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/1.3.1.RELEASE/spring-boot-autoconfigure-1.3.1.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/javax/servlet/javax.servlet-api/3.0.1/javax.servlet-api-3.0.1.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/data/spring-data-redis/1.6.2.RELEASE/spring-data-redis-1.6.2.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/spring-context/4.1.9.RELEASE/spring-context-4.1.9.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/spring-aop/4.1.9.RELEASE/spring-aop-4.1.9.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/aopalliance/aopalliance/1.0/aopalliance-1.0.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/spring-beans/4.1.9.RELEASE/spring-beans-4.1.9.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/spring-core/4.1.9.RELEASE/spring-core-4.1.9.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/spring-expression/4.1.9.RELEASE/spring-expression-4.1.9.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/spring-tx/4.1.9.RELEASE/spring-tx-4.1.9.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/spring-context-support/4.1.9.RELEASE/spring-context-support-4.1.9.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/slf4j/slf4j-api/1.7.12/slf4j-api-1.7.12.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/springframework/session/spring-session/1.0.2.RELEASE/spring-session-1.0.2.RELEASE.jar:/home/local/EZDI/manjunath.y/.m2/repository/redis/clients/jedis/2.8.0/jedis-2.8.0.jar:/home/local/EZDI/manjunath.y/.m2/repository/org/apache/commons/commons-pool2/2.3/commons-pool2-2.3.jar:/home/local/EZDI/manjunath.y/Desktop/idea-IU-135.1230/lib/idea_rt.jar com.intellij.rt.execution.application.AppMain TestRedisStore
Exception in thread "main" org.springframework.data.redis.RedisConnectionFailureException: Cannot get Jedis connection; nested exception is java.lang.NullPointerException
	at org.springframework.data.redis.connection.jedis.JedisConnectionFactory.fetchJedisConnector(JedisConnectionFactory.java:162)
	at org.springframework.data.redis.connection.jedis.JedisConnectionFactory.getConnection(JedisConnectionFactory.java:251)
	at org.springframework.data.redis.connection.jedis.JedisConnectionFactory.getConnection(JedisConnectionFactory.java:58)
	at org.springframework.data.redis.core.RedisConnectionUtils.doGetConnection(RedisConnectionUtils.java:128)
	at org.springframework.data.redis.core.RedisConnectionUtils.getConnection(RedisConnectionUtils.java:91)
	at org.springframework.data.redis.core.RedisConnectionUtils.getConnection(RedisConnectionUtils.java:78)
	at org.springframework.data.redis.core.RedisTemplate.execute(RedisTemplate.java:178)
	at org.springframework.data.redis.core.RedisTemplate.execute(RedisTemplate.java:153)
	at org.springframework.data.redis.core.AbstractOperations.execute(AbstractOperations.java:86)
	at org.springframework.data.redis.core.DefaultHashOperations.entries(DefaultHashOperations.java:220)
	at org.springframework.data.redis.core.DefaultBoundHashOperations.entries(DefaultBoundHashOperations.java:101)
	at org.springframework.session.data.redis.RedisOperationsSessionRepository.getSession(RedisOperationsSessionRepository.java:233)
	at org.springframework.session.data.redis.RedisOperationsSessionRepository.getSession(RedisOperationsSessionRepository.java:220)
	at TestRedisStore.test(TestRedisStore.java:58)
	at TestRedisStore.main(TestRedisStore.java:21)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)
Caused by: java.lang.NullPointerException
	at redis.clients.jedis.BinaryJedis.<init>(BinaryJedis.java:57)
	at redis.clients.jedis.Jedis.<init>(Jedis.java:42)
	at org.springframework.data.redis.connection.jedis.JedisConnectionFactory.fetchJedisConnector(JedisConnectionFactory.java:157)
	... 19 more

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
