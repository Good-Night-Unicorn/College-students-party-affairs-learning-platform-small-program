package com.dao;

import com.entity.KaoqinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoqinView;

/**
 * 签到信息 Dao 接口
 *
 * @author 
 */
public interface KaoqinDao extends BaseMapper<KaoqinEntity> {

   List<KaoqinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
