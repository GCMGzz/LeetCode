/**
 * @ author  wilbur
 * @ date   2020/12/28 9:53
 *
 * ����һ���ǿ��������飬����ĳ��Ԫ��ֻ����һ�����⣬����ÿ��Ԫ�ؾ��������Ρ��ҳ��Ǹ�ֻ������һ�ε�Ԫ�ء�
 * ����㷨Ӧ�þ�������ʱ�临�Ӷȡ� ����Բ�ʹ�ö���ռ���ʵ����
 */
public class SingleNumber136b {
    public int singleNumber(int[] nums) {
        // 1��Map
//        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
//        for(int num:nums){
//            if(map.containsKey(num)){
//                map.put(num,2);
//            }else map.put(num,1);
//        }
//        for(Integer key:map.keySet()){
//            if(map.get(key)==1){
//                return key;
//            }
//        }
//        return 0;

        //2��  λ����
        int ans =0;
        //���
        //��λ��ͬΪ0 ����Ϊ1�� ���� �����ɺͽ����
        //a^b^c^b^c = a^(b^b)^(c^c) = a^0^0 = a
        for(int x : nums){
            ans^=x;
        }
        return ans;
    }
}
