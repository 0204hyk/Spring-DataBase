package factory_pattern_practice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import factory_pattern_practice.Apple;
import factory_pattern_practice.AppleConfig;
import factory_pattern_practice.AppleFactory;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppleFactoryTest {
	
	@Test
	public void getAppleTest() {
		AppleFactory appleFactory = new AppleFactory();
		
		AppleConfig config = new AppleConfig();
		
		config.setColor("빨간색");
		config.setPrice(800);
		
		appleFactory.setConfig(config);
		
		Apple apple = appleFactory.getApple();
		Apple apple2 = appleFactory.getApple();
		
		assertNotNull(apple);
		log.info(apple);
		log.info(apple2);
	}
	
}
