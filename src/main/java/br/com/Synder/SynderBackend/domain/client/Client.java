package br.com.Synder.SynderBackend.domain.client;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@Table(name = "client")
@Entity(name = "client")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Client implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String telephone;




    public Client(RequestClientDTO requestClientDTO) {
        this.name = requestClientDTO.name();
        this.telephone = requestClientDTO.telephone();
        this.email = requestClientDTO.email();
        this.password = requestClientDTO.password();
    }


    public void clientUpdate(UpdateClientDTO updateClientDTO) {

        if (updateClientDTO.name() != null) {
            this.name = updateClientDTO.name();
        }
//        if(updateClientDTO.loginInfo().getEmail() != null)
//            this.loginInfo.email() = updateClientDTO.loginInfo().getEmail();
//
//        if(updateClientDTO.password() != null){
//            this.password = updateClientDTO.password();
//    }
        if (updateClientDTO.telephone() != null) {
            this.telephone = updateClientDTO.telephone();
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
