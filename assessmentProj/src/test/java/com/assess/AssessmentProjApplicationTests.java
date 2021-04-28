package com.assess;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import com.assess.model.Department;
import com.assess.model.DepartmentDto;
import com.assess.model.Employee;
import com.assess.repository.DepartmentRepo;
import com.assess.repository.EmployeeRepo;
import com.assess.service.AssesmentService;

/**
 * @author Mark
 * Testing with mock repository. 
 */
@SpringBootTest
class AssessmentProjApplicationTests {

	@Autowired
	private AssesmentService service;
	
	@MockBean
	private DepartmentRepo drepo;
	
	@MockBean
	private EmployeeRepo erepo;
	
	private DepartmentDto ddto; 
	 
	
	
	@Test
	public void findAlltest() {
		when(drepo.getAllInfo()).thenReturn(getAllInfotest());
		assertEquals(6,service.getAllInfoIn().size());
	}

	@Test
	public void findAllEmpTest() {
		when(erepo.findAll()).thenReturn(getAllEmployees());
		assertEquals("programmer",service.findAllEmp().get(0).getProfession());
		assertEquals("darmoed",service.findAllEmp().get(1).getProfession());
	}
	
	@Test
	public void findAllDepTest() {
		when(drepo.findAll()).thenReturn(getAllDepartments());
		assertEquals("address one",service.findAllDep().get(0).getAddress());
		assertEquals("address two",service.findAllDep().get(1).getAddress());
	}
	
	@Test
	public void findDepByIdTest() {
		when(drepo.findById(2)).thenReturn(findRecord(2));
		assertNotEquals("address one",service.findById(2).get().getAddress());
		assertEquals("address two",service.findById(2).get().getAddress());
		
	}
	
	@Test
	public void saveAllAndDeleteTest() {
		List<Employee> le = new ArrayList<>();
	    le.add(new Employee()); 
		Department dep = new Department(1, "Construction","address two",le);
		Department dep1 = new Department(1, "Construction","address MMMMM",le);
		DepartmentDto dto = new DepartmentDto();
		dto.setDepartment(dep);
		when(drepo.save(dep)).thenReturn(dep);
		assertEquals(dep,service.saveToRep(dep));
		drepo.delete(dep);
		verify(drepo,times(1)).delete(dep);
		 
		
	}
	
	
	

	private Optional<Department> findRecord(int i) {
		List<Department> ld = new ArrayList<>();
		Department dep = new Department(1, "Construction","address two",new ArrayList<Employee>());
		Department dep1 = new Department(2, "Food","address two",new ArrayList<Employee>());
		ld.add(dep);
		ld.add(dep1);
		for (Department d:ld) {
			if(i==d.getDepId()) {
				return Optional.of(d);
			}
		}
		return Optional.of(new Department());
	}

	private List<Department> getAllDepartments() { 
		// TODO Auto-generated method stub
		List<Employee> le = new ArrayList<>();
	    le.add(new Employee()); 
		return Stream.of(new Department(1,"Astronomy","address one",le),
		         new Department(2, "Construction","address two",le)).collect(Collectors.toList());
	}

	private List<Employee> getAllEmployees() {
		
		return Stream.of(new Employee(1, "Mark","Fin", 45, "programmer", 50000),
				         new Employee(2, "John","Doe", 145, "darmoed", 150000)).collect(Collectors.toList());
	}

	private List<String> getAllInfotest() {
	     return  Stream.of("Construction,125 Grey Ave....,Tom,Soyer,30,carpetner,74444.0",
                    "Construction,125 Grey Ave....,Mark,Fin,63,programmer,78900.0",
                    "Construction,125 Grey Ave....,Grem,Green,23,carpetner,67000.0",
                    "Metalurgy,125 Grey Ave....,Jackil,Hide,30,mill operator,74444.0",
                    "Metalurgy,125 Grey Ave....,Mark,Fin,63,programmer,78900.0",
                    "Metalurgy,125 Grey Ave....,Grem,Green,23,carpetner,67000.0").collect(Collectors.toList());	
	}
	

}
