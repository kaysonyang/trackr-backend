package de.techdev.trackr.domain.project;

import de.techdev.trackr.domain.AbstractDataOnDemand;
import de.techdev.trackr.domain.employee.EmployeeDataOnDemand;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;

/**
 * @author Moritz Schulze
 */
public class BillableTimeDataOnDemand extends AbstractDataOnDemand<BillableTime> {

    @Autowired
    private ProjectDataOnDemand projectDataOnDemand;

    @Autowired
    private EmployeeDataOnDemand employeeDataOnDemand;

    @Override
    public BillableTime getNewTransientObject(int i) {
        BillableTime billableTime = new BillableTime();
        billableTime.setEmployee(employeeDataOnDemand.getRandomObject());
        billableTime.setProject(projectDataOnDemand.getRandomObject());
        LocalDate localDate = LocalDate.now();
        LocalDate date = localDate.with(ChronoField.DAY_OF_YEAR, (i % 356) + 1);
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        billableTime.setDate(Date.from(instant));
        billableTime.setMinutes(i);
        return billableTime;
    }
}