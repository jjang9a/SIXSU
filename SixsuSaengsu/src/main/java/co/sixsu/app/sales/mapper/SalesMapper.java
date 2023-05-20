package co.sixsu.app.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.sales.domain.OrdVO;

@Mapper
public interface SalesMapper {
	
	public List<EmpVO> empList(); // 모달 창의 사원목록
	
	public List<EmpVO> emp1List(String keyword);// modal 창 사원목록 이름별 조회
	
	public List<BusVO> busList(); // 모달 창의 거래처목록
	
	public List<BusVO> bus1List(String keyword); //모달창 거래처이름 조회

	public String makeCode();//자동으로 주문번호 등록

	public List<OrdVO> ordList();
	
	public List<ProductVO> prodList();
}

