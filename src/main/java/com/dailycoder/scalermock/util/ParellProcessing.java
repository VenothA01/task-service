package com.dailycoder.scalermock.util;

import com.dailycoder.scalermock.CustomAnnotation;
import com.dailycoder.scalermock.vo.Test;
import lombok.SneakyThrows;

import java.util.stream.IntStream;


public abstract class ParellProcessing{

    public abstract void processInParalell();
}

class UnitTester{

    @Test(test = "method1")
    public void method1(){
        System.out.println("method1");
    }
    public void method2(){
        System.out.println("method 2");
    }
    @Test(test = "method3")
    public void method3(){
        System.out.println("method 3");
    }

}

@CustomAnnotation
class ParellProcessingImpl extends ParellProcessing {

    @Override
    public void processInParalell() {
        System.out.println("In cbild ");
    }

    @SneakyThrows
    public static void main(String[] args) {

        ParellProcessingImpl parellProcessing = new ParellProcessingImpl();
        if(parellProcessing.getClass().isAnnotationPresent(CustomAnnotation.class)){
            System.out.println("yes it is annotated");
        }

        UnitTester tester = new UnitTester();
        for(var method: tester.getClass().getMethods()){
            if(method.isAnnotationPresent(Test.class)){
                var annotation = method.getAnnotation(Test.class);
                System.out.println("test::"+annotation.test());
                method.invoke(tester);
            }
        }
    }
}
