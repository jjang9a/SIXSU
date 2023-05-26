package co.sixsu.app.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.sales.domain.OrdVO;

@Mapper
public interface ShipMapper {
	public List<OrdVO> orderingList();  //페이지 주문중인 목록 (품질요청 전 그리드 테이블)
}
