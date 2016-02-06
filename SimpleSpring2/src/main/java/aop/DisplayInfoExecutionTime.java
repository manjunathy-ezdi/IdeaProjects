package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */
@Aspect
public class DisplayInfoExecutionTime {
    @Pointcut("execution(* *.displayInfo*())")
    public void methodToInvokeForDisplayInfo(){ } //pointcut name

    private long start=0;
    private long end = 0;


    @Around("methodToInvokeForDisplayInfo()")
    public Object aroundDisplayInfo(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        start = System.currentTimeMillis();
        System.out.println("AOP :: Starting method "+proceedingJoinPoint.getSignature()+" ;; start: "+start);
        Object o = proceedingJoinPoint.proceed();
        end = System.currentTimeMillis();
        System.out.println("AOP :: Ending method "+proceedingJoinPoint.getSignature()+" ;; end: "+end+" ;; Total Time: "+(end-start));
        return o;
    }
/*
    @Before("methodToInvokeForDisplayInfo()")
    public void beforeDisplayInfo(JoinPoint joinPoint){
        start = System.currentTimeMillis();
        System.out.println("AOP :: Starting method "+joinPoint.getSignature()+" ;; start: "+start);
    }

    @After("methodToInvokeForDisplayInfo()")
    public void afterDisplayInfo(JoinPoint joinPoint){
        end = System.currentTimeMillis();
        System.out.println("AOP :: Starting method "+joinPoint.getSignature()+" ;; end: "+end+" ;; Total Time: "+(end-start));
    }
*/
    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
