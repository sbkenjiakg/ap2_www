/*
 * Document   : Exam
 * Created on : 2015/12/1, 4:21:48
 * Author     : ogiya
 */
package en09;

/**
 *
 * @author ogiya
 */
public class Exam {

    private String name; // 氏名
    private int point;   // 点数
    private String result; //結果

    // コンストラクタ

    public Exam(String name, int point) {
        this.name = name;   // 名前を設定
        this.point = point; // 点数を設定
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public String getResult() {
        if (this.point>=80) {
            this.result = "A";
        }else if (this.point>=60) {
            this.result = "B";
        }else {
            this.result = "C";
        }
        return result;
    }
    

}
