package com.test.spring.mapper;

import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

	void updateStorage(@Param("productId") int productId, @Param("storage") int storage);

}
