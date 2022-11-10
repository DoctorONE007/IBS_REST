package com.ibs.service.rest.v2;

import com.ibs.service.business.BossService;
import com.ibs.service.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/v2/boss")
public class BossController {

    @Autowired
    private BossService bossService;

    @GetMapping("/{id}")
    Iterable<Optional<Employee>> getById(@PathVariable Long id) {
        return bossService.findAllByBossId(id);
    }

    @GetMapping("/employee/{id}")
    Employee getBossById(@PathVariable Long id) {
        return bossService.getBossById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Boss not found"));
    }
}
