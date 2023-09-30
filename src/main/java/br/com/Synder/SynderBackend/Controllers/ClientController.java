package br.com.Synder.SynderBackend.Controllers;


import br.com.Synder.SynderBackend.domain.client.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository repository;

    @Autowired
    // private ClientService clientService;
    @GetMapping
    public ResponseEntity getAllClients() {
        var allClients = repository.findAll();
        return ResponseEntity.ok(allClients);
    }

    @PostMapping
    @Transactional
    public ResponseEntity registerClient(@RequestBody @Valid RequestClientDTO data, UriComponentsBuilder uriBuilder) {
        Client newClient = new Client(data);
        repository.save(newClient);
        var uri = uriBuilder.path("/client/{id}").buildAndExpand(newClient.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClientDetail(newClient));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateClientDTO updateClientDTO) {

        var client = repository.getReferenceById(updateClientDTO.id());
        client.clientUpdate(updateClientDTO);
        return ResponseEntity.ok(new ClientDetail(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
