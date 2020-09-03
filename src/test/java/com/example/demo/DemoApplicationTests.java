package com.example.demo;

import com.example.demo.bean.Employee;
import com.example.demo.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试点对点（单播）
     */
    @Test
    public void sendDirect(){
        //int id, String lastName, String email, int gender, int did
        Employee employee = new Employee(1, "wangjun", "wj@qq.com", 1, 10);
        rabbitTemplate.convertAndSend("test.direct","employee.new",employee);
    }

    /**
     * 测试广播
     */
    @Test
    public void sendFanout(){
        Employee employee = new Employee(1, "wangjun", "wj@qq.com", 1, 10);
        rabbitTemplate.convertAndSend("test.fanout","",employee);
    }

    @Test
    public void sendTopic(){
        Employee employee = new Employee(1, "wangjun", "wj@qq.com", 1, 10);
        rabbitTemplate.convertAndSend("test.topic","#.new",employee);
    }

    @Test
    public void getDirect(){
        Object o = rabbitTemplate.receiveAndConvert("employee.new");
        System.out.println(o.getClass());
        System.out.println(o.toString());
    }


    public void testUpdate(){
        System.out.println(employeeMapper.updateEmployee(new Employee(1, "wangjun", "wangjun@qq.com", 0, 1)));
    }

    @Test
    public void contextLoads() {
        System.out.println(employeeMapper.getByEmployeeId(1));
    }
}
