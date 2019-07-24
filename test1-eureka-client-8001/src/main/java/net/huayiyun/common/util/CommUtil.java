package net.huayiyun.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 */

/**
 * 工具类
 * @Project : huayi-ncd
 * @Package Name : com.huayi.ncd.common
 * @Description : TODO
 * @Author : zhangshuai
 * @Creation Date : 2018年04月08日 9:58
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
public class CommUtil {

    /**
     * JSON字符串转Map对象
     * @Author zhangshuai
     * @param jsonParam
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 09:38:00
     */
    public static Map<String,Object> jsonToMap(String jsonParam){

        Map<String, Object> map = new HashMap<String, Object>();
        try {
            JSONObject json= JSONObject.parseObject(jsonParam);
            for(Object obj:json.keySet()){
                Object obj2=json.get(obj);
                if(obj2 instanceof JSONArray){
                    //http://www.tuicool.com/articles/BzQrayA
                    List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
                    Iterator<Object> it = ((JSONArray)obj2).iterator();
                    JSONArray array=(JSONArray) obj2;
                    for(int i=0;i<array.size();i++){
                        if(array.get(i) instanceof String){
                            Map<String,Object> map2=new HashMap<String,Object>();
                            map2.put(String.valueOf(i),array.get(i).toString());
                            list.add(map2);
                        }
                        if(array.get(i) instanceof JSONObject){
                            JSONObject json2 = (JSONObject) it.next();
                            list.add(jsonToMap(json2.toString()));
                        }

                    }
//                    while(it.hasNext()){
//                        JSONObject json2 = (JSONObject) it.next();
//                        list.add(jsonToMap(json2.toString()));
//                    }
                    map.put(obj.toString(), list);
                }
                else{
                    map.put(obj.toString(), obj2);
                }

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            map=null;
            e.printStackTrace();
        }
        return map;
    }


    /**
     * JSON字符串转实体对象
     * @Author zhangshuai
     * @param jsonParam
     * @param beanClass
     * @return java.lang.Object
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 09:39:18
     */
//    public static Object jsonToObject(String jsonParam,Class<?> beanClass){
//
//        Map<String,Object> map=jsonToMap(jsonParam);
//        if (map!=null){
//            Object obj=mapToObject(map,beanClass);
//            return obj;
//        }
//        else{
//            return null;
//        }
//    }


    /**
     * 判断String字符串是否为数字
     * @Author zhangshuai
     * @param str
     * @return boolean
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 09:39:58
     */
    public static boolean isNumber(String str) {

        // TODO Auto-generated method stub
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    /**
     * String字符串转Timestamp
     * @Author zhangshuai
     * @param str
     * @return java.sql.Timestamp
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 09:40:27
     */
    public static Timestamp stt(String str){

        return Timestamp.valueOf(str);
    }


    /**
     * String字符串转Double
     * @Author zhangshuai
     * @param str
     * @return double
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 09:41:41
     */
    public static double std(String str){

        return Double.parseDouble(str);
    }

    public static boolean isDate(String str){
        boolean isdate=true;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // TODO: handle exception
            isdate=false;
        }
        finally {
            return isdate;
        }

    }

    /**
     * 判断字符串是否为合格的日期
     * @Author zhangshuai
     * @param str
     * @return boolean
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 09:43:53
     */
    public static boolean isTime(String str){

        boolean isTime=true;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");

        try {
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            // TODO: handle exception
            isTime=false;
        }
        finally {
            return isTime;
        }

    }

    /**
     * Map转实体对象
     * @Author zhangshuai
     * @param map
     * @param beanClass
     * @return java.lang.Object
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 09:56:48
     */
//    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass){
//
//
//        if(map==null){
//            return null;
//        }
//
//        Object obj=new Object();
//
//        try {
//            obj = beanClass.newInstance();
//            List<Field> fieldList = new ArrayList<Field>() ;
//            Class tempClass =obj.getClass();
//            while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
//                fieldList.addAll(Arrays.asList(tempClass .getDeclaredFields()));
//                tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
//            }
//           // Field[] fields = obj.getClass().getDeclaredFields();
//            for (Field field : fieldList) {
//                int mod = field.getModifiers();
//                if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
//                    continue;
//                }
//                if(!map.containsKey(field.getName())){
//                    continue;
//                }
//                field.setAccessible(true);
//                field.set(obj, conver2(map.get(field.getName()),field.getType()));
//            }
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            obj=null;
//        }
//        return obj;
//    }

    /**
     * 类型转换
     * @Author zhangshuai
     * @param object
     * @param type
     * @return java.lang.Object
     * @Description TODO
     * @creat_date 2018年04月23日
     * @creat_time 12:55:32
     */
//    public static Object conver2(Object object, Class<?> type){
//        if(object==null){
//            return null;
//        }
//        if(type.equals(int.class) || type.equals(Integer.class)){
//            return Integer.parseInt(object.toString());
//        }
//        if (type.equals(double.class) || type.equals(Double.class)) {
//            return Double.parseDouble(object.toString());
//        }
//        if (type.equals(short.class) || type.equals(Short.class)) {
//            return Short.parseShort(object.toString());
//        }
//        if (type.equals(long.class) || type.equals(Long.class)) {
//            return Long.parseLong(object.toString());
//        }
//        if (type.equals(float.class) || type.equals(Float.class)) {
//            return Float.parseFloat(object.toString());
//        }
//        if(type.equals(String.class)){
//            return object.toString();
//        }
//        if(type.equals(Timestamp.class)){
//            String str=object.toString();
//            if(StringUtils.isNullOrEmpty(str)){
//                return null;
//            }
//            if(isTime(str)){
//                return Timestamp.valueOf(str);
//            }
//        }
//        if(type.equals(java.sql.Date.class)){
//            String str=object.toString();
//            if(StringUtils.isNullOrEmpty(str)){
//                return null;
//            }
//            if(isDate(str)){
//                return java.sql.Date.valueOf(str);
//            }
//        }
//        return object;
//    }

    /**
     * 强转数值类型
     * @Author zhangshuai
     * @param object
     * @param type
     * @return java.lang.Object
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 09:57:12
     */
//    public static Object convert(Object object, Class<?> type) {
//
//
//        if (object instanceof Number) {
//            Number number = (Number) object;
//            if (type.equals(byte.class) || type.equals(Byte.class)) {
//                return number.byteValue();
//            }
//            if (type.equals(short.class) || type.equals(Short.class)) {
//                return number.shortValue();
//            }
//            if (type.equals(int.class) || type.equals(Integer.class)) {
//                return number.intValue();
//            }
//            if (type.equals(long.class) || type.equals(Long.class)) {
//                return number.longValue();
//            }
//            if (type.equals(float.class) || type.equals(Float.class)) {
//                return number.floatValue();
//            }
//            if (type.equals(double.class) || type.equals(Double.class)) {
//                return number.doubleValue();
//            }
//        }
//        if(object instanceof String){
//            String str=(String) object;
//            if(StringUtils.isNullOrEmpty(str)){
//                return null;
//            }
//            if(isTime(str)){
//                return Timestamp.valueOf(str);
//            }
//
//
//        }
//        return object;
//    }

    /**
     * 获取UUID
     * @Author zhangshuai
     * @param
     * @return java.lang.String
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:00:12
     */
    public static String getUUID(){

        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * 得到精确的年龄
     * @Author zhangshuai
     * @param birthday
     * @return int
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:00:26
     */
    public static int getAge(Date birthday) {

        Calendar birth = Calendar.getInstance();
        if (birthday != null) {
            birth.setTime(birthday);
        } else {
            return 0;
        }
        return getTimeAge(birth);
    }

    /**
     * @Author zhengbo
     * @param strDate
     * @return java.util.Date
     * @Description 将String类型的日期转换成Date类型
     * @creat_date 2018年04月10日
     * @creat_time 10:18:16
     * 自动计算年龄的方法在调用
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * @Author zhengbo
     * @param strDate
     * @return java.util.Date
     * @Description 将String类型的长时间格式日期转换成Date类型
     * @creat_date 2018年04月17日
     * @creat_time 13:47:11
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 计算精确到毫秒的年龄
     * @Author zhangshuai
     * @param birth
     * @return int
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:00:51
     */
    public static int getTimeAge(Calendar birth) {

        Calendar now = Calendar.getInstance();
        if (birth.after(now)) {
            return -1;
        }
        if (birth.equals(now)) {
            return 0;
        }
        int age = now.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (now.get(Calendar.MONTH) - birth.get(Calendar.MONTH) < 0) {
            return age - 1;
        }
        if (now.get(Calendar.MONTH) - birth.get(Calendar.MONTH) > 0) {
            return age;
        }
        if (now.get(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH) < 0) {
            return age - 1;
        }
        if (now.get(Calendar.DAY_OF_MONTH) - birth.get(Calendar.DAY_OF_MONTH) > 0) {
            return age;
        }
        if (now.get(Calendar.HOUR_OF_DAY) - birth.get(Calendar.HOUR_OF_DAY) < 0) {
            return age - 1;
        }
        if (now.get(Calendar.HOUR_OF_DAY) - birth.get(Calendar.HOUR_OF_DAY) > 0) {
            return age;
        }
        if (now.get(Calendar.MINUTE) - birth.get(Calendar.MINUTE) < 0) {
            return age - 1;
        }
        if (now.get(Calendar.MINUTE) - birth.get(Calendar.MINUTE) > 0) {
            return age;
        }
        if (now.get(Calendar.SECOND) - birth.get(Calendar.SECOND) < 0) {
            return age - 1;
        }
        if (now.get(Calendar.SECOND) - birth.get(Calendar.SECOND) > 0) {
            return age;
        }
        if (now.get(Calendar.MILLISECOND) - birth.get(Calendar.MILLISECOND) < 0) {
            return age - 1;
        }
        if (now.get(Calendar.MILLISECOND) - birth.get(Calendar.MILLISECOND) > 0) {
            return age;
        }
        return age;
    }

    /**
     * 计算两个时间差的年月日
     * @Author zhangshuai
     * @param startDate
     * @param endDate
     * @return java.lang.String
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:01:09
     */
    public static String getSubYMDStrByDates(Date startDate, Date endDate){

        if(startDate == null){
            startDate = new Date();
        }
        if(endDate == null){
            endDate = new Date();
        }
        long l=endDate.getTime() - startDate.getTime();//相差毫秒数
        long sumDays = l/(24*60*60*1000);//相差总天数
        long years=sumDays/(12*30);//相差多少年
        long months=(sumDays - years*12*30)/30;//相差多少年多少月
        long days = sumDays - years*12*30 - months*30;//相差多少年多少月多少日
        if(years <1){
            if(months<1){
                if(days<1){
                    return  "0天";//+days+"天";//相差时间
                }else{
                    return  days+"天";//+days+"天";//相差时间
                }
            }else{
                if(days<1){
                    return  months+"个月";//+days+"天";//相差时间
                }else{
                    if(months>=11){
                        return  "1年";//+days+"天";//相差时间
                    }else{
                        return  (months+1)+"个月";//+days+"天";//相差时间
                    }
                }
            }
        }else{
            if(days<1){
                return  years+"年"+months+"个月";//+days+"天";//相差时间
            }else{
                if(months>=11){
                    return  (years+1)+"年";//+days+"天";//相差时间
                }else{
                    return  years+"年"+(months+1)+"个月";//+days+"天";//相差时间
                }
            }
        }
    }

    /**
     * 计算两个时间差的年月日时分秒
     * @Author zhangshuai
     * @param startDate
     * @param endDate
     * @return java.lang.String
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:01:25
     */
    public static String getSubYMDHMSStrByDates(Date startDate, Date endDate){


        if(startDate == null){
            startDate = new Date();
        }
        if(endDate == null){
            endDate = new Date();
        }
        long l=endDate.getTime() - startDate.getTime();//相差毫秒数
        long sumDays = l/(24*60*60*1000);//相差总天数
        long years=sumDays/(12*30);//相差多少年
        long months=(sumDays - years*12*30)/30;//相差多少年多少月
        long days = sumDays - years*12*30 - months*30;//相差多少年多少月多少日
        long hour=(l/(60*60*1000)-sumDays*24);//相差多少天多少小时
        long min=((l/(60*1000))-sumDays*24*60-hour*60);//相差多少天多少小时多少分
        long s=(l/1000-sumDays*24*60*60-hour*60*60-min*60);//相差多少天多少小时多少分多少秒
        return  years+"年"+months+"月"+days+"天"+hour+"小时"+min+"分"+s+"秒";//相差时间
    }

    /**
     * 计算两个时间所差天数
     * @Author zhangshuai
     * @param smdate
     * @param bdate
     * @return int
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:01:42
     */
    public static int dateDiff(String smdate, String bdate) throws Exception{

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days))+1;
    }

    /**
     * 将血糖的mg/dl转换为mm/ol
     * @Author zhangshuai
     * @param mgdl
     * @return double
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:02:05
     */
    public static double booldGlucoseCompute(int mgdl){

        BigDecimal mmol=new BigDecimal(0.0);

        try {
            mmol=mmol.add(new BigDecimal(mgdl).divide(new BigDecimal(18),1,BigDecimal.ROUND_HALF_UP));
        }catch (Exception e){
            e.printStackTrace();
            mmol=new BigDecimal(0.0);
        }
        finally {
            return mmol.doubleValue();
        }
    }

    /**
     * 十进制转换为十六进制
     * @Author zhangshuai
     * @param number
     * @return java.lang.String
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:02:23
     */
    public static String tenToSixteen(Integer number){

        String sixteen="";
        try {
            sixteen=number.toHexString(number);
        }catch (Exception e){
            sixteen="";
            e.printStackTrace();
        }
        finally {
            return sixteen;
        }
    }

    /**
     * 随机生成随机数
     * @Author zhangshuai
     * @param digit
     * @return java.lang.Integer
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:02:40
     */
    public static Integer randomNumber(int digit){

        Integer number=0;
        String sources = "0123456789";
        Random rand = new Random();

        StringBuffer digitStr=new StringBuffer();

        for (int j = 0; j < 6; j++)
        {
            digitStr.append(sources.charAt(rand.nextInt(9)) + "");
        }
        number=Integer.parseInt(digitStr.toString());
        return number;
    }


    /**
     * MD5加密密码
     * @Author zhangshuai
     * @param pwd
     * @return java.lang.String
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:03:00
     */
    public static String MD5PWD(String pwd){

        StringBuffer password = new StringBuffer();

        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(pwd.getBytes());
            for (byte b : result) {
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    password.append("0");
                }
                password.append(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            return password.toString();
        }
    }

    /**
     * 手机校验
     * @Author zhangshuai
     * @param mobiles
     * @return boolean
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:03:20
     */
    public static boolean isMobile(String mobiles) {

        Pattern p = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");
        //^(1(([35][0-9])|(47)|[8][01236789]))[0-9]{8}$
        //"^1[3578]\\d{9}$"
        Matcher m = p.matcher(mobiles);
        return m.matches();

    }

    /**
     * 手机格式校验
     * @Author zhangshuai
     * @param mobiles
     * @return boolean
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:03:43
     */
    public static boolean isPhone(String mobiles) {

        //最新的验证方式
        Pattern p = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");
                                        ///^((1[3,5,8][0-9])|(14[5,7])|(17[0,6,7,8])|(19[7]))\d{8}$/
        Matcher m = p.matcher(mobiles);
        return m.matches();

    }


    /**
     * 身份证号校验
     * @Author zhangshuai
     * @param idCard
     * @return boolean
     * @Description TODO
     * @creat_date 2018年04月08日
     * @creat_time 10:04:00
     */
//    public static boolean isIdCardCheck(String idCard) {
//
//        if (!StringUtils.isNullOrEmpty(idCard) && Pattern.matches("\\d{15}|\\d{18}",idCard)) {
//            return true;
//        }
//        return false;
//    }

    /**
     * @Author zhengbo
     * @param
     * @return java.lang.String
     * @Description 获取本机IP
     * @creat_date 2018年04月17日
     * @creat_time 09:33:38
     */
    public static String getLocalIP(){
        InetAddress ia = null;
        try {
            ia = ia.getLocalHost();
            String IP = ia.getHostAddress();
            return IP;
        } catch (Exception e) {
            e.printStackTrace();
            return "本机IP获取失败!";
        }
    }

    public static void main(String args[]){

        //Timestamp t1 = new Timestamp(9223372036854775807L);2147483647(intMax)
        //System.out.println(t1);
//        Date date = new Date();
//        System.out.println(date);
        //生成UUID
         //System.out.print(getUUID());

//        int max=99999999;
//        int min=10000000;
//        Random random = new Random();
//        //System.out.println(s);
//        for (int i =0;i<20;i++){
//            int s = random.nextInt(max)%(max-min+1) + min;
//            System.out.println(s);
//        }

        //MD5加密
        String a = "123456";
        for(int i=0;i<99;i++){
            a = MD5PWD(a);
        }
        //System.out.print(eureka_client);
        //MD5PWD("yy1742000");

        //String aa="17712345678";

        //System.out.println(CommUtil.isMobile(aa));
        //System.out.println(CommUtil.isPhone(aa));

        //String bb ="130126179405040471";
        //System.out.println(CommUtil.isIdCardCheck(bb));
        //时间戳测试
        //Timestamp  timestamp = new Timestamp(new Date().getTime());
        //System.out.println(timestamp);

        //年龄计算测试
        //String birthday = "1990-03-26 09:28";
        //Date date = CommUtil.strToDate(birthday);
        //int age = CommUtil.getAge(date);
        //System.out.println(age);

        //血压血糖数据解析测试
//        String xuetang = "5A26121230118H000008123079083180719114007E2_460042726505165_864501035323536";
        //String xueya = "5A26221230118A070072117067068180928145807F5_460042538608921_866855034923888FFFFFFFFFF";
      // DeviceDataParser xuetangData = CommUtil.getDeviceData(xuetang);
       //DeviceDataParser xuyaData = DeviceUtil.getDeviceData(xueya);
//        System.out.println(xuetangData.toString());
//        System.out.println("================================");
      //System.out.println(xuyaData.toString());
        //System.out.println(CommUtil.MD5PWD("89860405191870923321"+7+3+500+"cmcc,iot,all,new"+1));
        //IP测试
        //System.out.println(CommUtil.getLocalIP());

        //时间测试
        //Calendar now = Calendar.getInstance();
        //int year = now.get(Calendar.YEAR);
        //int month = now.get(Calendar.MONTH) + 1;
        //int day = now.get(Calendar.DAY_OF_MONTH);
       // int hour = now.get(Calendar.HOUR_OF_DAY);
        //int minute = now.get(Calendar.MINUTE);
        //System.out.println("现在的时间是：公元"+year+"年"+month+"月"+day+"日"+hour+"时"+minute+"分");
//        String l = "1990-3-2 13:51:";
//        Date date = CommUtil.stt(l);
//        System.out.println(date);

         //密码转换
//        String s = "123";
//        String s1 = MD5PWD(s);
//        System.out.println(s1);

        //返回码测试
        //System.out.println(CommUtil.getDeviceReturnCode());
        //System.out.println(CommUtil.getDeviceReturnCode().length());

        //poi测试
        //ExportExcel exportExcel = new ExportExcel();
        //exportExcel.test("C:\\Users\\zlj\\Pictures\\Camera Roll","F:\\");

        //测试二进制


        //GoEasy goEasy = new GoEasy( "cdn-hangzhou.goeasy.io");
        //goEasy.publish("UPLOAD_REMOTE","新病例上传成功测试!");
    }
}
