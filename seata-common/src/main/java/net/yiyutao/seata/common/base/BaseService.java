package net.yiyutao.seata.common.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.yiyutao.seata.common.enums.ResultEnum;

import java.util.List;

/**
 * @author masterYI
 * @date 2019/4/11 16:48
 */
public class BaseService {

    /**
     * 解析分页查询的数据
     *
     * @param list 查询的数据
     * @param <T>  查询数据结合的对象
     * @return result
     */
    public <T> BaseResult<List<T>> parsePageInfo(List<T> list) {
        BaseResult<List<T>> result = new BaseResult<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        result.setTotal(pageInfo.getTotal());
        result.setData(list);
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getSize());
        result.setResultEnum(ResultEnum.SUCCESS);
        return result;
    }

    /**
     * 分页查询
     *
     * @param pageNum    分页参数，页码
     * @param pageSize   分页参数，每页容量
     * @param t          查询条件
     * @param baseMapper 查询mapper
     * @param <T>        实体类
     * @return dataresult
     */
    public <T> BaseResult<List<T>> list(int pageNum, int pageSize, T t, BaseMapper<T> baseMapper) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = baseMapper.select(t);
        return parsePageInfo(list);
    }
}
