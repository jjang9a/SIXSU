package co.sixsu.app.sales.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.sales.domain.ShipCompVO;
import co.sixsu.app.sales.mapper.ReturnMapper;
import co.sixsu.app.sales.service.ReturnService;

@Service("returnService")
public class ReturnServiceImpl implements ReturnService {
@Autowired ReturnMapper mapper;

@Override
public List<ShipCompVO> orderComplete(String keyword) {
	// TODO Auto-generated method stub
	return mapper.orderComplete(keyword);
}


}
