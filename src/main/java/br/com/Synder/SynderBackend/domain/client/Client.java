package br.com.Synder.SynderBackend.domain.client;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.*;


@Table(name ="client")
@Entity(name ="client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String telephone;


    public Client(RequestClientDTO requestClientDTO){
        this.name = requestClientDTO.name();
        this.email = requestClientDTO.email();
        this.password = requestClientDTO.password();
        this.telephone = requestClientDTO.telephone();
    }

    public void clientUpdate(UpdateClientDTO updateClientDTO) {

        if(updateClientDTO.name() != null){
            this.name = updateClientDTO.name();
        }
        if(updateClientDTO.email() != null){
            this.email = updateClientDTO.email();
        }
        if(updateClientDTO.password() != null){
            this.password = updateClientDTO.password();
        }
        if(updateClientDTO.telephone() != null){
            this.telephone = updateClientDTO.telephone();
        }
    }
}
