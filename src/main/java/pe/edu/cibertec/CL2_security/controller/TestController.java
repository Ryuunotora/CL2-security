package pe.edu.cibertec.CL2_security.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {


    @PreAuthorize("hasRole('GESTOR')")
    @PostMapping("/post")
    public ResponseEntity<String> testPostApi(){
        return ResponseEntity.ok("Acceso autorizado a Gestor");
    }


    @PreAuthorize("hasRole('COORDINADOR')")
    @GetMapping("/get")
    public ResponseEntity<String> testGetApi(){
        return ResponseEntity.ok("Acceso autorizado a Coordinador");
    }


    @PreAuthorize("hasAnyRole('GESTOR', 'COORDINADOR')")
    @PutMapping("/put")
    public ResponseEntity<String> testPutApi(){
        return ResponseEntity.ok("Acceso autorizado a Gestor o Coordinador");
    }

}
