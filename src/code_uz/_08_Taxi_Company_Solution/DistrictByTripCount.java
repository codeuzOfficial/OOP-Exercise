package code_uz._08_Taxi_Company_Solution;

public class DistrictByTripCount implements InfoI {

    private String disName;
    private Integer tripCount;

    public DistrictByTripCount(String disName, Integer tripCount) {
        this.disName = disName;
        this.tripCount = tripCount;
    }

    @Override
    public String getId() {
        return disName;
    }

    @Override
    public int getValue() {
        return tripCount;
    }

    public void incrementTripCount() {
        this.tripCount++;
    }

    @Override
    public int compareTo(InfoI o) {
        DistrictByTripCount dis = (DistrictByTripCount) o;

        int result = dis.tripCount - this.tripCount;
        if (result == 0) {
            return this.disName.compareTo(dis.disName);
        }

        return result;
    }
}
