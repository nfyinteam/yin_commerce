package edu.nf.shopping.goodsearch.dao;

import edu.nf.shopping.goodsearch.entity.Users;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author 彭哥
 * @date 2020/3/24
 */
public interface UsersDao extends ElasticsearchRepository<Users,String> {
}
