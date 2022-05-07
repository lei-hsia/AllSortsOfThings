package json.demo;

/**
 * @author lei
 * @date 10/30/2021 3:09 PM
 */
public class JsonToolDemo {

    public static void main(String[] args) {
        String s = "some demo string";
        //JsonTool.parseToObject
        Date date = new Date();
        date.write();
    }
}

class Date {
    private int day;
    private int month;
    private int year;

    public Date(){}

    public Date(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // q 9
    public void write(){
        System.out.println(day);
        System.out.println(this);
        System.out.println(month()); // just method call; no invoke
    }

    public int month(){
        return 0;
    }

    public static Date findBirthDate(){
        Date birthDate = new Date();
        birthDate.month();

        return birthDate;
    }

    public void addYears(int n){
        year += 100;
    }

    /*
    *   pass-by-value: recent: null, passed from recentDate
    *                  however, changes in recent has nothing to do with recentDate
    * */
    public static void addCentury(Date recent, Date old){
        old.addYears(100);
        recent = old;
    }

    public static void main(String[] args) {
//        Date date = new Date();
//        date.month(); // invoke

        // q 11
        Date oldDate = new Date(1, 13, 1900);
        Date recentDate = null;
        addCentury(recentDate, oldDate);

        System.out.println(oldDate);
        System.out.println(recentDate);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}




