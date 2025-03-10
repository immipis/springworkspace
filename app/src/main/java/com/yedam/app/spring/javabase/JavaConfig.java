package com.yedam.app.spring.javabase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring 설정 =>spring 이 내부 자동으로 실행
public class JavaConfig {
	
	@Bean // 메서드를 실행한 결과를 Bean으로 등록
	public User user() {
		return new User();
	}
	
	@Bean("Card")   // 매개변수를 선언 -> ioc 컨테이너 안 bean 을 호출
	public NHCard nhCard(User user) {
		return new NHCard(user); // di 생성자 주입
	}
	
	
	@Bean("Card2")
	public KBCard kbCard(User user) {
		KBCard kbCard = new KBCard();
		kbCard.setOwner(user); // di 세터주입
		return kbCard;
	}
}
