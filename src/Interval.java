public class Interval {
    String day;
    int start;
    int end;

    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    public String getDay() {
        return day;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}
