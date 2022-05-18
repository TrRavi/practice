package com.practice.bharatpay;

import java.util.HashMap;

public class Interview {

    // System.out.println(obj);
    // obj = {
    //     a: {
    //         b: {
    //             c: 12
    //         }
    //     }
    // };


    public static void main(String[] args) {
        int c = 12;
        HashMap b = new HashMap();
        b.put("c", c);

        HashMap a = new HashMap();
        a.put("b", b);

        HashMap obj = new HashMap();
        obj.put("a", a);

       /* System.out.println(findPath(obj, "a:b:c")); // 12
        System.out.println(findPath(obj, "a:b")); // {c: 12}
        System.out.println(findPath(obj, "a:b:d")); // null
        System.out.println(findPath(obj, "a:c")); // null*/
        System.out.println(findPath(obj, "a:b:c:d")); // null
        //System.out.println(findPath(obj, "a:b:c:d:e")); // null
    }

    private static Object  findPath(HashMap obj, String path) {
        //String mainValue = (String) obj.get("a");
        System.out.println("path  = "+path+ "  "+obj);
        if(path.length() == 1){
            System.out.println("last map "+obj);
            if(obj.containsKey(path)){
                return obj.get(path);
            }else {
                return null;
            }
        }

        String [] chunks = path.split(":");
        String chunk = chunks[0];
        System.out.println("chunk = "+chunk);
        if (obj.containsKey(chunk)){
            String newPath = path.replace(chunk+":","");
            if(obj.get(chunk) instanceof Integer ){
                return obj.get(chunk);
            }
            HashMap newMap = (HashMap) obj.get(chunk);
            System.out.println("new path => " +newPath+" "+"new map => "+newMap );
            return  findPath(newMap,newPath);
        }


        return null;
    }
}
