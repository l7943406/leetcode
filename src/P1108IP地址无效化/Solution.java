package P1108IP地址无效化;

class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}