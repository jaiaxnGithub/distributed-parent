package com.jaiaxn.distributed.system.config;

import com.jaiaxn.distributed.commom.config.DynamicDataSourceManager;
import com.jaiaxn.distributed.commom.dto.CfgDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @author: wang.jiaxin
 * @date: 2019年05月09日
 * @description: 动态数据源
 **/
@Service
public class DynamicDatasourceService {

    /**
     * 执行动态sql语句返回list
     *
     * @param cfgDataSource 数据源
     * @param sql           执行脚本
     * @return 数据列表
     */
    public List<Map<String, Object>> executeDynamicSqlForList(CfgDataSource cfgDataSource, String sql, Object[] objects) {
        JdbcTemplate jdbcTempleDynamic = DynamicDataSourceManager.getDataSourcePool(cfgDataSource);
        return jdbcTempleDynamic.queryForList(sql, objects);
    }

    /**
     * 动态执行sql语句返回map
     *
     * @param cfgDataSource 数据源
     * @param sql           执行脚本
     * @return 单行数据
     */
    public Map<String, Object> executeDynamicSqlForMap(CfgDataSource cfgDataSource, String sql, Object[] objects) {
        JdbcTemplate jdbcTempleDynamic = DynamicDataSourceManager.getDataSourcePool(cfgDataSource);
        return jdbcTempleDynamic.queryForMap(sql, objects);
    }

    /**
     * 动态执行sql返回long类型
     *
     * @param cfgDataSource 数据源
     * @param sql           执行脚本
     * @param objects       参数
     * @return 单行单列Long类型数据
     */
    public Long executeDynamicSqlForLong(CfgDataSource cfgDataSource, String sql, Object[] objects) {
        JdbcTemplate jdbcTempleDynamic = DynamicDataSourceManager.getDataSourcePool(cfgDataSource);
        return jdbcTempleDynamic.queryForObject(sql, objects, Long.class);
    }

    /**
     * 动态执行sql返回的列key
     *
     * @param cfgDataSource 数据源
     * @param sql           执行脚本
     * @return 列的key值
     */
    public Map executeDynamicSqlForRowSet(CfgDataSource cfgDataSource, String sql) {
        JdbcTemplate jdbcTempleDynamic = DynamicDataSourceManager.getDataSourcePool(cfgDataSource);
        SqlRowSet rowSet = jdbcTempleDynamic.queryForRowSet(sql);
        int colCount = rowSet.getMetaData().getColumnCount();
        String[] columns = rowSet.getMetaData().getColumnNames();
        Map<String, String> result = new LinkedHashMap<String, String>();
        for (int i = 0; i < colCount; i++) {
            result.put(columns[i], "");
        }
        return result;
    }

    /**
     * 分页查询
     *
     * @param cfgDataSource 数据源
     * @param sql           执行脚本
     * @param offset        偏移量
     * @param limit         每页显示的行数
     * @return 数据列表
     */
    public List<Map<String, Object>> getDataByPageForOracle(CfgDataSource cfgDataSource, String sql, int offset, int limit, ArrayList<Object> querySqlParam) {
        JdbcTemplate jdbcTempleDynamic = DynamicDataSourceManager.getDataSourcePool(cfgDataSource);
        int startNum = offset + 1;
        int endNum = offset + limit;
        StringBuffer sb = new StringBuffer();
        sb.append("select * from (select rownum as idx,tt.* from ( ").append(sql).append(" ) tt ) ttt where ttt.idx between ").append(startNum).append(" and ").append(endNum);
        return jdbcTempleDynamic.queryForList(sb.toString(), querySqlParam.toArray());
    }

    /**
     * mysql分页
     *
     * @param cfgDataSource 数据源
     * @param sql           执行脚本
     * @param offset        开始显示的行
     * @param limit         每页显示多少行
     * @return 数据列表
     */
    public List<Map<String, Object>> getDataByPageForMysql(CfgDataSource cfgDataSource, String sql, int offset, int limit) {
        JdbcTemplate jdbcTempleDynamic = DynamicDataSourceManager.getDataSourcePool(cfgDataSource);
        StringBuffer sb = new StringBuffer();
        sb.append("select * from ( ").append(sql).append(" ) t limit  ").append(offset).append(" , ").append(limit);
        return jdbcTempleDynamic.queryForList(sb.toString());
    }

}
