package com.example.Demoweb.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Demoweb.service.ex.InsertException;
import com.example.Demoweb.service.ex.PasswordNotMatchException;
import com.example.Demoweb.service.ex.ServiceException;
import com.example.Demoweb.service.ex.UserNotFoundException;
import com.example.Demoweb.service.ex.UsernameDuplicateException;
import com.example.Demoweb.util.JsonResult;

@RestControllerAdvice
public class GlobalHandleException {

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);

        if (e instanceof UsernameDuplicateException) {
            result.setState(4000);
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
        } else if (e instanceof InsertException) {
            result.setState(5000);
        }

        return result;
    }
}
