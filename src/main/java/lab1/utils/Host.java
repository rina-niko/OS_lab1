package lab1.utils;

import java.util.ArrayList;
import java.util.List;

public class Host {

    private String ip;
    private String mask;
    private List<Integer> ipBin;

    private List<Integer> maskBin;

    private List<Integer> addressNetWork;

    private List<Integer> broadcast;

    private int countAddress;

    public Host(String ip, String mask) {
        this.ip = ip;
        this.mask = mask;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public List<Integer> getIpBin() {
        return ipBin;
    }

    public void setIpBin(List<Integer> ipBin) {
        this.ipBin = ipBin;
    }

    public ArrayList<Integer> getMaskBin() {
        return (ArrayList<Integer>) maskBin;
    }

    public void setMaskBin(List<Integer> maskBin) {
        this.maskBin = maskBin;
    }

    public List<Integer> getAddressNetWork() {
        return addressNetWork;
    }

    public void setAddressNetWork(List<Integer> addressNetWork) {
        this.addressNetWork = addressNetWork;
    }

    public List<Integer> getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(List<Integer> broadcast) {
        this.broadcast = broadcast;
    }

    public int getCountAddress() {
        return countAddress;
    }

    public void setCountAddress(int countAddress) {
        this.countAddress = countAddress;
    }

    public void print(){
        System.out.println("IP: " + getIp());
        System.out.println("Mask: " + getMask());
        System.out.println("Bin-IP: " + getIpBin());
        System.out.println("Bin-Mask: " + getMaskBin());
        System.out.println("Address NetWork: " + getAddressNetWork());

    }
}
