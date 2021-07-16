package P468验证IP地址;


import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.UnknownHostException;
import java.util.InvalidPropertiesFormatException;
import java.util.LinkedList;
/*
class Solution {
    public String validIPAddress(String IP) {
        if(IP.length() < 7 || IP.length() > 39){
            return "Neither";
        }
        byte[] ip = IP.getBytes();
        for(byte c : ip){
            if(c == '.'){
                return IPV4(ip);
            }else if(c == ':'){
                return IPV6(ip);
            }
        }
        return "Neither";
    }
    public String IPV4(byte[] ip){
        if(ip.length < 7 || ip.length > 15){
            return "Neither";
        }
        LinkedList<Integer> pointIndex = new LinkedList<>();
        pointIndex.add(-1);
        for (int i = 0; i < ip.length; i++) {
            if(ip[i] == '.'){
                pointIndex.add(i);
            }
        }
        pointIndex.add(ip.length);
        if(pointIndex.size() != 5){
            return "Neither";
        }
        for (int i = 1; i < pointIndex.size(); i++) {
            if(!IPV4NumVe(ip,pointIndex.get(i - 1) + 1,pointIndex.get(i) - 1)){
                return "Neither";
            }
        }
        return "IPv4";
    }
    public boolean IPV4NumVe(byte[] ip,int start,int end){
        if(start > end || (end - start > 0 && ip[start] == '0')){
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if(ip[i] >= '0' && ip[i] <= '9'){
                num *= 10;
                num += ip[i] - '0';
            }else{
                return false;
            }
        }
        return num >= 0 && num <= 255;
    }
    public String IPV6(byte[] ip){
        if(ip.length < 15 || ip.length > 39){
            return "Neither";
        }
        LinkedList<Integer> colonIndex = new LinkedList<>();
        colonIndex.add(-1);
        for (int i = 0; i < ip.length; i++) {
            if(ip[i] == ':'){
                colonIndex.add(i);
            }
        }
        colonIndex.add(ip.length);
        if(colonIndex.size() != 9){
            return "Neither";
        }
        for (int i = 1; i < colonIndex.size(); i++) {
            if(!IPV6NumVe(ip,colonIndex.get(i - 1) + 1,colonIndex.get(i) - 1)){
                return "Neither";
            }
        }
        return "IPv6";
    }
    public boolean IPV6NumVe(byte[] ip,int start,int end){
        if(start > end || end - start + 1 > 4){
            return false;
        }
        for (int i = start; i <= end; i++) {
            if( !(ip[i] <= 'f' && ip[i] >= 'a') && !(ip[i] <= 'F' && ip[i] >= 'A') && !(ip[i] <= '9' && ip[i] >= '0') ){
                return false;
            }
        }
        return true;
    }




}
*/


class Solution {
    public String validIPAddress(String IP) {
        boolean ipv4 = true;
        boolean ipv6 = true;
        byte[] ip = IP.getBytes();
        try {
            Inet4Address.getByAddress(ip);
        } catch (Exception e) {
            ipv4 = false;
        }
        if(ipv4){
            return "IPv4";
        }
        try {
            Inet6Address.getByAddress(ip);
        } catch (Exception e) {
            ipv6 = false;
        }
        if(ipv6){
            return "IPv6";
        }else{
            return "Neither";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validIPAddress("114.114.1.1"));
    }
}
