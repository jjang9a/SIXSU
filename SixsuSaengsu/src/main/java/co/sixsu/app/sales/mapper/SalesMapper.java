package co.sixsu.app.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.sales.domain.InvVO;
import co.sixsu.app.sales.domain.OrdVO;

@Mapper
public interface SalesMapper {
	public List<OrdVO> inventorySearch(); //재고현황의 총재고량 조회
	
	
	
	
	public List<EmpVO> empList(); // 모달 창의 사원목록
	
	public List<EmpVO> emp1List(String keyword);// modal 창 사원목록 이름별 조회
	
	public List<BusVO> busList(); // 모달 창의 거래처목록
	
	public List<BusVO> bus1List(String keyword); //모달창 거래처이름 조회

	public String makeCode();//자동으로 주문번호 등록

	public List<OrdVO> ordList(); //주문상세목록 
	
	public List<ProductVO> prodList(); // 주문상세목록에 상품 모달
	
	public int orderAdd(InvVO inv); //주문서만 등록
	public int orderMod(InvVO inv); //주문서만 수정
	public int orderModDel(InvVO inv); //주문서만 삭제
	
	public int ordDetAdd(OrdVO code);//상세주문서등록
	public int ordDetMod(OrdVO code);//상세주문서수정
	public int ordDetModDel(InvVO inv);//상세주문서삭제
	
	public List<InvVO> orderingList(); //페이지 마지막부분 주문중인 목록
	
	public InvVO firstOrderingList(String keyword); //진행중인 주문서 행을 클릭을 하게되면 거기에 맞는 주문서가 화면에 나오도록 
	
	public List<OrdVO> secondOrderingList(String keyword); //진행중인 주문서 행을 클릭을 하게되면 거기에 맞는 상세주문서가 화면에 나오도록 
	
	int productDel(String reqId);

	
	
	public List<InvVO> searchOrder(InvVO vo); // 조회페이지
	
}

