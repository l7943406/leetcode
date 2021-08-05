package P1396设计地铁系统;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    Map<String,Map<String,int[]>> map;
    Map<Integer, Object[]> idMap;

    public UndergroundSystem() {
        map = new HashMap<>();
        idMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        idMap.put(id,new Object[]{stationName,t});
    }

    public void checkOut(int id, String stationName, int t) {

        Object[] r = idMap.get(id);


        map.putIfAbsent((String) r[0],new HashMap<>());

        Map<String,int[]> m = map.get((String) r[0]);

        m.putIfAbsent(stationName,new int[2]);
        int[] p = m.get(stationName);

        p[0] += t - (Integer)r[1];
        p[1]++;
    }

    public double getAverageTime(String startStation, String endStation) {
        Map<String,int[]> m = map.get(startStation);
        if(m == null){
            return 0;
        }
        int[] p = m.get(endStation);
        if(p[1] == 0){
            return 0;
        }
        return (double) p[0] / p[1];

    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
/*

请你实现一个类=UndergroundSystem=，它支持以下 3 种方法：

1.=checkIn(int id, string stationName, int t)

编号为=id=的乘客在 t=时刻进入地铁站=stationName=。
一个乘客在同一时间只能在一个地铁站进入或者离开。
2.=checkOut(int id, string stationName, int t)

编号为=id=的乘客在 t=时刻离开地铁站 stationName=。
3.=getAverageTime(string startStation, string endStation)=

返回从地铁站=startStation=到地铁站=endStation=的平均花费时间。
平均时间计算的行程包括当前为止所有从=startStation=直接到达=endStation=的行程。
调用=getAverageTime=时，询问的路线至少包含一趟行程。
你可以假设所有对=checkIn=和=checkOut=的调用都是符合逻辑的。也就是说，如果一个顾客在 t1=时刻到达某个地铁站，那么他离开的时间=t2=一定满足=t2 > t1=。所有的事件都按时间顺序给出。

 */