package code_uz._06_Flat_Rent_Solution;

public class Flat {

    private String code;
    private int smq;

    private double[] tariffs;

    private boolean[] freeWeeks = new boolean[52];

    public Flat(String code, int smq) {
        this.code = code;
        this.smq = smq;

        for (int i = 0; i < 52; i++) {
            freeWeeks[i] = true;
        }
    }

    public String getCode() {
        return code;
    }

    public int getDimension() {
        return smq;
    }

    public double[] getTariffs() {
        return tariffs;
    }

    public void setTariffs(double[] tariffs) {
        this.tariffs = tariffs;
    }

    public boolean[] getAvailability() {
        return freeWeeks;
    }


    public void setAvailability(int startWeeks, int endWeeks) {
        for (int i = startWeeks; i < startWeeks + endWeeks; i++) {
            this.freeWeeks[i] = false;
        }
    }

    public double getOccupancy() {
        double busy = 0;

        for (int i = 0; i < 52; i++) {
            if (!freeWeeks[i]) {
                busy++;
            }
        }

        return busy / 52;
    }

}
