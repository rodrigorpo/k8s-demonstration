package xyz.rpolnx.consumer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerData implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private LocalDate birthday;
    private Long kafkaOrder;
}
