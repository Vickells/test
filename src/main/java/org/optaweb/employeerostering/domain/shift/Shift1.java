package org.optaweb.employeerostering.domain.shift;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Shift1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
@JsonFormat(pattern="EEE, MMM dd,yyyy ,hh:mm:ss")
@NotNull
private Date startDateTime;
@NotNull
private Date endDateTime;
private String shiftName;
private Long consecutiveDays;
private Long OffDays;
private Integer tenantId;

public Shift1() {
	}
public Shift1(Date startDateTime, Date endDateTime,String shiftName,
		Long consecutiveDays,Long OffDays,Integer tenantId ) {
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.shiftName = shiftName;
		this.consecutiveDays=consecutiveDays;
		this.OffDays=OffDays;
		this.tenantId=tenantId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

	public String getShiftName() {
		return shiftName;
	}

	public void setShiftName(String shiftName) {
		this.shiftName = shiftName;
	}

	public Long getConsecutiveDays() {
		return consecutiveDays;
	}

	public void setConsecutiveDays(Long consecutiveDays) {
		this.consecutiveDays = consecutiveDays;
	}

	public Long getOffDays() {
		return OffDays;
	}

	public void setOffDays(Long OffDays) {
		this.OffDays = OffDays;
	}
	
	public Integer getTenantId() {
		return tenantId;
	}

	public void setTenantId(Integer tenantId) {
		this.tenantId = tenantId;
	}

	@Override
	public String toString() {
		return "Shift{" +
				"id=" + id +
				", startDateTime=" + startDateTime +
				", endDateTime='" + endDateTime + '\'' +
				", shiftName='" + shiftName + '\'' +
				", consecutiveDays=" + consecutiveDays +
				", OffDays='" + OffDays + '\'' +
				", tenantId=" + tenantId +
				'}';
	}
}
