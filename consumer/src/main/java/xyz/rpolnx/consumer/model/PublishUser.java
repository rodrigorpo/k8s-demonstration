package xyz.rpolnx.consumer.model;

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
    private Customer customer;
    private Long numberOfMessages;
}
