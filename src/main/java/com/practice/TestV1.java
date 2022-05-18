package com.practice;

import java.util.Map;

public class TestV1 {


    private static Integer  fun(){
       Integer num =  execute(()-> divNum(0));

        return num;
    }

    private static <T> T execute(ThrowingSupplier<T> payload){
        T t = null;
        try{
            Map<String,String> response = (Map<String, String>) payload.get();
           return (T) response;

        }catch (NullPointerException e){
            System.out.println("exception taken care"+e.getMessage());
            //System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("exception taken care"+e.getMessage());
        }
        return t;
    }

    private static Integer divNum(int num) throws Exception {
        try {
            return   num = 10/num;
        }catch (Exception e){
             throw new Exception(e);
        }
    }


}

@FunctionalInterface
 interface ThrowingSupplier<T> {
    T get() throws Exception;
}
