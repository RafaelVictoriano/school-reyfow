package com.br.schoolreyfow.matter;


import com.br.schoolreyfow.matter.model.dto.MatterDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import java.util.List;

import static com.br.schoolreyfow.auth.user.Role.COORDINATOR;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/matter")
public class MatterController {

    private final MatterService matterService;

    @RolesAllowed(value = COORDINATOR)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody @Valid MatterDTO matterDTO) {
        this.matterService.create(matterDTO);
        log.info("matter created with success");
    }

    @GetMapping
    public ResponseEntity<List<MatterDTO>> getAll(Pageable pageable) {
        var mattersAll = this.matterService.findAll(pageable);
        log.info("matter get all with success");
        return ResponseEntity.ok(mattersAll);
    }


}
