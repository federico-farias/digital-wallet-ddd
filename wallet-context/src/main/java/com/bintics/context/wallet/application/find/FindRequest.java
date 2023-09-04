package com.bintics.context.wallet.application.find;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
// TODO: Definir criterios de búsqueda.
public class FindRequest {

    private String walletId;

}
