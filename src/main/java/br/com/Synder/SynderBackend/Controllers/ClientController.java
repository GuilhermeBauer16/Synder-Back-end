package br.com.Synder.SynderBackend.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
   @GetMapping
    public ResponseEntity getAllClients(){
       return ResponseEntity.ok("tudo ok");
   }
}
