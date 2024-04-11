package org.example.pr14vmmybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.pr14vmmybatis.dto.ProductDto;

import java.util.List;
import java.util.Optional;

@Mapper   //@Mapper : 인터페이스 DAO와 MyBatis XML와 연결하는 용도
public interface IProductDao {
    //list (select *)
    public List<ProductDto> list();

    public Optional<ProductDto> findById(long id);
    //insert
    public int insert(ProductDto dto);

    public int update(int id, String name, int price);

    public int count();
    //delete
    public int delete(int id);

}