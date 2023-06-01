package co.sixsu.app.sales.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.sales.mapper.ReturnMapper;
import co.sixsu.app.sales.service.ReturnService;

@Service("returnService")
public class ReturnServiceImpl implements ReturnService {
@Autowired ReturnMapper mapper;
}
