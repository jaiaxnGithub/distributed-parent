package com.jaiaxn.distributed.web.aop;

import com.jaiaxn.distributed.web.expection.ParamInvalidException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author: wang.jiaxin
 * @date: 2019年04月01日
 * @description: 参数校验
 **/
@Aspect
@Component
public class ParamValidAop {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    @Before("execution(* com.jaiaxn.distributed.web.controller..*.*(..))")
    public void doBefore(JoinPoint point) throws ParamInvalidException {
        Object[] params = point.getArgs();

        //校验参数是否合法
        List<String> errors = this.validate(params);
        if (errors != null && !errors.isEmpty()) {
            throw new ParamInvalidException(errors);
        }
    }

    /**
     * 校验参数
     * @param params
     * @return
     */
    private List<String> validate(Object[] params) {
        if (params==null || params.length==0) {
            return null;
        }
        List<String> errors = new ArrayList<String>();
        for (Object obj : params) {

            if (obj == null) {
                continue;
            }
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(obj);
            for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
                errors.add(constraintViolation.getMessage());
            }
        }
        return errors;
    }
}
