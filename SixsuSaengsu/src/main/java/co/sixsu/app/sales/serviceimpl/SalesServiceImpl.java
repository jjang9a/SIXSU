package co.sixsu.app.sales.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.sales.domain.InvVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.mapper.SalesMapper;
import co.sixsu.app.sales.service.SalesService;
@Service("salesService")
public class SalesServiceImpl implements SalesService{
@Autowired SalesMapper mapper;

@Override   // 모달창 전체 사원 조회
public List<EmpVO> getEmpList() {
	
	return mapper.empList();
}

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
public InvVO orderAdd(InvVO inv) {
	inv.setOrdStat("진행중");
	mapper.orderAdd(inv);
	return inv;
}



@Override // 상세주문서만 수정
public boolean ordDetAdd(List<OrdVO> list) {
   int count =0;
   for(int i=0; i<list.size(); i++) {
      if(list.get(i).getOrdDetId() == null || list.get(i).getOrdDetId().equals("")){
         continue;
      }else {
         list.get(i).setOrdStatDet("진행중");
         String bir = list.get(i).getOrdDetId();
         String id= bir.substring(0,13);
         list.get(i).setOrdId(id);
         System.out.println(list.get(i));
   count += mapper.ordDetAdd(list.get(i));
      }
   }
   return count >=1;
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
public boolean ordDetMod(List<OrdVO> list) {
	 int count =0;
	   for(int i=0; i<list.size(); i++) {
	      if(list.get(i).getOrdDetId() == null || list.get(i).getOrdDetId().equals("")){
	         continue;
	      }else {
	         
	         String bir = list.get(i).getOrdDetId();
	         String id= bir.substring(0,13);
	         list.get(i).setOrdId(id);
	         System.out.println(list.get(i));
	   count += mapper.ordDetMod(list.get(i));
	      }
	   }
	   return count >=1;
	
}

@Override
public int productDel(String num) {
	// TODO Auto-generated method stub
	return mapper.productDel(num);
}

@Override
public boolean orderModDel(InvVO inv) {
	// TODO Auto-generated method stub
	return mapper.orderModDel(inv) == 1;
}

@Override
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
	
}
}
