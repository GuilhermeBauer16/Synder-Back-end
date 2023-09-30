package br.com.Synder.SynderBackend.domain.client;

public record ClientDetail(Long id, String name, String email, String password, String telephone) {

    public ClientDetail(Client client){
        this(client.getId(),  client.getName() , client.getEmail() , client.getPassword() , client.getTelephone());
    }
}
