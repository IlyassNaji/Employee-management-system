package com.ilyass.spring_react.service;

import java.util.List;

import com.ilyass.spring_react.dto.employeDto;

public interface employeService {
employeDto createEmploye(employeDto emp);
employeDto getEmployeeById(int id);
List<employeDto> getAllEmployees();
employeDto updateEmployee(int id,employeDto emp );
void deleteEmployee(int id);
}
