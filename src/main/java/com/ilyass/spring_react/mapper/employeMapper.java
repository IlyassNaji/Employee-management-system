package com.ilyass.spring_react.mapper;

import com.ilyass.spring_react.dto.employeDto;
import com.ilyass.spring_react.entity.employe;

public class employeMapper {
 public static employeDto mapToEmployeDto(employe emp ) {
	 return new employeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail());
 }
 public static employe mapToEmploye(employeDto emp ) {
	 return new employe(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail());
 }
}
