package com.atguigu.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加 修改 删除 操作
    @Test
    public void testUpdate() {

        String sql = "INSERT INTO t_emp VALUES (NULL,?,?,?)";
        Object[] params = new Object[]{"林平之", 20, "未知"};
        // int rows = jdbcTemplate.update(sql, params);

        sql = "UPDATE t_emp SET name = ? where id = ?";
        // int rows = jdbcTemplate.update(sql, "林平芝", 3);

        sql = "DELETE FROM t_emp where id = ?";

        int rows = jdbcTemplate.update(sql, 3);

        System.out.println(rows);

    }

    @Test
    public void testSelectObject() {
        // 写法 1
        String sql = "SELECT * FROM t_emp WHERE id = ?";
        // Emp res = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
        //     Emp emp = new Emp();
        //     emp.setId(rs.getInt("id"));
        //     emp.setName(rs.getString("name"));
        //     emp.setAge(rs.getInt("age"));
        //     emp.setSex(rs.getString("sex"));
        //     return emp;
        // }, 1);
        // System.out.println(res.toString());

        // 写法 2
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 1);
        System.out.println(emp.toString());
    }

    @Test
    public void testSelectList() {
        String sql = "SELECT * FROM t_emp";
        List<Emp> res = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(res);
    }

    // 查询返回单个值
    @Test
    public void testSelectValue() {
        String sql = "SELECT COUNT(*) FROM t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
}
