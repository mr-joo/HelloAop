package com.oraclejava.drawing.aop;

import com.oraclejava.drawing.model.Circle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloAspect {
    //메서드 시작할 때 weaving하는 Advice
    @Before("execution(* getName())")
    public void before(JoinPoint jp) {
        System.out.println("Before");
        Signature sig = jp.getSignature();
        System.out.println("methodName : " + sig.getName());
        Object[] o = jp.getArgs();
        System.out.println("parameterCount : " + o.length);
    }

    //메서드 종료할 때 weaving하는 Advice
    @After("execution(* getName())")
    public void after() {
        System.out.println("After");
    }

    //메서드 호출이 예외가 발생되지 않은채 종료되었을 때
    @AfterReturning(value = "execution(* getName())", returning = "retStr")
    public void afterReturning(JoinPoint jp, String retStr) {
        System.out.println("Return");
        System.out.println("Return Value : " + retStr);
    }

    //메서드 호출 전후로 weaving하는 Advice
    @Around("execution(* getName())")
    public String around(ProceedingJoinPoint pjp) throws Throwable {
            System.out.println("around before");

            if (pjp.getThis() instanceof Circle) {
                Circle circle = (Circle)pjp.getThis();
                System.out.println("변경 전 : " + circle);
                circle.setCheck(true);
            }

            String str = (String)pjp.proceed();

            System.out.println("aroud after");
            return str;

    }

    //메서드 호출이 예외가 발생했을 때 호출되는 Adivice
    @AfterThrowing(value = "execution(* getName())", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("afterTrowing");
        System.out.println("exception value : " + ex);
    }
}
