package net.yiyutao.seata.common.base;

import java.util.List;

/**
 * @author masterYI
 * @date 2019/4/11 16:46
 */
public interface BaseMapper<T> {

    /**
     * 根据主键id删除数据
     *
     * @param key 主键id
     * @return 删除行数
     */
    int deleteByPrimaryKey(Object key);

    /**
     * 新增数据
     *
     * @param record 新增的数据信息
     * @return 新增行数
     */
    int insert(T record);

    /**
     * 新增数据，只插入指定字段的数据
     *
     * @param record 新增的数据信息
     * @return 新增行数
     */
    int insertSelective(T record);

    /**
     * 根据主键id查询数据
     *
     * @param key 主键id
     * @return 查询的数据对象
     */
    <K> T selectByPrimaryKey(K key);

    /**
     * 根据主键id更新指定字段的值
     *
     * @param record 更新的数据信息
     * @return 更新的行数
     */
    int updateByPrimaryKeySelective(T record);

    /**
     * 根据主键id更新所有字段的值
     *
     * @param record 更新的数据信息
     * @return 更新的行数
     */
    int updateByPrimaryKey(T record);

    /**
     * 根据查询条件查询数据
     *
     * @param record 查询条件
     * @return 查询数据集合
     */
    List<T> select(T record);
}
