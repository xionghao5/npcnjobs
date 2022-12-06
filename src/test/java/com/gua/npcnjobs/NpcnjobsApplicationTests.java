package com.gua.npcnjobs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NpcnjobsApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("@RunWith是运行器,可以使用SpringRunner.class");
		System.out.println("@SpringBootTest是SpringBoot自带的测试框架");
		System.out.println("@RunWith和@SpringBootTest配置启动spring容器");
		System.out.println("@Test是最基本的测试");
	}

}
