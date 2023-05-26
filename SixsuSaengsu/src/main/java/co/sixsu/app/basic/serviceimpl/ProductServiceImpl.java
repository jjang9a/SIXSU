package co.sixsu.app.basic.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.mapper.ProductMapper;
import co.sixsu.app.basic.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {

	@Autowired ProductMapper mapper;
	
}
