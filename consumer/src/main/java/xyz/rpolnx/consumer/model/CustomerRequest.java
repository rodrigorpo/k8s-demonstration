package xyz.rpolnx.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerRequest {
    private String name;
    private String cpf;
    private String email;
    private LocalDate birthday;
}
