package xyz.rpolnx.producer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublishUser implements Serializable {
    private CustomerData customer;
    private Long numberOfMessages;
}
