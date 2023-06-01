class UndergroundSystem {

    // Map<String id, Pair<start, t1> pair> station
    // Map<String start, Map<String end, t>> average
    Map<Integer, Pair<String, Integer>> station;
    Map<String, Map<String, Pair<Double, Integer>>> average;
    public UndergroundSystem() {
        station = new HashMap<>();
        average = new HashMap<>();
    }
    
    // station map: id => start
    public void checkIn(int id, String stationName, int t) {
        station.put(id, new Pair<String, Integer>(stationName, t));
        if(!average.containsKey(stationName)){
            average.put(stationName, new HashMap<String, Pair<Double, Integer>>());
        }
    }
    
    // update average: (time.get(map.get(id)[0]).get(checkout)*n + t - map.get(id)[1])/(n+1)
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> startInfo = station.get(id);
        station.remove(id);
        Double difference = (double)t - startInfo.getValue();
        Pair<Double, Integer> current = average.get(startInfo.getKey()).getOrDefault(stationName, new Pair<Double, Integer>(0.0, 0));
        Double avg = (current.getKey()*current.getValue() + difference)/(current.getValue() + 1);
        average.get(startInfo.getKey()).put(stationName, new Pair<Double, Integer>(avg, current.getValue() + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        // System.out.println(average);
        return average.get(startStation).get(endStation).getKey();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */