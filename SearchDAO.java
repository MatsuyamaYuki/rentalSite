package jp.ken.search.dao;
import java.util.List;
public interface SearchDAO<T> {
public List<T> searchList(String name,String type);
}
