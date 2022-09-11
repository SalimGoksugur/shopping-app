package com.patika.shoppingapp.response;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RestErrorResponse {

	private Date errorDate;
    private String message;
    private List<String> errorList;
}
