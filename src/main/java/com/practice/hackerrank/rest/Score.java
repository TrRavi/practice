package com.practice.hackerrank.rest;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Score {
    public static void main(String[] args)  {
        try{
            String baseUrl = "https://jsonmock.hackerrank.com/api/football_matches?";
            boolean status = true;
            int i = 1;
            int totalgoal = 0;
            do{
                String content = getData(baseUrl,"team1=Barcelona","year=2011","page="+i);
                TeamMatch teamMatch = new Gson().fromJson(content, TeamMatch.class);
                List<Data> dataList = teamMatch.getData();
                for(Data data:dataList){

                    totalgoal = totalgoal+Integer.parseInt(data.getTeam2goals());
                }
                int perPage = teamMatch.getPer_page();
                int totalmatch = teamMatch.getTotal();
                int currentPage = Integer.parseInt(teamMatch.getPage());
                status =   currentPage*perPage >totalmatch ?false:true;
                System.out.println(totalgoal);


            }while (status);



        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
    
    private static String getData(String baseUrl, String team, String year, String page){
        String res = null;
        try{
            String newUrl = baseUrl+"&"+year+"&"+team+"&"+page;
            System.out.println(newUrl);
          //  URL url = new URL("https://jsonmock.hackerrank.com/api/football_matches?year=2011&team2=Barcelona&page=1");
            URL url = new URL(newUrl);
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
            res = String.valueOf(content);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


}

class TeamMatch{
    String page;
    int per_page,total,total_pages;
    List<Data> data;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}

class Data {
     String competition,round,team1,team2,team1goals,team2goals;

    int year;

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getTeam1goals() {
        return team1goals;
    }

    public void setTeam1goals(String team1goals) {
        this.team1goals = team1goals;
    }

    public String getTeam2goals() {
        return team2goals;
    }

    public void setTeam2goals(String team2goals) {
        this.team2goals = team2goals;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
