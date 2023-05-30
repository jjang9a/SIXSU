package co.sixsu.app.sales.domain;

import java.util.List;

import lombok.Data;

@Data
public class GridDataVO<T> {
	List<T> createdRows;
	List<T> deletedRows;
	List<T> updatedRows;
}
