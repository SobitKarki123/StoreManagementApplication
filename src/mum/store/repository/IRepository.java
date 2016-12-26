package mum.store.repository;

import java.util.List;

public interface IRepository {

	<T> boolean add(T a);

	<T> List<T> list();

}
