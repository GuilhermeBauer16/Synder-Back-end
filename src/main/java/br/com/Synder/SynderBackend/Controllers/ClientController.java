package br.com.Synder.SynderBackend.Controllers;



import br.com.Synder.SynderBackend.domain.client.Client;
import br.com.Synder.SynderBackend.domain.client.ClientRepository;
import br.com.Synder.SynderBackend.domain.client.RequestClientDTO;
import br.com.Synder.SynderBackend.domain.client.UpdateClientDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository repository;
    @Autowired
   // private ClientService clientService;
   @GetMapping
    public ResponseEntity getAllClients(){
       var allClients = repository.findAll();
       return ResponseEntity.ok(allClients);
   }

   @PostMapping
   @Transactional
    public ResponseEntity registerClient(@RequestBody @Valid RequestClientDTO data){
        Client newClient = new Client(data);
        repository.save(newClient);
        return ResponseEntity.ok().build();
   }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateClientDTO updateClientDTO) {

        var client = repository.getReferenceById(updateClientDTO.id());
        client.clientUpdate(updateClientDTO);
        return ResponseEntity.ok().build();
    }

   @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
       repository.deleteById(id);
       return ResponseEntity.noContent().build();
   }
}
