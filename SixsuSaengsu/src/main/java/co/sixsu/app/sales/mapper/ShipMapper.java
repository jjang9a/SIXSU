package co.sixsu.app.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.sales.domain.LotVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.domain.ShipVO;

@Mapper
public interface ShipMapper {
	public List<OrdVO> orderingList();  //페이지 주문중인 목록 (품질요청 전 그리드 테이블)
	public List<LotVO> lotProducts(String keyword); //모달창 품목별 lot 재고현황
	public int totalQt(String keyword); //모달창에 자동으로 총수량이 뜨는 기능
    
	public int shipPro(OrdVO ord);
	public int insertProShip(ShipVO vo);
	public int updateCpLot(LotVO vo);
	public List<ShipVO> readyShipList(String keyword);
	
	
	public void completeShip(String ordDetId);
	
	
	
}
