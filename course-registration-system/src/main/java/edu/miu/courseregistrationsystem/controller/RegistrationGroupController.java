package edu.miu.courseregistrationsystem.controller;

import edu.miu.courseregistrationsystem.dto.RegistrationEventDto;
import edu.miu.courseregistrationsystem.dto.RegistrationGroupDto;
import edu.miu.courseregistrationsystem.service.RegistrationGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/registration-groups")
public class RegistrationGroupController {
    @Autowired
    private RegistrationGroupService registrationGroupService;
    @PostMapping()
    public ResponseEntity<?> addRegistrationGroup(@RequestBody RegistrationGroupDto registrationGroupDto) {
        registrationGroupService.creatRegistrationGroup(registrationGroupDto);
        return new ResponseEntity<RegistrationEventDto>(HttpStatus.OK);
    }
    @PutMapping("/{registrationGroupId}")
    public ResponseEntity<?> updateRegistrationGroup(@PathVariable long registrationGroupId,
                                                     @RequestParam(value = "studentIds", required = false) List<Long> studentIds,
                                                     @RequestParam(value = "academicBlockId", required = false) Long academicBlockId) {
        registrationGroupService.updateRegistrationGroup(registrationGroupId, studentIds, academicBlockId);
        return new ResponseEntity<RegistrationEventDto>(HttpStatus.OK);
    }



}
