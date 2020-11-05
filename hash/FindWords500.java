import java.util.Arrays;
import java.util.HashMap;

/**
 * @ author  wilbur
 * @ date   2020/11/5 21:43
 *
 *                          /给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。
 */
public class FindWords500 {
    public HashMap getMap(){
        HashMap<Character, Integer> map =new HashMap<>();
        //第一行
        map.put('Q',1);
        map.put('W',1);
        map.put('E',1);
        map.put('R',1);
        map.put('T',1);
        map.put('Y',1);
        map.put('U',1);
        map.put('I',1);
        map.put('O',1);
        map.put('P',1);
        //第二行
        map.put('A',2);
        map.put('S',2);
        map.put('D',2);
        map.put('F',2);
        map.put('G',2);
        map.put('H',2);
        map.put('J',2);
        map.put('K',2);
        map.put('L',2);
        //第三行
        map.put('Z',3);
        map.put('X',3);
        map.put('C',3);
        map.put('V',3);
        map.put('B',3);
        map.put('N',3);
        map.put('M',3);
        return map;

    }
    public String[] findWords(String[] words) {

        HashMap <Character ,Integer > map =getMap();
        String[] res = new String[words.length];
        int index = 0;
        for (String word : words) {
            int temp =0 ;
            int  len =word.length();
            for(int i = 0 ;i<len;i++){
                char c =word.charAt(i);
                if (c>=97){
                    //小写字母转大写
                    c=(char)(c-32);
                }
                //判断是否在同一行
                int line=map.get(c);
                if(temp!=0&&line!=temp) break;
                temp=line;
                //在同一行，将该单词放入res 动态注入
                if(i==len-1) res[index++]=word;
            }
        }
        return Arrays.copyOf(res,index);
    }
}
