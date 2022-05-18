package com.practice.hackerrank.rest;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class GetName {
    public static void main(String[] args) {
        try{
            List<LinkedTreeMap<String,Object>> data = new ArrayList<>();
            int page  =1;
            Double totalPage;

            do{

                URL url = new URL("https://jsonmock.hackerrank.com/api/article_users?page="+page);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("Content-Type", "application/json");
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                String res = String.valueOf(content);
                Map<String,Object> resMap = new Gson().fromJson(res, Map.class);
                totalPage = (Double) resMap.get("total_pages");
                data.addAll((Collection<? extends LinkedTreeMap<String, Object>>) resMap.get("data"));
                page++;
            }while (page == totalPage);

            System.out.println("totale page = "+page+"  datasize = "+data.size());
            int count = 0;
            for(int i =0;i< data.size();i++){
                LinkedTreeMap<String,Object> obj = data.get(i);
                Double submission_count = (Double) obj.get("submission_count");
                if(submission_count > 10){
                    System.out.println(obj.get("username"));
                }
            }
        }catch(Exception e){
            System.out.println("exception occured ="+e.getMessage());
            e.printStackTrace();
        }
    }
}
