/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kg09;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author C0114112
 */
public class Animal2 {
    int num;
    String English;
    String Japanese;

    public int getNum() {
        return num;
    }

    public String getEnglish() {
        return English;
    }

    public String getJapanese() {
        return Japanese;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setEnglish(String English) {
        this.English = English;
    }

    public void setJapanese(String Japanese) {
        this.Japanese = Japanese;
    }
    
        List<String> list1 = new ArrayList<String>();
        
    
    void printAnimal(){
        System.out.println(list1.get(0) + ". " + list1.get(1));
        System.out.println("ひらがな：" + list1.get(2));
        System.out.println("英語：" + list1.get(3));
        System.out.println(list1.get(4) + ". " + list1.get(5));
        System.out.println("ひらがな：" + list1.get(6));
        System.out.println("英語：" + list1.get(7));
        System.out.println(list1.get(8) + ". " + list1.get(9));
        System.out.println("ひらがな：" + list1.get(10));
        System.out.println("英語：" + list1.get(11));
    }
            
            
}
