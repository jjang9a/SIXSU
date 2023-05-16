package co.sixsu.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.sixsu.app.mapper.EquipmentMapper;



@Service
public class EquipmentService {
	
	@Autowired private EquipmentMapper mapper;
	
//	public List<EquContVO> getEquList(){
//		return mapper.getEquList();
//	}
}
