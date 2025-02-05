package com.jooq.coversionIssue;

import com.jooq.coversionIssue.jooq.JooqTest;
import com.jooq.coversionIssue.jooq.JooqUtil;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoversionIssueApplication {

	@Autowired JooqUtil jooqUtil;
	public static void main(String[] args) {
		val sc=SpringApplication.run(CoversionIssueApplication.class, args);
		sc.getBean(JooqTest.class).run();
	}
}
