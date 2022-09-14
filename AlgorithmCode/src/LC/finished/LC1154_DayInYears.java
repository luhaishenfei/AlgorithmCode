package LC.finished;

public class LC1154_DayInYears {
    public static void main(String[] args) {
        System.out.println(getDayInYear("1998-07-12"));
    }

    public static int getDayInYear(String date) {
        String[] dataArr = date.split("-");
        int year = Integer.parseInt(dataArr[0]);
        int month = Integer.parseInt(dataArr[1]);
        int day = Integer.parseInt(dataArr[2]);

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31,};
        int ans = 0;
        if (month == 1) {
            ans = day;
        } else if (month == 2) {
            ans = 31 + day;
        } else {
            for (int i = 0; i < month-1; i++) {
                ans+=daysInMonth[i];
            }
            ans+=day;
            if (year%4==0){
                ans++;
            }
        }


        return ans;


    }
    public static int getDayInYearPlusPlus(String date) {
        String[] dataArr = date.split("-");
        int year = Integer.parseInt(dataArr[0]);
        int month = Integer.parseInt(dataArr[1]);
        int day = Integer.parseInt(dataArr[2]);
        if (month == 1) {
        } else if (month == 2) {
            day += 31 ;
        } else if (month ==3) {
            day += 31 + 28 ;
        }else if (month ==4) {
            day += 31 + 28 +31;
        }else if (month ==5) {
            day += 31 + 28 +31+30;
        }else if (month ==6){
            day +=31+ 28+ 31+ 30+ 31;
        }else if (month ==7){
            day +=31+ 28+ 31+ 30+ 31+ 30;
        }else if (month ==8){
            day +=31+ 28+ 31+ 30+ 31+ 30+ 31;
        }else if (month ==9){
            day +=31+ 28+ 31+ 30+ 31+ 30+ 31+ 31;
        }else if (month ==10){
            day +=31+ 28+ 31+ 30+ 31+ 30+ 31+ 31+ 30;
        }else if (month ==11){
            day +=31+ 28+ 31+ 30+ 31+ 30+ 31+ 31+ 30+ 31;
        }else if (month ==12){
            day +=31+ 28+ 31+ 30+ 31+ 30+ 31+ 31+ 30+ 31+ 30;
        }
        if (month>2&&year%4==0){
            day++;
        }
        return day;
    }
    public static int getDayInYearPlus(String date) {
        String[] dataArr = date.split("-");
        int year = Integer.parseInt(dataArr[0]);
        int month = Integer.parseInt(dataArr[1]);
        int day = Integer.parseInt(dataArr[2]);
        int ans = 0;
        if (month == 1) {
            ans = day;
        } else if (month == 2) {
            ans = 31 + day;
        } else if (month ==3) {
            ans = 31 + 28 + day;
        }else if (month ==4) {
            ans = 31 + 28 +31+ day;
        }else if (month ==5) {
            ans = 31 + 28 +31+30+ day;
        }else if (month ==6){
            ans =31+ 28+ 31+ 30+ 31+day;
        }else if (month ==7){
            ans =31+ 28+ 31+ 30+ 31+ 30+day;
        }else if (month ==8){
            ans =31+ 28+ 31+ 30+ 31+ 30+ 31+ day;
        }else if (month ==9){
            ans =31+ 28+ 31+ 30+ 31+ 30+ 31+ 31+day;
        }else if (month ==10){
            ans =31+ 28+ 31+ 30+ 31+ 30+ 31+ 31+ 30+ day;
        }else if (month ==11){
            ans =31+ 28+ 31+ 30+ 31+ 30+ 31+ 31+ 30+ 31+ day;
        }else if (month ==12){
            ans =31+ 28+ 31+ 30+ 31+ 30+ 31+ 31+ 30+ 31+ 30+day;
        }
        if (year%4==0){
            ans++;
        }
        return ans;
    }
}
