package com.example.restfulapi.responses;

import com.example.restfulapi.api.MainInterface;
import com.example.restfulapi.api.RestClient;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

// untuk parsing error
public class ErrorUtils {

    public static ErrorResponse parseError(Response<?> response){
        Converter<ResponseBody, ErrorResponse> converter =
                RestClient.retrofit().responseBodyConverter(ErrorResponse.class, new Annotation[0]);

        ErrorResponse error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new ErrorResponse();
        }

        return error;
    }
}
