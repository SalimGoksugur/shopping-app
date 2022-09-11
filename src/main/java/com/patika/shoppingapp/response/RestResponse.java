package com.patika.shoppingapp.response;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RestResponse<T>  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private T data;
    private Date responseDate;
    private boolean isSuccess;

    public RestResponse(T data, boolean isSuccess) {
        this.data = data;
        this.isSuccess = isSuccess;
        responseDate = new Date();
    }

    public static <T> RestResponse<T> success(T t){
        return new RestResponse<>(t, true);
    }

    public static <T> RestResponse<T> error(T t){
        return new RestResponse<>(t, false);
    }

    public static RestResponse<Void> empty(){
        return new RestResponse<>(null, true);
    }

}
