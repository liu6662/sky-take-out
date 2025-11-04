package com.sky.mapper;

import com.sky.entity.DishFlavor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorsMapper {
    /**
     * 批量插入口味数据
     *
     * @param flavors
     */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除对应的口味数据
     *
     * @param dishid
     */
    @Delete("delete from dish_flavor where dish_id = #{dishid}")
    void deleteByDishId(Long dishid);

    /**
     * 根据菜品id批量删除对应的口味数据
     *
     * @param dishids
     */
    void deleteByDishIds(List<Long> dishids);

    /**
     * 根据菜品id查询对应的口味数据
     *
     * @param dishid
     * @return
     */
    @Select("select * from dish_flavor where dish_id = #{dishid}")
    List<DishFlavor> getByDishId(Long dishid);
}
