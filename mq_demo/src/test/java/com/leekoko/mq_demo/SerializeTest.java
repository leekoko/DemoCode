package com.leekoko.mq_demo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class SerializeTest {


    @Test
    public void kryoCommonTest() throws FileNotFoundException {
        Log.set(1);
        Kryo kryo = new Kryo();
        User user = new User("123", "kryo");
        Output output = new Output(new FileOutputStream("D://userKryo.txt"));
        kryo.writeObject(output, user);
        output.close();

        Input input = new Input(new FileInputStream("D://userKryo.txt"));
        User newUser = kryo.readObject(input, User.class);
        input.close();
        assert "kryo".equals(newUser.getName());
    }


    @Test
    public void simpltKryoTest() throws IOException {
        Log.set(1);
        Kryo kryo = new Kryo();
        User user = new User("123", "kryo");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output oos = new Output(baos);
        kryo.writeObject(oos, user);

        oos.flush();
        byte[] var3 = baos.toByteArray();
//        baos.close();
        Input input = new Input(var3);
        User user1 = kryo.readObject(input, User.class);

        assert user1.getName().equals("kryo");
    }


    @Test
    public void nytKryoTest(){
        Kryo kryo = new Kryo();
        BusAffairDetail busAffairDetail = new BusAffairDetail();
        busAffairDetail.setCode("1111");
        busAffairDetail.setBudgetSummaryCode("2222");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Output oos = new Output(baos);
        kryo.writeClassAndObject(oos, busAffairDetail);
        oos.close();
        byte[] var3 = baos.toByteArray();
        Input input=new Input(var3);
        BusAffairDetail busAffairDetail2 = (BusAffairDetail) kryo.readClassAndObject(input);
        System.out.println(busAffairDetail2.getCode());
        assert (var3.length > 0);
    }

    @Test
    public void demoTest(){
//        Mail m=new Mail();
//        m.setId(100);
//        m.setTitle("test");
//        m.setContent("this is test content");
//        m.setCreatedTime(new Date());

        BusAffairDetail busAffairDetail = new BusAffairDetail();
        busAffairDetail.setCode("1111");
        busAffairDetail.setBudgetSummaryCode("2222");


        //基于Kryo框架将对象序列化
        Kryo kryo=new Kryo();


        //将默认类的自动注册功能关闭(默认会将类全名序列化)
//        kryo.setRegistrationRequired(false);
        ByteArrayOutputStream bos=//内置可扩容数组
                new ByteArrayOutputStream();
        Output output=new Output(bos);
        kryo.writeObject(output, busAffairDetail);
        output.close();
        System.out.println("序列化ok");

        byte[] var3 = bos.toByteArray();
        System.out.println((var3.length > 0));

        //基于Kryo框架将对象反序列化
//        byte[] data=bos.toByteArray();
//        Input input=new Input(data);
//        Mail m2=kryo.readObject(input,Mail.class);
//        input.close();
//        System.out.println(m2);
    }


}
