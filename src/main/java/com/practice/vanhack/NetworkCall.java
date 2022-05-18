package com.practice.vanhack;

import com.google.gson.Gson;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

class EndPointResources {


}


class NetworkCall {
    //2  8  5  50

  public static void main(String[] args) {
      try{
          String endPointUrl = constructURL(2,1);
          URL url = new URL(endPointUrl);
          HttpURLConnection con = (HttpURLConnection) url.openConnection();
          con.setRequestMethod("GET");
          con.setRequestProperty("User-Agent", "Mozilla/5.0");
          int responseCode = con.getResponseCode();
          //System.out.println("\nSending 'GET' request to URL : " + url);
          //System.out.println("Response Code : " + responseCode);
          BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
          String inputLine;
          StringBuffer response = new StringBuffer();
          while ((inputLine = in.readLine()) != null) {
              response.append(inputLine);
          }
          in.close();
          if(responseCode == 200){
              System.out.println(response);
              Gson gson = new Gson();
              TransactionData transactionData = gson.fromJson(String.valueOf(response),TransactionData.class);
              int start = 5;
              int end = 50;
              List<Data> userTransactions = transactionData.getData();
                int sum = userTransactions.stream()
                        .filter(
                            data -> {
                              int ipStartRange = Integer.parseInt(data.getIp().split("\\.")[0]);
                                System.out.println(ipStartRange);
                                return ipStartRange >= start && ipStartRange <= end && data.getLocation().getId() == 8;
                            })
                        .mapToInt(Data::getAmount)
                        .sum();
        System.out.println("sum = "+sum);
          }else{
              System.out.println("Not Success");
              System.out.println(response.toString());
          }

      }catch(MalformedURLException e){
          System.out.println("Provide Proper URL");

      }catch(Exception e){
          e.printStackTrace();
      }
  }

    public static String constructURL( int userId,int pageNo) {
        return "https://jsonmock.hackerrank.com/api/transactions/search?userId="+userId;
    }
}

class TransactionData {
   private int page;
   private int per_page;
   private int total;
   private int total_pages;
    private List<Data> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
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
class Data{

    private int id;
    private int userId;
    private String userName;

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    private BigInteger timestamp;
    private String txnType;
    private String amount;
    private Location location;
    private String ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getTxnType() {
        return txnType;
    }

    public void setTxnType(String txnType) {
        this.txnType = txnType;
    }

    public int getAmount() {

        NumberFormat format = NumberFormat.getCurrencyInstance();
        Number number = null;
        try {
            number = format.parse(amount);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       // System.out.println("amt = "+Double.parseDouble(String.valueOf(number)));
        return (int)Double.parseDouble(String.valueOf(number));
        //return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
class Location{
    private int id;
    private String address;
    private String city;
    private int zipCode;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


}
