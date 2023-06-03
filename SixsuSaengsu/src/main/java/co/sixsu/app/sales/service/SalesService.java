package co.sixsu.app.sales.service;

import java.util.List;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.sales.domain.GridDataVO;
import co.sixsu.app.sales.domain.InvVO;
import co.sixsu.app.sales.domain.OrdVO;

public interface SalesService {
	
	List<EmpVO> getEmp1List(String keyword); //모달창 회원이름 조회
	
	List<BusVO> getBusList(); // 모달창 전체 거래처 조회
	
	List<BusVO> getBus1List(String keyword);//모달창 거래처이름 조회

	String getMakeCode();//자동으로 주문번호 등록
	
	List<OrdVO> getOrdList(); //주문상세목록
	
	List<ProductVO> getProdList(); // 상세거래처주문에 상품명을 조회
	
	int orderAdd(InvVO inv); //주문서만 등록
	
	boolean orderMod(InvVO inv); //주문서만 수정
	
	int orderModDel(InvVO inv); //주문서만 삭제
	
	boolean ordDetMod(GridDataVO<OrdVO> list); //상세 주문서만 수정
	
	/* boolean ordDetModDel(List<OrdVO> list); */
	
	List<InvVO> getOrderingList();  //페이지 마지막부분 주문중인 목록
	
	InvVO firstOrderingList(String keyword); //진행중인 주문서 행을 클릭을 하게되면 거기에 맞는 주문서가 화면에 나오도록 
	
	List<OrdVO> secondOrderingList(String keyword); //진행중인 주문서 행을 클릭을 하게되면 거기에 맞는 상세주문서가 화면에 나오도록 

	int productDel(String num);
	
	List<InvVO> searchOrder();// 조회페이지
}
