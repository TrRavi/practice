package com.practice;

import com.practice.mvc.entity.EmployeeEntity;
import com.practice.mvc.entity.RoleEntity;
import com.practice.mvc.repository.EmployeeRepository;
import com.practice.mvc.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;


@SpringBootApplication
@EnableCaching
@EnableScheduling
public class PracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	RoleRepository roleRepository;
	@Override
	//@Transactional
	public void run(String... args) throws Exception {
		/*RoleEntity role = new RoleEntity();
		role.setRoleName("ADMIN");
		role.setRoleId(1L);
		roleRepository.save(role);
		for(int i =0;i<=50;i++){
			EmployeeEntity emp = new EmployeeEntity();
			emp.setName("Ravi");
			emp.setAge(i);
			emp.setRole(role);
			employeeRepository.save(emp);
		}*/

		EmployeeEntity emp = employeeRepository.findById(2L).get();
		emp.setName("Ravitttttqsqqcqcqcqctt");
		emp.getRole().setRoleName("ADMIN wcewcwcwcw");
		employeeRepository.save(emp);



	}

	public static void printName(List<EmployeeEntity> employeeEntityList){
		employeeEntityList.forEach(employeeEntity -> System.out.println(employeeEntity.getName()+" age"+employeeEntity.getAge()));
	}
}
