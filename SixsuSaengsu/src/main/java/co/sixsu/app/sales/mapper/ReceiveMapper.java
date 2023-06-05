package co.sixsu.app.sales.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.sales.domain.InvVO;
import co.sixsu.app.sales.domain.RecVO;

@Mapper
public interface ReceiveMapper {
 public List<RecVO> completeList(); // 모달창 완료 품목 리스트 입고전 
 
 public List<RecVO> searchReceive(RecVO vo);
}
