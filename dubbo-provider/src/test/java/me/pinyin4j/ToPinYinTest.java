package me.pinyin4j;

import com.blue.common.pinyin4j.ChangeToPinYin;
import org.junit.Test;

public class ToPinYinTest {

    @Test
    public void isN(){
        ChangeToPinYin changeToPinYin = new ChangeToPinYin();
        String str = "你在做什么？what are you nong sa lie?";

        System.out.println(changeToPinYin.getStringPinYin(str));
    }

    @Test
    public void changechar(){
        ChangeToPinYin changeToPinYin = new ChangeToPinYin();
        char c = '你';
        System.out.println(changeToPinYin.getCharPinYin(c));
    }
}
