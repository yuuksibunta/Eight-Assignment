package com.example.name;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NameMapper {
    @Select("SELECT * FROM names")
    List<Name> findAll();

    @Select("SELECT * FROM names WHERE name LIKE CONCAT(#{name}, '%')")
    List<Name> findByNameStartingWith(String prefix);

    @Select("SELECT * FROM names") // このアノテーションの中に、実際のクエリを記述する
    List<Name> findAllNames();
}
