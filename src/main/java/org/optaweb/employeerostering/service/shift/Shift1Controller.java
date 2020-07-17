package org.optaweb.employeerostering.service.shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import org.optaweb.employeerostering.domain.shift.Shift1;


@RestController
public class Shift1Controller {
@Autowired
Shift1Repository shiftRepo;



@GetMapping("/api/shift/{id}")
public ResponseEntity<Shift1> getShift(@PathVariable("id") Long id) {
if (!shiftRepo.existsById(id)) {
return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
}
return new ResponseEntity<>(shiftRepo.findShiftById(id), HttpStatus.OK);
}


@GetMapping("/api/shift/create")
public ResponseEntity<Shift1> createShift(
		@RequestParam(required = false, defaultValue = "today") Date startDateTime,
		@RequestParam(required = false, defaultValue = "today") Date endDateTime,
		@RequestParam(defaultValue = "shiftName") String shiftName,
		@RequestParam("consecutiveDays") Long consecutiveDays,
		@RequestParam("OffDays") Long OffDays,
		@RequestParam("tenantId") int tenantId
			
			
	)
	{
		return new ResponseEntity<>(shiftRepo.save(new Shift1(startDateTime, endDateTime,shiftName,consecutiveDays,OffDays,tenantId)), HttpStatus.OK);
	}


	@GetMapping("/api/shift/delete/{id}")
	public ResponseEntity<String> deleteShift(@PathVariable("id") Long shift_Id) {
		if (!shiftRepo.existsById(shift_Id)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		Shift1 shift = shiftRepo.findShiftById(shift_Id);

		// Delete Comments related to the post before deleting the post
	

		shiftRepo.delete(shift);

		return new ResponseEntity<>("Deleted shift with id: " + shift_Id, HttpStatus.OK);
	}


	@GetMapping("/api/shift/update/{id}")
	public ResponseEntity<Shift1> updateShift(@PathVariable("id") Long id,
			@RequestParam(required = false, defaultValue = "today") Date startDateTime,
			@RequestParam(required = false, defaultValue = "today") Date endDateTime,
			@RequestParam(defaultValue = "shiftName") String shiftName,
			@RequestParam("consecutiveDays") Long consecutiveDays,
			@RequestParam("OffDays") Long OffDays,
			@RequestParam("tenantId") int tenantId)
	{
		if (!shiftRepo.existsById(id)) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		Shift1 shift = shiftRepo.findShiftById(id);
		shift.setStartDateTime(startDateTime);
		shift.setEndDateTime(endDateTime);
		shift.setShiftName(shiftName);
		shift.setConsecutiveDays(consecutiveDays);
		shift.setOffDays(OffDays);
		shift.setTenantId(tenantId);

		return new ResponseEntity<>(shiftRepo.save(shift), HttpStatus.OK);
	}
}

