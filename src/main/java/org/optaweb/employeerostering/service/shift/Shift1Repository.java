package org.optaweb.employeerostering.service.shift;

import org.springframework.data.repository.CrudRepository;
import org.optaweb.employeerostering.domain.shift.Shift1;
import org.optaweb.employeerostering.service.shift.Shift1Repository;

public interface Shift1Repository extends CrudRepository<Shift1,Long> {
	Shift1 findShiftById(Long id);
}