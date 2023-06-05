package co.sixsu.app.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.sales.domain.RetVO;
import co.sixsu.app.sales.domain.ShipCompVO;

@Mapper
public interface ReturnMapper {
	public List<ShipCompVO> orderComplete(String keyword);
	public List<RetVO> searchReturn(RetVO vo);
}
