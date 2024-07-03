package com.ilyass.spring_react.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.ilyass.spring_react.dto.employeDto;
import com.ilyass.spring_react.entity.employe;
import com.ilyass.spring_react.exception.ResourceNotFound;
import com.ilyass.spring_react.mapper.employeMapper;
import com.ilyass.spring_react.repository.repository;

@Service
public class employeServiceImpl implements employeService {
    private repository empRepository;

    public employeServiceImpl(repository empRepository) {
        super();
        this.empRepository = empRepository;
    }

    @Override
    public employeDto createEmploye(employeDto emp) {
        employe employee = employeMapper.mapToEmploye(emp);
        employe savedEmployee = empRepository.save(employee);
        return employeMapper.mapToEmployeDto(savedEmployee);
    }

    @Override
    public employeDto getEmployeeById(int id) {
        employe emp = empRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee", "Id", id));
        return employeMapper.mapToEmployeDto(emp);
    }

    @Override
    public List<employeDto> getAllEmployees() {
        List<employe> emp = empRepository.findAll();
        return emp.stream()
                  .map(employe -> employeMapper.mapToEmployeDto(employe))
                  .collect(Collectors.toList());
    }

	@Override
	public employeDto updateEmployee(int id, employeDto emp) {
		 employe employee = empRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee", "Id", id));
		 employee.setFirstName(emp.getFirstName());
		 employee.setLastName(emp.getLastName());
		 employee.setEmail(emp.getEmail());
		 employe savedEmployee= empRepository.save(employee);
		 return employeMapper.mapToEmployeDto(savedEmployee);
	}

	@Override
	public void deleteEmployee(int id) {
		  empRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Employee", "Id", id));
         empRepository.deleteById(id);
	}
}
