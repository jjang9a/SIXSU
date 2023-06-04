package co.sixsu.app.sales.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.sales.domain.GridDataVO;
import co.sixsu.app.sales.domain.InvVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.mapper.SalesMapper;
import co.sixsu.app.sales.service.SalesService;
@Service("salesService")
public class SalesServiceImpl implements SalesService{
@Autowired SalesMapper mapper;


@Override  //모달창 회원사원 조회
public List<EmpVO> getEmp1List(String keyword) {
	// TODO Auto-generated method stub
	return mapper.emp1List(keyword);
}

@Override // 모달차 전체 거래처 조회
public List<BusVO> getBusList() {
	// TODO Auto-generated method stub
	return mapper.busList();
}

@Override //모달창 거래처이름 조회
public List<BusVO> getBus1List(String keyword) {
	// TODO Auto-generated method stub
	return mapper.bus1List(keyword);
}

@Override //자동으로 주문번호 등록
public String getMakeCode() {
	// TODO Auto-generated method stub
	return mapper.makeCode();
}

@Override  //주문상세목록
public List<OrdVO> getOrdList() {
	// TODO Auto-generated method stub
	return mapper.ordList();
}

@Override // 상세거래처주문에 상품명을 조회
public List<ProductVO> getProdList() {
	// TODO Auto-generated method stub
	return mapper.prodList();
}

@Override //주문서만 등록
public int orderAdd(InvVO inv) {
	inv.setOrdStat("ORD_ING");
	//order master 등록후 
	mapper.orderAdd(inv);
	
	//order 상세 주문 등록
	int count =0;
	List<OrdVO> list = inv.getList();
	for(int i=0; i<list.size(); i++) {
         list.get(i).setOrdStatDet("ORD_DET_ING");
         list.get(i).setOrdId(inv.getOrdId());
	     count += mapper.ordDetAdd(list.get(i));
	}
	return count;
}


//페이지 마지막부분 주문중인 목록
@Override
public List<InvVO> getOrderingList() {
	// TODO Auto-generated method stub
	return mapper.orderingList();
}

@Override
public InvVO firstOrderingList(String keyword) {
	// TODO Auto-generated method stub
	return mapper.firstOrderingList(keyword);
}

@Override
public List<OrdVO> secondOrderingList(String keyword) {
	// TODO Auto-generated method stub
	return mapper.secondOrderingList(keyword);
}

@Override
public boolean orderMod(InvVO inv) {
	// TODO Auto-generated method stub
	return mapper.orderMod(inv) == 1;
}

@Override
public boolean ordDetMod(GridDataVO<OrdVO> vo) {
	
	int count =0;
	//삭제
	List<OrdVO>  list = vo.getDeletedRows();
	for (OrdVO i : list) {
		mapper.productDel(i.getOrdDetId());
	}
 System.out.println("삭제완료");
	//수정
	list = vo.getUpdatedRows();	
	for(int i=0; i<list.size(); i++) {         
		count += mapper.ordDetMod(list.get(i));
	}
	 System.out.println("수정와뇰");   
	//등록
	list = vo.getCreatedRows();
	for(int i=0; i<list.size(); i++) {
         list.get(i).setOrdStatDet("ORD_DET_ING");
	     count += mapper.ordDetAdd(list.get(i));
	}	  System.out.println("등록완료");  
	   return count >=1;
	
}

@Override
public int productDel(String num) {
	// TODO Auto-generated method stub
	return mapper.productDel(num);
}

@Override
@Transactional
public int orderModDel(InvVO inv) {
	// TODO Auto-generated method stub
	int result = mapper.ordDetModDel(inv);
	 result +=  mapper.orderModDel(inv);
	return result;
	
}

@Override
public List<InvVO> searchOrder(InvVO vo) {
	// TODO Auto-generated method stub
	return mapper.searchOrder(vo);
}



/*@Override
public boolean ordDetModDel(List<OrdVO> list) {
	 int count =0;
	   for(int i=0; i<list.size(); i++) {
	      if(list.get(i).getOrdDetId() == null || list.get(i).getOrdDetId().equals("")){
	         continue;
	      }else {
	         
	         String bir = list.get(i).getOrdDetId();
	         String id= bir.substring(0,13);
	         list.get(i).setOrdId(id);
	         
	   count += mapper.ordDetModDel(list.get(i));
	      }
	   }
	   return count >=1;
	*/

}
